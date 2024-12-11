package BEL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.github.cdimascio.dotenv.Dotenv;
import com.google.gson.*;

//TODO: !! add max tokens

public class openai_api {

    Dotenv env = Dotenv.configure().directory("./conf").load();
    static HttpURLConnection apiConnection = null ;
    jsob usrJson = null;

    // ===== sending a prompt through the api
    public String sendPrompt(String prompt)
    {
        try{
            // converts prompt string to JSON object
            // then creates prompt && response JSON file
            jsob promptJson = new jsob();

            // creates the JSON files
            genPromptJson();
            genResponseJson(usrJson.toString());

            // check JSON files if getting unexpected responses
            return toStringResponse();

        }catch (IOException e){
            throw new RuntimeException(e);

        }
    }

    public void setStory(String storyTone, String storyDetails){
        usrJson.storySetup(storyTone,storyDetails);
    }
    // ===== creates sending prompt's json file =======
    private void genPromptJson() throws IOException {

        // Takes JSON obj and converts it to JSON file
        FileWriter writer = new FileWriter("./conf/prompting.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(usrJson, writer);
        writer.close();

    }

    // ====== creates the recieved message json file =======
    private void genResponseJson(String promptString) throws IOException {

        FileWriter writer = new FileWriter("./conf/response.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // sends prompt to API and recieves API response
        OutputStreamWriter osw = new OutputStreamWriter(apiConnection.getOutputStream());
        osw.write(promptString);
        osw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while((line = br.readLine()) != null){
            response.append(line);
        }

        // convert response to JSON object && writing to JSON file
        JsonElement convertedString = JsonParser.parseString(response.toString());
        gson.toJson(convertedString, writer);
        writer.close();
    }
    // ======= generates and returns the string version of the response =======
    private String toStringResponse() throws FileNotFoundException {
        // makes json object so that gson can parse it
        Gson gson = new Gson();
        JsonObject wholeJsonObj = gson.fromJson(new FileReader("./conf/response.json"), JsonObject.class);

        // navigates to messages json array and converts "content" to JSON obj
        JsonObject jobj = wholeJsonObj
                .getAsJsonArray("choices")
                .get(0)
                .getAsJsonObject()
                .getAsJsonObject("message");

        // turns the response to a string array, formats, then returns it
        String[] unFormatedResponse = jobj.get("content").getAsString().split(" ");
        StringBuilder response = new StringBuilder();
        int spaceCount =0;
        for(String elms : unFormatedResponse)
        {
            if(spaceCount == 5)
            {
                response.append(elms + "\n");
                spaceCount =0;
            }else
            {
                response.append(elms + " ");
            }
            spaceCount++;
        }

        usrJson.addMessage("assistant", response.toString());
        return response.toString();
    }

    // ====== sets the api url connection
    public openai_api() throws IOException
    {
        usrJson = new jsob();
        try {
            URL apiUrl = new URL(env.get("OPEN_AI_API_URL"));
            apiConnection = (HttpURLConnection) apiUrl.openConnection();
            apiConnection.setRequestMethod("POST");
            apiConnection.setRequestProperty("Authorization", "Bearer " + env.get("OPENAI_API_KEY"));
            apiConnection.setRequestProperty("Content-Type", "application/json");
            apiConnection.setDoOutput(true);

        }catch(IOException e)
        {
            throw new IOException(e);
        }
    }
    // ========= custom jsonObject for gson ========
    public class jsob
    {
        String model = null;
        List<Map<String, String>> messages = null;

        jsob() throws IOException {
            model = "gpt-3.5-turbo";
            String role = "user";
            messages = new ArrayList<Map<String, String>>();

            String systemContent = """
            You are a Dungeon Master for a Dungeons & Dragons game.
            Your role is to bring provided details to life by vividly describing locations, NPCs, enemies, and their interactions with the players. 
            Keep responses concise, limited to a small paragraph of 50 words maximum.
            Where applicable, include stat changes in the last line in the format: Player{health:-10, stamina:+10, dex:+2}, <NPC Name>{health:-13}.
             """;

            addMessage("system", systemContent);

        }
        // === add message ===
        public void storySetup(String tone, String story)
        {
            String userPreferences = "the game's tone is : " + tone + ". some brief story details : " + story;
            addMessage("user", userPreferences);
        }
        public void addMessage(String role, String content)
        {
            Map<String, String> messageContent = new HashMap<>();
            messageContent.put("role", role);
            messageContent.put("content", content);
            messages.add(messageContent);
        }

        // === converts to string for api ===
        @Override
        public String toString() {
            try {

                String convertToString;
                convertToString = new String(Files.readAllBytes(Paths.get("./conf/prompting.json")));
                return convertToString;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

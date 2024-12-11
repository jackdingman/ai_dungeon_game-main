package GUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//Background Panel
public class CustomPanel extends JPanel {
    private Image background;
    private ImageIcon scroll;


    public CustomPanel(){

        try{
            background = ImageIO.read(new File("src/GUIPictures/paperBackground.png"));

            Image image = new ImageIcon ("src/GUIPictures/paperScroll.png").getImage();
            Image scaled = image.getScaledInstance(700,700,Image.SCALE_SMOOTH);
            scroll = new ImageIcon(scaled);


        } catch(IOException e){
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(background != null){
            g.drawImage(background, 0, 0, null);
        }

        if(scroll != null){
            g.drawImage(scroll.getImage(), 420, 30, null);
        }


    }


}

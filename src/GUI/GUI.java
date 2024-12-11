package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.io.File;
import javax.swing.plaf.basic.BasicScrollBarUI;


import static java.awt.Transparency.TRANSLUCENT;

public class GUI{

    private JFrame frame;
    private CustomPanel backPanel;
    private UserPanel userPanel;
    private JPanel textPanel;
    private JTextArea storyText;

    public GUI() {

        //Setting up JFrame
        frame = new JFrame("AI Dungeon Crawler"); //Title of the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080); //Sizing
        frame.setLayout(null); //Manual Position

        //Custom Panel to Customize Background
        backPanel = new CustomPanel();
        backPanel.setLayout(null); //So I can customize manually
        backPanel.setBounds(0,0,1920,1080); //Covers whole frame
        backPanel.setOpaque(false);
        frame.add(backPanel); //Adds Custom Panel to JFrame

        //Making userPanel
        userPanel = new UserPanel();
        backPanel.add(userPanel.getUserPanel()); //Adds UserPanel to BackPanel


        //JPanel for Story Text and Scroll Bar
        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setOpaque(false);
        textPanel.setBounds(0,0,1920,1080);

        //Story Text Display (need to figure out how to get story stuff here)
        storyText = new JTextArea();
        storyText.setEditable(false); //Makes text not editable onscreen
        storyText.setOpaque(false); //Makes text's background transparent
        storyText.setLineWrap(true);
        storyText.setFont(new Font("Dialog",Font.PLAIN,14)); //Font Settings
        storyText.setWrapStyleWord(true);
        storyText.setBounds(640,150,300,650); //Parameters
        textPanel.add(storyText);

        //JScrollPane for Story Text
        JScrollPane scrollPane = new JScrollPane(storyText);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setOpaque(false);
        scrollPane.getHorizontalScrollBar().setOpaque(false);
        scrollPane.setBounds(595,155,350,450);

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(235,222,202);
            }
        });

        textPanel.add(scrollPane);


        backPanel.add(textPanel);



        //Story Tet and Animation
        //AI Response should replace test
        String test = "Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps. Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.Hello! This is a test! This should be animated and coming out that way! Lalala i am so fun! Ahhhh look at me go! Yknow what's so funny? Airplane food! Yeah and minion memes. Derps.";

        Timer timer = new Timer(15, new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(i < test.length())
                {
                    storyText.append(String.valueOf(test.charAt(i)));
                    i++;
                }
                else {
                    ((Timer)e.getSource()).stop();

                }
            }
        });



        timer.start();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        GUI tester = new GUI();
    }



    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           @Override
            public void run() {
               try {
                   new GUI();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               } catch (FontFormatException e) {
                   throw new RuntimeException(e);
               }
           }
        });

    }
*/


}


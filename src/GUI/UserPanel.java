package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//User Input Panel
public class UserPanel extends JPanel {
    private JPanel userPanel;
    private JButton enterButton;
    private JTextField userInput;
    private String input;

    public UserPanel() {
        //JPanel for Enter Button And Text Box
        userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setOpaque(false);
        userPanel.setBounds(0,0,1920,1080); //Parameters

        //User Input
        userInput = new JTextField();
        userInput.setBounds(570,670,300,30);
        userInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        userPanel.add(userInput);

        //Enter Button
        enterButton = new JButton();

        enterButton.setBounds(875,660,100,50);
        ImageIcon wooden = new ImageIcon("src/GUIPictures/woodButton.png");
      ;

        enterButton.setIcon(wooden);
        enterButton.setVerticalAlignment(SwingConstants.CENTER);
        userPanel.add(enterButton);

        //Enter Button actionListener
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = userInput.getText(); //Gets text when button is pressed, need to get this to API
                userInput.setText("");
            }
        });


    }

    public JPanel getUserPanel() {
        return userPanel;
    }

}

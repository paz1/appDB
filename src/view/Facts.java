package view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Facts extends JDialog{
    Color color = new Color(131,24 ,11);
    public Facts(Frame owner, boolean modal,int score) {
        super(owner, modal);
        setBackground(color);
        //int width = General.screenWidth / 3;
        //int height = General.screenHeight / 2;
        int width = General.width;
        int height = General.height;
        setBounds((General.screenWidth - width) / 2, (General.screenHeight - height) / 2, width, height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // todo hayadata
//        JLabel messageLabel = new JLabel("<html>question</html>");
//        messageLabel.setBackground(color);
//        messageLabel.setForeground(Color.WHITE);
//        messageLabel.setFont(new Font("Tahoma", Font.BOLD, height / 20));
//        messageLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
//        messageLabel.setSize(new Dimension(height / 2, height / 3));
//        messageLabel.setLocation(width / 10, width / 6);
//        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
//        contentPane.add(messageLabel);

        int textFieldHeight = height / 30;
        JButton exitGame = new JButton("exit game");
        //Color color1 = new Color(146,45,18);
        Color color1 = new Color(146, 45, 18);
        exitGame.setBackground(color1);
        exitGame.setForeground(Color.ORANGE);
        exitGame.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        exitGame.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
        exitGame.setSize(new Dimension(height / 2, height / 2));
        exitGame.setLocation(height / 6, width / 6);
        exitGame.setFocusPainted(false);
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                exit(0);
            }
        });
        JButton menuButton = new JButton("back to menu");
        //Color color1 = new Color(146,45,18);
        menuButton.setBackground(color1);
        menuButton.setForeground(Color.ORANGE);
        menuButton.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        menuButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
        menuButton.setSize(new Dimension(height / 2, height / 2));
        menuButton.setLocation(height , width / 6);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            }
        });
        JLabel scoreLabel = new JLabel("<html>" + "your score is: "+score + "</html>");
        scoreLabel.setBackground(color);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, height / 12));
        scoreLabel.setSize(new Dimension(width/2+450, height/3 ));
        //scoreLabel.setLocation(width / 2-200, 20);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        contentPane.add(scoreLabel);
        contentPane.add(menuButton);
        contentPane.add(exitGame);



    }
}

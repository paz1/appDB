package view;
import controller.controller;
import model.queue_question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import static java.lang.System.exit;
import controller.controller;
import model.Question_Answer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Problem extends JDialog {
    Color color = new Color(178,132 ,190);
    public Problem(Frame owner, boolean modal) {
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

        String massage="connection error.please try again later";
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>"+massage+"</html>");
        messageLabel.setBackground(color);
        Color color1 = new Color(146, 45, 18);
        messageLabel.setForeground(color.WHITE);
        messageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, height / 10));

        messageLabel.setBorder(new MatteBorder(2, 2, 2, 2,color));
        messageLabel.setSize(new Dimension(width , height / 3));
        messageLabel.setLocation(0, width / 3+2);
        //messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(messageLabel);

        JButton exitGame = new JButton("exit game");
        //Color color1 = new Color(146,45,18);
        //Color color1 = new Color(146, 45, 18);
        exitGame.setBackground(color1);
        exitGame.setForeground(Color.WHITE);
        exitGame.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        exitGame.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.PINK));
        exitGame.setSize(new Dimension(height / 2, height / 2-65));
        exitGame.setLocation((height / 6)+30, (width / 6)-30);
        exitGame.setFocusPainted(false);
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                exit(0);

            }
        });
}

}

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
        messageLabel.setSize(new Dimension(width , height / 2));
        messageLabel.setLocation(0, width / 3+2);
        //messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(messageLabel);
}

}

package view;


import model.queue_question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import static java.lang.System.exit;

import model.Question_Answer;

public class Facts extends JDialog{
    Color color = new Color(131,24 ,11);
    public Facts(Frame owner, boolean modal, int score, queue_question q,Question_Answer qu) {
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
        //did you know:
        String know=qu.getGood_to_know();
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>"+"good to know:" +"<br>"+know+"</html>");
        messageLabel.setBackground(color);
        messageLabel.setForeground(Color.orange);
        messageLabel.setFont(new Font("Tahoma", Font.BOLD, height / 18));
        Color color1 = new Color(146, 45, 18);
        //messageLabel.setBorder(new MatteBorder(2, 2, 2, 2,);
        messageLabel.setSize(new Dimension(height , height / 3-20));
        messageLabel.setLocation(width / 3-110, width / 3+2);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);

        contentPane.add(messageLabel);



        int textFieldHeight = height / 30;
        JButton exitGame = new JButton("exit game");
        //Color color1 = new Color(146,45,18);
        //Color color1 = new Color(146, 45, 18);
        exitGame.setBackground(color1);
        exitGame.setForeground(Color.ORANGE);
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
        JButton menuButton = new JButton("back to menu");
        //Color color1 = new Color(146,45,18);
        menuButton.setBackground(color1);
        menuButton.setForeground(Color.ORANGE);
        menuButton.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        menuButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.PINK));
        menuButton.setSize(new Dimension(height / 2, height / 2-65));
        menuButton.setLocation(height+10 , (width / 6)-30);
        Timer timer = new Timer(500, new ActionListener() {
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                if (counter % 2 == 0) {
                    menuButton.setBackground(new Color(146, 45, 18));
                } else {
                    menuButton.setBackground(new Color(90, 0, 0));
                }
            }
        });
        timer.start();
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                MainWindow frame = new MainWindow(q);
                frame.setVisible(true);
            }

        });
//        JButton knowButton = new JButton("good to know");
//        //Color color1 = new Color(146,45,18);
//        knowButton.setBackground(color1);
//        knowButton.setForeground(Color.ORANGE);
//        knowButton.setFont(new Font("Tahoma", Font.BOLD, height / 15));
//        knowButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
//        knowButton.setSize(new Dimension(height / 3, height / 3));
//        knowButton.setLocation(height+100 , width / 6);
//        knowButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                setVisible(false);
//                MainWindow frame = new MainWindow(q);
//                frame.setVisible(true);
//            }
//        });
       // String know= Question_Answer q
//        JLabel good_to_know = new JLabel("quicky");
//        good_to_know.setForeground(new Color(146,45,18));
//        good_to_know.setFont(new Font("Ariel", Font.BOLD, height /3));
//        good_to_know.setSize(good_to_know.getPreferredSize());
//        good_to_know.setLocation((width - good_to_know.getWidth()) / 2-20, height / 20-28);
//        contentPane.add(good_to_know);


        JLabel scoreLabel = new JLabel("<html>" + "your score is: "+score + "</html>");
        scoreLabel.setBackground(color);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, height / 13));
        scoreLabel.setSize(new Dimension(width/2+440, height/3-45 ));
        //scoreLabel.setLocation(width / 2-200, 20);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        contentPane.add(scoreLabel);
        contentPane.add(menuButton);
        contentPane.add(exitGame);



    }
}

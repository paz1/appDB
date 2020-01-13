package view;

import model.GetQuest;
import model.Question_Answer;
import model.queue_question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
//class MyPanel extends JPanel{
//    @Override
//    protected void paintComponent(Graphics g) {
//
//        super.paintComponent(g);
//        Image background = Toolkit.getDefaultToolkit().createImage("image.jpg");
//        g.drawImage(background, 0, 0, null);
//    }
//}

public class Game extends JFrame {
    Color color = new Color(131, 24, 11);
    public static int life;
    public static int score = 0;
    model.queue_question questions;

    JPanel contentPane;
    int count;
    public static int flag=0;
    int initialCount;
    JLabel timeLabel = new JLabel(" ");
    java.util.Timer timer = new Timer(true);

    public Game(int numoflife, queue_question queue_question,int initCount) {
        super("quicky");
        this.count = initCount;
        this.initialCount = initCount;
        this.questions = queue_question;
        //questions = new GetQuest();
        setBackground(color);
        life = numoflife;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = General.width;
        int height = General.height;
        setBounds((General.screenWidth - General.width) / 2, (General.screenHeight - General.height) / 2, width, height);
        contentPane = new JPanel();
        contentPane.setBackground(color);

        timeLabel.setBackground(color);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, height / 20));
        timeLabel.setSize(new Dimension(height / 2, height / 3 + 40));
        timeLabel.setLocation(10, 27);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(timeLabel);

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                count--;
                timeLabel.setText(String.valueOf(count));
                if (count == 0) {
                    //timer.cancel();
                    life--;
                    timer.cancel();
                    if (life == 0) {
                        //todo facts
                        //return ,gameover
                        setVisible(false);
                        //Component component = (Component) getSource();
                        JFrame frame = new JFrame();
                        int s = score;
                        Facts f = new Facts(frame, true, s, questions);
                        score = 0;
                        f.setVisible(true);
                    } else {
                        Game g = new Game(life, questions,initialCount);
                        //g.repaint();
                        //g.pack();
                        g.setVisible(true);
                        setVisible(false);
                        g.runGame();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

//    public void setQ(Question_Answer questions) {
//        this.questions = questions;
//    }

    public void runGame() {
        int width = General.width;
        int height = General.height;

        String str = "";
        for (int i = 0; i < life; i++) {
            str += "♥";
        }
        JLabel livesLabel = new JLabel("<html>" + str + "</html>");
        livesLabel.setBackground(color);
        livesLabel.setForeground(Color.WHITE);
        livesLabel.setFont(new Font("Tahoma", Font.BOLD, height / 20));
        livesLabel.setSize(new Dimension(height / 2, height / 3));
        livesLabel.setLocation(10, 18);
        livesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        livesLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(livesLabel);
        JLabel scoreLabel = new JLabel("<html>" + "score: " + score + "</html>");
        scoreLabel.setBackground(color);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, height / 20));
        scoreLabel.setSize(new Dimension(height / 2, height / 3 - 40));
        scoreLabel.setLocation(10, 10);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(scoreLabel);
        //while(true) {
        // todo - call to sheilta. the first ans is correct
        Question_Answer q = questions.getQ();
        Random rand = new Random();
        int truth = rand.nextInt(2) + 1;
        String leftOpt, rightOpt;
        leftOpt = q.getCorrect_ans();
        rightOpt = q.getWrong_ans();
        if (truth == 2) {
            leftOpt = q.getWrong_ans();
            rightOpt = q.getCorrect_ans();
        }
        JLabel messageLabel = new JLabel(q.getQuestion());
        messageLabel.setBackground(color);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Tahoma", Font.BOLD, height / 20));
        //messageLabel.setSize(new Dimension(height / 2, height / 3));
        //messageLabel.setLocation(width / 2-15, width / 18-30);
        messageLabel.setBounds(2, 2, width + 120, height - 300);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(messageLabel);

        JButton choose1 = new JButton(leftOpt);
        Color color1 = new Color(146, 45, 18);
        choose1.setBackground(color1);
        choose1.setForeground(Color.ORANGE);
        choose1.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        choose1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
        choose1.setSize(new Dimension(height / 2, height / 2));
        choose1.setLocation(height / 2, width / 6);
        choose1.setFocusPainted(false);
        //choose1.setHorizontalAlignment(SwingConstants.CENTER);
        //choose1.setVerticalAlignment(SwingConstants.CENTER);
        choose1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //setVisible(false);
                //SelectRangeOfYears dialog = new SelectRangeOfYears();
                //dialog.setVisible(true);
                timer.cancel();
                if (isCorrect(1, truth)&& initialCount>3) {
                    score += 10;
                    flag=flag+1;
                    if (flag==5){
                        flag=0;
                        initialCount=initialCount-score/50;
                    }
                    count = initialCount;


                } else {
                    life--;
                    if (life == 0) {
                        //todo facts
                        //return ,gameover
                        setVisible(false);
                        Component component = (Component) arg0.getSource();
                        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                        int s = score;
                        Facts f = new Facts(frame, true, s, questions);
                        score = 0;
                        f.setVisible(true);
                        return;
                    }
                }

                Game g = new Game(life, questions,initialCount);
//                g.setQ(questions);
                g.setVisible(true);
                setVisible(false);
                g.runGame();
            }
        });

        JButton choose2 = new JButton(rightOpt);
        //Color color1 = new Color(146,45,18);
        choose2.setBackground(color1);
        choose2.setForeground(Color.ORANGE);
        choose2.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        choose2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
        choose2.setSize(new Dimension(height / 2, height / 2));
        choose2.setLocation(width - height / 2 - width / 10, width / 6);
        choose2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //setVisible(false);
                //SelectRangeOfYears dialog = new SelectRangeOfYears();
                //dialog.setVisible(true);
                timer.cancel();
                if (isCorrect(2, truth)) {
                    score += 10;
                    flag=flag+1;
                    if (flag==5 && initialCount>3){
                        flag=0;
                        initialCount=initialCount-score/50;
                    }
                    count = initialCount;


                } else {
                    life--;
                    if (life == 0) {
                        //todo facts
                        //return ,gameover
                        setVisible(false);
                        Component component = (Component) arg0.getSource();
                        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                        int s = score;
                        Facts f = new Facts(frame, true, s, questions);
                        score = 0;
                        f.setVisible(true);
                        return;
                    }
                }
                //todo move to next q


                Game g = new Game(life, questions,initialCount);
//                g.setQ(questions);
                g.setVisible(true);
                setVisible(false);
                g.runGame();
            }
        });
        contentPane.add(choose1);
        contentPane.add(choose2);
        String ans=q.getCorrect_ans();
        JLabel answer = new JLabel(ans);
        answer.setBackground(color);
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Tahoma", Font.BOLD, height / 20));
        answer.setSize(new Dimension(height / 2, height / 3 - 40));
        answer.setLocation(10, height / 2-50);
        answer.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setVerticalAlignment(SwingConstants.CENTER);
        answer.setVisible(false);
        contentPane.add(answer);

        JButton hint = new JButton("hint");
        //Color color1 = new Color(146,45,18);
        hint.setBackground(color1);
        hint.setForeground(Color.ORANGE);
        hint.setFont(new Font("Tahoma", Font.BOLD, 15));
        hint.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.ORANGE));
        hint.setSize(new Dimension(40, 40));
        hint.setLocation(20, height / 2);
        hint.setFocusPainted(false);
        hint.addActionListener(new ActionListener() {
            //            public void actionPerformed(ActionEvent arg0) {
//                JLabel answer = new JLabel("<html>" + q.getCorrect_ans() + "</html>");
//                answer.setBackground(color);
//                answer.setForeground(Color.WHITE);
//                answer.setFont(new Font("Tahoma", Font.BOLD, height / 20));
//                answer.setSize(new Dimension(100, 100));
//                answer.setLocation(50, height/2+30);
//                //answer.setBounds(2, 2, width+120, height-300);
//                //contentPane.removeAll();
//                add(answer);
//                revalidate();
//                repaint();
//            }
            public void actionPerformed(ActionEvent arg0) {
                answer.setVisible(true);
            }
        });
        contentPane.add(hint);

        repaint();
    }

    public boolean isCorrect(int choose, int answer) {
        return (choose == answer);
    }
}

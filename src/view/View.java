package view;

import model.Question_Answer;
import model.queue_question;

import java.awt.*;

public class View {
    MainWindow frame;

    public void openWindow(queue_question queue_question){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new MainWindow(queue_question);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

package view;

import model.Question_Answer;
import model.queue_question;

import java.awt.*;
import controller.controller;

public class View {
    MainWindow frame;

    public void openWindow(controller c,queue_question queue_question){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new MainWindow(c,queue_question);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

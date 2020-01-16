package controller;

import model.*;
import view.View;

import java.util.Random;

public class controller {

    Main_model model;
    public controller(){
        this.model = new Main_model();
    }
    public void run_game(){

        queue_question q=new queue_question();
        View v = new View();
        v.openWindow(this,q);
        Qusetion_Map my_question = Qusetion_Map.getInstance();
        Random rand = new Random();

        while (true){
            if (q.sizel()==100){
                continue;
            }
            int db_q = rand.nextInt(my_question.get_size());
            db_q = 1;
            Question_Answer q_a=model.get_question(db_q);
            System.out.println("*************************************************");
            if(q_a==null){
                continue;
            }


            q.add_to_list(q_a);
            int x = 5;
        }
    }
    public void initGame(){
        model.initGame();
    }
    public int getLevel() {
        return model.getLevel();
    }

    public int getScore() {
        return model.getScore();
    }

    public int getLife() {
        return model.getLife();
    }
    public int getInitialCount() {
        return model.getInitialCount();
    }
    public void correct(){
        model.correct();
    }
    public void wrong(){
        model.wrong();
    }


}

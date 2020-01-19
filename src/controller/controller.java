package controller;

import model.*;
import view.View;

import java.util.Random;

public class controller {

    Main_model model;
    public controller(){
        this.model = new Main_model();
    }

    /**
     * the contrioller responsible for all the abstract logic
     */
    public void run_game(){

        queue_question q=new queue_question();
        View v = new View();
        Qusetion_Map my_question = Qusetion_Map.getInstance();
        Random rand = new Random();
        for (int i=0;i<5;i++){
            int db_q = rand.nextInt(my_question.get_size());
            Question_Answer q_a=model.get_question(db_q);
            q.add_to_list(q_a);
        }
        v.openWindow(this,q);



        while (true){
            if (q.sizel()==100){
                continue;
            }
            int db_q = rand.nextInt(my_question.get_size());
            Question_Answer q_a=model.get_question(db_q);
            if(q_a==null){
                continue;
            }


            q.add_to_list(q_a);

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

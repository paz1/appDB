package Controller;

import model.*;
import view.View;

import java.util.Random;

/**
 * this is the contoller of the program
 */

public class controller {

    Main_model model;
    public controller(){
        this.model = new Main_model();
    }
    //we run the game
    public void run_game(){
        // a queue of the question
        queue_question q=new queue_question();
        // open the view
        View v = new View();
        v.openWindow(this,q);

        Qusetion_Map my_question = Qusetion_Map.getInstance();
        Random rand = new Random();

        while (true){
            if (q.sizel()==100){
                continue;
            }
            //pick a random qusetion
            int db_q = rand.nextInt(my_question.get_size());
            //db_q = 1;
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

package Controller;

import DB.JDBC;
import model.*;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class controller {



    public void run_game(){

        Main_model model = new Main_model();
        queue_question q=new queue_question();
        View v = new View();
        v.openWindow(q);
        Qusetion_Map my_question = Qusetion_Map.getInstance();
        Random rand = new Random();

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
            int x = 5;
        }
    }

}

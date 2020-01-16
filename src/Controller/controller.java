package Controller;

import DB.JDBC;
import model.Make_Info;
import model.Question_Answer;
import model.Qusetion_Map;
import model.queue_question;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class controller {



    public void run_game(){
        String passwd = "re12ut34";
        String user="root";
        String schema="data";
        JDBC db = new JDBC(user,passwd,"3306",schema);
        db.connection();
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
            //db_q = 1;
            //String ask = my_question.get_question_to_DB(db_q);

            ArrayList<ArrayList<String>> temp = db.get_ans(db_q);
            //db.get_info_from_db();
            Make_Info qq = new Make_Info();
            Question_Answer a = qq.get_The_Info(db_q,temp);
            if(a==null){
                continue;
            }

            q.add_to_list(a);
            int x = 5;
        }
    }

}

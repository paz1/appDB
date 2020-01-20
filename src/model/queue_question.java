package model;


import model.Question_Answer;

import java.util.ArrayList;
import java.util.List;


/**
 * class that hold list of "question" to the game
 */
public class queue_question {
    private List<Question_Answer> my_list  =new ArrayList<>();

    public void add_to_list(Question_Answer q){
        if(my_list.size()==100){
            return;
        }else {
            this.my_list.add(q);
        }
    }
    public boolean empty(){
        if(my_list.size()==0){
            return true;
        }
        return false;
    }
    public Question_Answer getQ(){
        Question_Answer qq;
        while (true){
            qq =  this.my_list.get(0);
            this.my_list.remove(0);
            if (qq.getLength_ans_co()<=5&&qq.getLength_ans_wr()<=5&&linesNum(qq.getQuestion())<=2){
                if (qq.corrct_too_long()==false && qq.wrong_too_long()==false){
                    break;
                }

            }


        }
        return qq;
    }
    public Integer sizel(){
        return this.my_list.size();
    }
    public int linesNum(String s){
        String[]arr=s.split("<br>");
        if (arr[arr.length-1].length()==7){
            return arr.length-1;
        }
        return arr.length;
    }
}

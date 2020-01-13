package model;

import model.Question_Answer;

import java.util.ArrayList;
import java.util.List;

public class queue_question {
    private List<Question_Answer> my_list  =new ArrayList<>();

    public void add_to_list(Question_Answer q){
        if(my_list.size()==100){
            return;
        }else {
            this.my_list.add(q);
        }
    }
    public Question_Answer getQ(){
        Question_Answer qq =  this.my_list.get(0);
        this.my_list.remove(0);
        return qq;
    }
}

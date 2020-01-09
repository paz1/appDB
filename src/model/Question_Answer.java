package model;

import java.util.Vector;

public class Question_Answer {
    private String question;
    private String correct_ans;
    private String wrong_ans;


    public Question_Answer(String question, String correct_ans, String wrong_ans){
        this.question = question;
        this.correct_ans = correct_ans;
        this.wrong_ans = wrong_ans;
    }

    public String getCorrect_ans() {
        return this.correct_ans;
    }

    public String getWrong_ans() {
        return this.wrong_ans;
    }

    public String getQuestion() {
        return this.question;
    }
    public Vector getQ(){
        Vector v = new Vector();
        fillVector(v);
        return v;
    }
    private void fillVector(Vector v) {
        v.add(this.question);
        v.add(this.correct_ans);
        v.add(this.wrong_ans);
    }
}
package model;

import java.util.Vector;

public class Question_Answer {
    private String question;
    private String correct_ans;
    private String wrong_ans;
    private String good_to_know;



    public Question_Answer(String question, String correct_ans, String wrong_ans,String good){
        this.question = question;
        this.correct_ans = correct_ans;
        this.wrong_ans = wrong_ans;
        this.good_to_know = good;
    }


    public String getGood_to_know() {
        return filterQue(good_to_know);
    }

    public String getCorrect_ans() {
        return filter(this.correct_ans);
    }

    public int getLength_ans_co() {
        int num= (this.correct_ans).split(" ").length;
        return num;
    }
    public int getLength_ans_wr() {
        int num= (this.correct_ans).split(" ").length;
        return num;
    }


    public String getWrong_ans() {
        return filter(this.wrong_ans);
    }

    public String getQuestion() {
        return filterQue(this.question);
    }

    private String filter(String str){
        String[] splitStr=str.split(" ");
        String ans=("<html><div style='text-align: center;'>" );
        for (int i=0;i<splitStr.length;i++){
            ans+=splitStr[i];
            ans+="<br>";
        }
        ans+="</html>";
        return ans;
    }

    private String  filterQue(String str){
        String[] splitStr=str.split(" ");
        String ans=("<html><div style='text-align: center;'>" );
        for (int i=0;i<splitStr.length;i++){
            ans+=splitStr[i];
            ans+=" ";
            if (i==6){
                ans+="<br>";
            }
        }
        ans+="<br>";
        ans+="</html>";
        return ans;
    }
}
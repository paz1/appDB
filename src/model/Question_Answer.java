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
        return good_to_know;
    }

    public String getCorrect_ans() {
        return filter(this.correct_ans);
    }

    public String getWrong_ans() {
        return filter(this.wrong_ans);
    }

    public String getQuestion() {
        return filterQue(this.question);
    }
    public Vector getQ(){
        Vector v = new Vector();
        fillVector(v);
        return v;
    }
    private void fillVector(Vector v) {
        v.add(this.question);
        v.add(filter(this.correct_ans));
        v.add(filter(this.wrong_ans));
    }
    private String filter(String str){
        String[] splitStr=str.split(" ");
        String ans=("<html>" );
        for (int i=0;i<splitStr.length;i++){
            ans+=splitStr[i];
            ans+="<br>";
        }
        ans+="</html>";
        return ans;
    }
    private String filterQue(String str){
        String[] splitStr=str.split(" ");
        String ques=("<html>" );
        for (int i=0;i<splitStr.length;i=i+8){
            ques+=splitStr[i];
            ques+="<br>";
        }
        ques+="</html>";
        return ques;
    }
}
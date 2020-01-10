package model;

import java.util.*;

public class Make_Info {
    private Map<Integer, MyParser> map_question = new HashMap<Integer, MyParser>();

    public Make_Info(){
        this.init_map();
    }

    private void init_map(){
        this.map_question.put(4, new MyParser() {
            @Override
            public Question_Answer Parse( ArrayList<ArrayList<String>> lines) {
               int size_of_lines = lines.size();
               if (size_of_lines<2)
               {
                   return null;
               }
               Random r = new Random();

               int random_currect_ans  = r.nextInt(size_of_lines);
               List<String> cur_ans = lines.get(random_currect_ans);
               int random_fake;
               List<String> fake_ans;
               int stop = 0;
               while (true){
                   random_fake = r.nextInt(size_of_lines);
                   fake_ans = lines.get(random_fake);
                   if((random_currect_ans!=random_fake)&&(!cur_ans.get(0).equals(fake_ans.get(0)) )){
                       break;
                   }
                   if (stop==100){
                       return null;
                   }
                   stop++;
               }

               String ret = Qusetion_Map.getInstance().get_question_to_DB(4)+"\""+ cur_ans.get(1)+"\"";

               return new Question_Answer( ret,cur_ans.get(0),fake_ans.get(0));


            }
        });

        this.map_question.put(0, new MyParser() {
            @Override
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {

                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                while(Integer.parseInt(cur_ans.get(1))<2){
                    random_currect_ans  = r.nextInt(size_of_lines);
                    cur_ans = lines.get(random_currect_ans);
                }

                int random_fake;
                List<String> fake_ans;
                int stop=0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(Integer.parseInt(cur_ans.get(1))>Integer.parseInt((fake_ans.get(1))) )){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }

                return new Question_Answer(Qusetion_Map.getInstance().get_question_to_DB(0),cur_ans.get(0),fake_ans.get(0));


            }
        });
        this.map_question.put(1, new MyParser() {
            @Override
            //todo check what to do when its return one ans
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                int stop = 0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(Integer.parseInt(fake_ans.get(1))!=Integer.parseInt(cur_ans.get(1)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }
                String ques ="Which year the song "+"\""+ cur_ans.get(0)+"\""+"  was released?";


                return new Question_Answer( ques,cur_ans.get(1),fake_ans.get(1));
            }
        });
        this.map_question.put(2, new MyParser() {
            @Override
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int stop=0;
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(!fake_ans.get(1).equals(cur_ans.get(1)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }

                String ques ="Where the singer "+"\""+ cur_ans.get(0)+"\""+"  lives?";
                return new Question_Answer( ques,cur_ans.get(1),fake_ans.get(1));
            }
        });

        this.map_question.put(3, new MyParser() {
            @Override

            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                int stop=0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(!fake_ans.get(0).equals(cur_ans.get(0)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }

                String ques =Qusetion_Map.getInstance().get_question_to_DB(3)+" "+"\""+ cur_ans.get(1)+"\""+"?";
                return new Question_Answer( ques,cur_ans.get(0),fake_ans.get(0));
            }
        });





    }

    public Question_Answer get_The_Info(int question, ArrayList<ArrayList<String>> lines){

        return this.map_question.get(question).Parse(lines);


    }



}

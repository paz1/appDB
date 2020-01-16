package model;

import DB.JDBC;

import java.util.ArrayList;

public class Main_model {

    private String passwd;
    private String user;
    private String schema;
    private JDBC db;

    public Main_model(){
        this.passwd = "re12ut34";
        this.user="root";
        this.schema="data";
        db = new JDBC(user,passwd,"3306",schema);
        db.connection();

    }
    public Question_Answer get_question(Integer db_q){
        ArrayList<ArrayList<String>> temp = db.get_ans(db_q);
        //db.get_info_from_db();
        Make_Info qq = new Make_Info();
        Question_Answer a = qq.get_The_Info(db_q,temp);
        return a;
    }
}

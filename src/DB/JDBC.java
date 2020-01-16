package DB;



import model.Question_Answer;

import java.sql.*;
import java.util.*;


public class JDBC {
    private String user_name;
    private String password;
    private Connection conn ;
    private String port;
    private String schema_name;
    private boolean connect;
    private Map<Integer, String> map_question = new HashMap<Integer, String>();



    public JDBC(String user_name,String password,String port,String schema_name){
        this.port = port;
        this.schema_name = schema_name;
        this.password = password;
        this.user_name = user_name;
        this.set_dict();
        this.conn = null;
        this.connect = false;
    }

    private void set_dict(){

        this.map_question.put(0,"SELECT artists.ArtistName,COUNT(songs.ArtistID) as" +
                " ll FROM artists Join songs ON songs.ArtistID = artists.ArtistID GROUP BY songs.ArtistID ORDER BY ll DESC");
        this.map_question.put(1,"SELECT Title ,Year,ArtistName FROM artists a Join songs s ON a.ArtistID = s.ArtistID Join (SELECT singer FROM bestsingers ORDER BY RAND() LIMIT 1) as t ON t.singer = a.ArtistName");
        this.map_question.put(2, "SELECT ArtistName,ArtistLocation FROM artists WHERE ArtistHotness > 0.6 AND ArtistLocation NOT LIKE '-'");
        this.map_question.put(3, "SELECT ArtistName ,Title FROM artists a Join songs s ON a.ArtistID = s.ArtistID Join bestsingers b ON b.singer = a.ArtistName");
        this.map_question.put(4,"SELECT albums.AlbumName , songs.Title FROM albums JOIN songs ON albums.AlbumID = songs.AlbumID WHERE songs.SongHotttnesss > 0.7");
//        String old_1 = "SELECT Title , songs.Year FROM songs , (SELECT ArtistID FROM artists,(SELECT singer FROM bestsingers ORDER BY RAND() LIMIT 1) as t WHERE artists.ArtistName = t.singer) as r " +
//                "WHERE songs.ArtistID = r.ArtistID";
//      String old_3  = "SELECT u.ArtistName ,songs.Title FROM songs Join (SELECT * FROM artists Join (SELECT singer,1 as pop FROM bestsingers) as r ON artists.ArtistName = r.singer) as u ON "
//              +"songs.ArtistID = u.ArtistID WHERE u.pop=1");
    }



    public boolean connection(){
        String url = "jdbc:mysql://localhost:"+this.port+"/"+this.schema_name;


        System.out.println(url);
        try{
            this.conn = DriverManager.getConnection(url,this.user_name, this.password);
            this.connect = true;
            return true;
        }catch (SQLException e){
            System.out.println(e);
            return false;
        }

    }


    public ArrayList<ArrayList<String>> get_ans(Integer question){

        //question = "Which album does the song belong to";
        ArrayList<ArrayList<String>> listOLists = get_info_from_db(this.map_question.get(question));
        return listOLists;
    }
    private ArrayList<ArrayList<String>> get_info_from_db(String query){


        List<String> res = new ArrayList<>();
        int i  = 0;
        //String sql ="SELECT song_id FROM songs_generes WHERE albums.songs_generes.genre='hip hop'";



            try {

                Statement stmt = this.conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);


                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
                rs.first();

                while (rs.next()) {
                    ArrayList<String> mini_list= new ArrayList<String>();
                    for(int j = 1;j<=columnsNumber;j++){

                        mini_list.add(rs.getString(j));
                        System.out.print(rs.getString(j));
                        System.out.print("                   ");


                    }
                    i++;
                    System.out.println("");
                    listOLists.add(mini_list);

                }

                System.out.println(i);
                return listOLists;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;

            }





    }


    public boolean close_conn(){
        if (this.connect){
            try {
                conn.close();
                return true;
            } catch (SQLException e) {
                System.out.println("error close");
                e.printStackTrace();
            }
        }
        return false;


    }
}

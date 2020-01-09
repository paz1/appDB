package model;

import java.util.Vector;

public class GetQuest {
    public GetQuest(){

    }
    public Vector getQ(){
        Vector v = new Vector();
        fillVector(v);
        return v;
    }
    private void fillVector(Vector v) {
        v.add("which album the song \"the climb\" belong?");
        //v.add("which is bigger?");
        //v.add("the amazi\n journey");
        v.add("<html>" + "the amazing<br>journey" + "</html>");
        v.add("josef");
    }
}



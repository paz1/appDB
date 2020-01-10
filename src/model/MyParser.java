package model;

import java.util.ArrayList;
import java.util.List;

public interface MyParser {
    public Question_Answer Parse( ArrayList<ArrayList<String>> lines);
}

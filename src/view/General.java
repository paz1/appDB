package view;

import java.awt.Font;
import java.awt.Toolkit;

public class General {
    /** width of the main window */
    final static public int width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    /** height of the main window */
    final static public int height = Toolkit.getDefaultToolkit().getScreenSize().height /2;
    final static public int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    final static public int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    /** the hight of label */
    final static public int labelHeight = height / 40;
    /** the hight of a field */
    final static public int fieldHeight = labelHeight + 10;
    /** the difference Between Lines in dialogs */
    final static public int differenceBetweenLines = (int)(1.4 * fieldHeight);
    /** default field Width */
    final static public int fieldWidth = width / 11;
    /** default label Width */
    final static public int labelWidth = width / 12;
    /** default font */
    Font font;
    public General()
    {
        int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
        int fontSize = (int)Math.round(12.0 * screenRes / 92.0);
        font = new Font("Arial", Font.PLAIN, fontSize);
    }

}

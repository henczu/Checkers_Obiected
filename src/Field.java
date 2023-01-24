import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Field {


    public JButton button;
    public Figures figures;


    Field(){
        button = new JButton();
        button.setFocusable(false);
        button.setBackground(new Color(44,27,1));


       // button.addMouseListener((MouseListener) this);






    }


}

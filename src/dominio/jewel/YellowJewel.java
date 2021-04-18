package dominio.jewel;

import dominio.jewel.Jewel;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the Green Jewel
 * @author Juan David Murillo
 * @version 1.0
 */
public class YellowJewel extends Jewel {
    /**
     * Constructor for the yellow jewel class
     */
    public YellowJewel(){
        super.setId(4);

        //ImageIcon icon = new ImageIcon(getClass().getResource("../assets/yellow.png"));
        //setIcon(icon);
        //setText("YELLOW");
        setBackground(Color.yellow);
        setVisible(true);
    }
}
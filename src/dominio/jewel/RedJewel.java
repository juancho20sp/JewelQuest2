package dominio.jewel;

import dominio.jewel.Jewel;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the Red Jewel
 * @author Juan David Murillo
 * @version 1.0
 */
public class RedJewel extends Jewel {

    /**
     * Constructor for the red jewel class
     */
    public RedJewel(){
        super.setId(3);

        //ImageIcon icon = new ImageIcon(getClass().getResource("../assets/red.png"));
        //setIcon(icon);
        //setText("RED");
        setBackground(Color.red);
        setVisible(true);
    }
}

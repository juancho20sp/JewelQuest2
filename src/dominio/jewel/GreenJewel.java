package dominio.jewel;

import javax.swing.*;
import java.awt.*;


/**
 * Class for the Green Jewel
 * @author Juan David Murillo
 * @version 1.0
 */
public class GreenJewel extends Jewel {
    /**
     * Constructor for the GreenJewel class
     */
    public GreenJewel(){
        super.setId(2);

        //ImageIcon icon = new ImageIcon(getClass().getResource("../assets/green.png"));
        //setIcon(icon);
        //setText("GREEN");
        setBackground(Color.GREEN);
        setVisible(true);
    }
}
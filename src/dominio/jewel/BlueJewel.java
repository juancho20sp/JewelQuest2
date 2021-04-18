package dominio.jewel;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the Blue Jewel
 * @author Juan David Murillo
 * @version 1.0
 */
public class BlueJewel extends Jewel {

    /**
     * Constructor for the BlueJewel class
     */
    public BlueJewel(){
        super.setId(1);

        //ImageIcon icon = new ImageIcon(getClass().getResource("../assets/blue.png"));
        //setIcon(icon);
        setBackground(Color.BLUE);
        //setText("BLUE");
        setVisible(true);
    }
}

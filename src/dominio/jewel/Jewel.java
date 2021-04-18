package dominio.jewel;

import javax.swing.*;
import java.awt.*;

public abstract class Jewel extends JLabel {
    private int points;
    private int id;

    public Jewel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

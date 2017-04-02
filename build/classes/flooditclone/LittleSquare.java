/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flooditclone;

import java.awt.Color;

public class LittleSquare {

    Color color;
    boolean finished;
    boolean connected;

    public LittleSquare(Color color, boolean finished, boolean connected) {
        this.color = color;
        this.finished = finished;
        this.connected = connected;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}

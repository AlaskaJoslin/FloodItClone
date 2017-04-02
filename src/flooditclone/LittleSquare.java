/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flooditclone;

import java.awt.Color;

public class LittleSquare {
    //define class variables
    Color color;
    boolean connected;
    //constructor
    public LittleSquare(Color color, boolean connected) {
        this.color = color;
        this.connected = connected;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}

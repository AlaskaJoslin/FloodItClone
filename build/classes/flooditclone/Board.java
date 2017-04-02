/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flooditclone;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Board extends JPanel {

    LittleSquare[][] board;
    int dimension;

    public Board(LittleSquare[][] board, int dimension) {
        this.board = board;
        this.dimension = dimension;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                g.setColor(board[i][j].getColor());
                g.fillRect(1 + i * ((400 - board.length) / board.length), 1 + j * ((400 - board.length) / board.length), (400 - board.length) / board.length, (400 - board.length) / board.length);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void setBoard(LittleSquare[][] board) {
        this.board = board;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}

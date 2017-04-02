package flooditclone;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
//defines panel for colored squares
public class Board extends JPanel {
    //class variables
    LittleSquare[][] board;
    int dimension;
    //constructor
    public Board(LittleSquare[][] board, int dimension) {
        this.board = board;
        this.dimension = dimension;
    }
    //paint board with square that fill board
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
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

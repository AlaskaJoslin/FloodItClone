/*
 * Matthew Joslin
 * CS II
 * Final Project
 * Flood It Clone
 */
package flooditclone;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FloodItClone extends JFrame {

    //Class variables and constants
    public static int SMALL = 10;
    public static int MEDIUM = 20;
    public static int LARGE = 40;
    public static Color PURPLE = new Color(204, 0, 204);
    public static Color BLUE = new Color(0, 0, 204);
    public static Color RED = new Color(204, 0, 0);
    public static Color GREEN = new Color(0, 204, 0);
    public static Color YELLOW = new Color(204, 204, 0);
    public static Color AZUL = new Color(0, 204, 204);
    public static int dimension;
    public static LittleSquare[][] matrix = new LittleSquare[dimension+2][dimension+2];
    static int turns;
    static int turnsTaken = 0;
    static boolean firstGameStarted = false;
    static JButton purple = new JButton();
    static JButton green = new JButton();
    static JButton yellow = new JButton();
    static JButton red = new JButton();
    static JButton azul = new JButton();
    static JButton blue = new JButton();
    static JButton smallBoard = new JButton("Small");
    static JButton mediumBoard = new JButton("Medium");
    static JButton largeBoard = new JButton("Large");
    static JLabel score = new JLabel("Score: ");
    static JLabel moveLabel = new JLabel("Moves");
    static JTextField scores = new JTextField();
    static Board board = new Board(matrix, dimension);
    static JTextField moves = new JTextField();

    
    public FloodItClone() {
        //do all the graphics work and arranging
        JPanel everything = new JPanel();
        JPanel buttons = new JPanel();
        JPanel controls = new JPanel();
        JPanel scored = new JPanel();
        JPanel top = new JPanel();
        initializeColorButtons(azul, AZUL);
        initializeColorButtons(purple, PURPLE);
        initializeColorButtons(green, GREEN);
        initializeColorButtons(yellow, YELLOW);
        initializeColorButtons(red, RED);
        initializeColorButtons(blue, BLUE);
        smallBoard.setPreferredSize(new Dimension(97, 40));
        mediumBoard.setPreferredSize(new Dimension(97, 40));
        largeBoard.setPreferredSize(new Dimension(97, 40));
        scores.setPreferredSize(new Dimension(72, 24));
        buttons.setLayout(new GridLayout(1, 6, 10, 10));
        everything.setLayout(new BorderLayout());
        controls.setLayout(new GridLayout(7, 1, 10, 10));
        scored.setLayout(new BorderLayout());
        scored.add(score, BorderLayout.WEST);
        scored.add(scores, BorderLayout.EAST);
        buttons.add(purple);
        buttons.add(green);
        buttons.add(yellow);
        buttons.add(red);
        buttons.add(azul);
        buttons.add(blue);
        controls.add(smallBoard);
        controls.add(mediumBoard);
        controls.add(largeBoard);
        controls.add(moveLabel);
        controls.add(moves);
        moves.setEditable(false);
        scores.setEditable(false);
        controls.add(scored);
        controls.setVisible(true);
        top.add(controls);
        top.add(board);
        everything.add(top, BorderLayout.NORTH);
        everything.add(buttons, BorderLayout.SOUTH);
        add(everything);
        
        
    }
    private void initializeColorButtons(JButton jc, Color color) {
        jc.setPreferredSize(new Dimension(97, 97));
        jc.setBackground(color);
        jc.setBorderPainted(false);
        jc.setOpaque(true);
        colorActionListener newColor = new colorActionListener();
        jc.addActionListener(newColor);
        newColor.setColorActionListener(color);
    }
    
    private class colorActionListener implements ActionListener {
        Color color;
        public void setColorActionListener(Color color) {
            this.color=color;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(color)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    //ends the game
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
    }


    public static void main(String[] args) {
        //call new instance and display it
        FloodItClone flood = new FloodItClone();
        flood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flood.setSize(1050, 850);
        flood.pack();
        flood.setLocationRelativeTo(null);
        flood.setVisible(true);
    }

    private static class smallBoardActionListener implements ActionListener {
        //create a small board
        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            dimension = SMALL;
            turns= dimension+8;
            moves.setText(turnsTaken + "/" + turns);
            matrix = new LittleSquare[dimension][dimension];
            initializeBoard(dimension);
            board.setBoard(matrix);
            board.setDimension(dimension);
            board.repaint();
            firstGameStarted = true;
        }
    }

    private static class mediumBoardActionListener implements ActionListener {
        //create a medium board
        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            dimension = MEDIUM;
            turns= dimension+15;
            moves.setText(turnsTaken + "/" + turns);
            matrix = new LittleSquare[dimension][dimension];
            initializeBoard(dimension);
            board.setBoard(matrix);
            board.setDimension(dimension);
            board.repaint();
            firstGameStarted = true;
        }
    }

    private static class largeBoardActionListener implements ActionListener {
        //create a large board
        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            dimension = LARGE;
            turns= dimension+35;
            moves.setText(turnsTaken + "/" + turns);
            matrix = new LittleSquare[dimension][dimension];
            initializeBoard(dimension);
            board.setBoard(matrix);
            board.setDimension(dimension);
            board.repaint();
            firstGameStarted = true;
        }
    }

    private static boolean makeAMove(Color color) {
        //change connecting squares to color passed to function
        boolean movemade = true;
        boolean amovemade = false;
        //do this while a move was made last time, initialized to true
        while (movemade == true) {
            movemade = false;
            //change all connected to the same color
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (matrix[i][j].isConnected()) {
                        matrix[i][j].setColor(color);
                    }
                }
            }
            
            if (walkAroundAPiece()) {
                movemade = true;
                amovemade = true;
            }
        }

        return amovemade;
    }
    public static boolean walkAroundAPiece() {
        boolean movemade=false;
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
                if (matrix[i][j].getColor().equals(matrix[i][j - 1].getColor()) && matrix[i][j-1].isConnected()!=true) {
                                matrix[i][j - 1].setColor(matrix[0][0].getColor());
                                matrix[i][j - 1].setConnected(true);
                                if (i==0 || i==dimension+2) {
                        
                    }
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i + 1][j].getColor()) && matrix[i+1][j].isConnected()!=true) {
                                matrix[i + 1][j].setColor(matrix[0][0].getColor());
                                matrix[i + 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i - 1][j].getColor()) && matrix[i-1][j].isConnected()!=true) {
                                matrix[i - 1][j].setColor(matrix[0][0].getColor());
                                matrix[i - 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i][j + 1].getColor()) && matrix[i][j+1].isConnected()!=true) {
                                matrix[i][j + 1].setColor(matrix[0][0].getColor());
                                matrix[i][j + 1].setConnected(true);
                                movemade = true;
                                
                            }
            }
        }
        return movemade;
    }
    //check to see that all are connected
    private static boolean checkBoard() {
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
                if (matrix[i][j].isConnected() == false) {
                    return false;
                }
            }
        }
        return true;
    }
    //score game, -1 for unconnected square
    //+100 for unused turns
    private static int scoreIt() {
        int score = 0;
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
                if (matrix[i][j].isConnected() == false) {
                    score--;
                }
            }
        }
        score = score + (turns - turnsTaken) * 100;
        return score;
    }

    private static void initializeBoard(int dimension) {
        //set random colors
        for (int i = 0; i < dimension+2; i++) {
            for (int j = 0; j < dimension; j++) {
                Color color;
                int choice = (int) (Math.random() * 6);
                if (choice == 0) {
                    color = PURPLE;
                } else if (choice == 1) {
                    color = BLUE;
                } else if (choice == 2) {
                    color = RED;
                } else if (choice == 3) {
                    color = GREEN;
                } else if (choice == 4) {
                    color = YELLOW;
                } else {
                    color = AZUL;
                }
                matrix[i][j] = new LittleSquare(color, false);
            }
        }
        matrix[0][0].setConnected(true);
        boolean movemade=true;
        Color color =  matrix[0][0].getColor();
        //connect all the pieces that connect to the top left corner
        while (movemade == true) {
            movemade = false;
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (matrix[i][j].isConnected()) {
                        matrix[i][j].setColor(color);
                    }
                }
            }
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (matrix[i][j].isConnected()) {
                        if (i == 0) {
                            if (j == 0) {
                                
                                if (matrix[i][j].getColor().equals(matrix[i][1].getColor()) && matrix[i][1].isConnected()!=true) {
                                    matrix[i][1].setColor(color);
                                    matrix[i][1].setConnected(true);
                                    
                                    movemade = true;
                                }
                                if (matrix[i][j].getColor().equals(matrix[1][j].getColor()) && matrix[1][j].isConnected()!=true) {
                                    matrix[1][j].setColor(color);
                                    matrix[1][j].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            } else {
                                
                                if (matrix[i][j].getColor().equals(matrix[i][j - 1].getColor()) && matrix[i][j-1].isConnected()!=true) {
                                    matrix[i][j - 1].setColor(color);
                                    matrix[i][j - 1].setConnected(true);
                                    movemade = true;
                                   
                                }
                                if (matrix[i][j].getColor().equals(matrix[i][j + 1].getColor()) && matrix[i][j+1].isConnected()!=true) {
                                    matrix[i][j + 1].setColor(color);
                                    matrix[i][j + 1].setConnected(true);
                                    movemade = true;
                                    
                                }
                                if (matrix[i][j].getColor().equals(matrix[i + 1][j].getColor()) && matrix[i+1][j].isConnected()!=true) {
                                    matrix[i + 1][j].setColor(color);
                                    matrix[i + 1][j].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            }
                        } else if (j == 0) {
                            
                            if (matrix[i][j].getColor().equals(matrix[i][j + 1].getColor()) && matrix[i][j+1].isConnected()!=true) {
                                matrix[i][j + 1].setColor(color);
                                matrix[i][j + 1].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i + 1][j].getColor()) && matrix[i+1][j].isConnected()!=true) {
                                matrix[i + 1][j].setColor(color);
                                matrix[i + 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i - 1][j].getColor()) && matrix[i-1][j].isConnected()!=true) {
                                matrix[i - 1][j].setColor(color);
                                matrix[i - 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            
                        } else {
                            
                            if (matrix[i][j].getColor().equals(matrix[i][j - 1].getColor()) && matrix[i][j-1].isConnected()!=true) {
                                matrix[i][j - 1].setColor(color);
                                matrix[i][j - 1].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i + 1][j].getColor()) && matrix[i+1][j].isConnected()!=true) {
                                matrix[i + 1][j].setColor(color);
                                matrix[i + 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i - 1][j].getColor()) && matrix[i-1][j].isConnected()!=true) {
                                matrix[i - 1][j].setColor(color);
                                matrix[i - 1][j].setConnected(true);
                                movemade = true;
                                
                            }
                            if (matrix[i][j].getColor().equals(matrix[i][j + 1].getColor()) && matrix[i][j+1].isConnected()!=true) {
                                matrix[i][j + 1].setColor(color);
                                matrix[i][j - 1].setConnected(true);
                                movemade = true;
                                
                            }
                            
                        }
                    }
                }

            }
            
        }
    }
}
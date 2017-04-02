/*
 * Matthew Joslin
 * CS II
 * Final Project
 * Flood It Clone
 */
package flooditclone;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FloodItClone extends JFrame {

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
    public static LittleSquare[][] matrix = new LittleSquare[dimension][dimension];
    static int turns = dimension + 10;
    static int turnsTaken = 0;
    static boolean squarechanged = false;
    static boolean initialized = false;
    static boolean firstGameStarted = false;
    //button7 small board
    //button8 medium board
    //button9 large board
    //button6 0,0,204   blue
    //button5 0,204,204 azul
    //button4 204,0,0   red
    //button3 204,204,0 yellow
    //button2 0,204,0   green
    //button1 204,0,204 purple
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
        JPanel everything = new JPanel();
        JPanel buttons = new JPanel();
        JPanel controls = new JPanel();
        JPanel scored = new JPanel();
        JPanel top = new JPanel();
        azul.setPreferredSize(new Dimension(97, 97));
        purple.setPreferredSize(new Dimension(97, 97));
        green.setPreferredSize(new Dimension(97, 97));
        yellow.setPreferredSize(new Dimension(97, 97));
        red.setPreferredSize(new Dimension(97, 97));
        blue.setPreferredSize(new Dimension(97, 97));
        blue.setBackground(BLUE);
        blue.setBorderPainted(false);
        blue.setOpaque(true);
        azul.setBackground(AZUL);
        azul.setBorderPainted(false);
        azul.setOpaque(true);
        red.setBackground(RED);
        red.setBorderPainted(false);
        red.setOpaque(true);
        yellow.setBackground(YELLOW);
        yellow.setBorderPainted(false);
        yellow.setOpaque(true);
        green.setBackground(GREEN);
        green.setBorderPainted(false);
        green.setOpaque(true);
        purple.setBackground(PURPLE);
        purple.setBorderPainted(false);
        purple.setOpaque(true);
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
        purple.addActionListener(new purplizeActionListener());
        green.addActionListener(new greenizeActionListener());
        yellow.addActionListener(new yellowizeActionListener());
        red.addActionListener(new redizeActionListener());
        azul.addActionListener(new azulizeActionListener());
        blue.addActionListener(new blueizeActionListener());

        smallBoard.addActionListener(new smallBoardActionListener());
        mediumBoard.addActionListener(new mediumBoardActionListener());
        largeBoard.addActionListener(new largeBoardActionListener());
        
    }

    public static void main(String[] args) {
        FloodItClone flood = new FloodItClone();
        flood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flood.setSize(1050, 850);
        flood.pack();
        flood.setLocationRelativeTo(null);
        flood.setVisible(true);
    }

    private static class purplizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(PURPLE)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
    }

    private static class greenizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(GREEN)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
    }

    private static class yellowizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(YELLOW)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
    }

    private static class redizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(RED)) {
                turnsTaken++;
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
        }

    private static class azulizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
            if (makeAMove(AZUL)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
        }
        }
    }

    private static class blueizeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (firstGameStarted) {
                if (makeAMove(BLUE)) {
                turnsTaken++;
                moves.setText(turnsTaken + "/" + turns);
                board.setBoard(matrix);
                board.repaint();
                if (checkBoard() || turnsTaken == turns) {
                    scores.setText(String.valueOf(scoreIt()));
                    firstGameStarted=false;
                }
            }
            }
            
        }
    }

    private static class smallBoardActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            initialized = true;
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

        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            initialized = true;
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

        @Override
        public void actionPerformed(ActionEvent ae) {
            turnsTaken = 0;
            scores.setText("0");
            initialized = true;
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
        boolean movemade = true;
        boolean amovemade = false;
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
                                
                                if (matrix[i][j].getColor().equals(matrix[0][1].getColor()) && matrix[0][1].isConnected()!=true) {
                                    matrix[0][1].setColor(color);
                                    matrix[0][1].setConnected(true);
                                    
                                    movemade = true;
                                }
                                if (matrix[i][j].getColor().equals(matrix[1][0].getColor()) && matrix[1][0].isConnected()!=true) {
                                    matrix[1][0].setColor(color);
                                    matrix[1][0].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            } 
                            else if (j == dimension-1) {
                                
                                if (matrix[i][j].getColor().equals(matrix[0][dimension-2].getColor()) && matrix[0][dimension-2].isConnected()!=true) {
                                    matrix[0][dimension-2].setColor(color);
                                    matrix[0][dimension-2].setConnected(true);
                                    
                                    movemade = true;
                                }
                                if (matrix[i][j].getColor().equals(matrix[1][dimension-1].getColor()) && matrix[1][dimension-1].isConnected()!=true) {
                                    matrix[1][dimension-1].setColor(color);
                                    matrix[1][dimension-1].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            } 
                            else {
                                
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
                        }
                        else if (i == dimension-1) {
                            if (j == 0) {
                                
                                if (matrix[i][j].getColor().equals(matrix[dimension-1][1].getColor()) && matrix[dimension-1][1].isConnected()!=true) {
                                    matrix[dimension-1][1].setColor(color);
                                    matrix[dimension-1][1].setConnected(true);
                                    
                                    movemade = true;
                                }
                                if (matrix[i][j].getColor().equals(matrix[dimension-2][0].getColor()) && matrix[dimension-2][0].isConnected()!=true) {
                                    matrix[dimension-2][0].setColor(color);
                                    matrix[dimension-2][0].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            } 
                            else if (j == dimension-1) {
                                
                                if (matrix[i][j].getColor().equals(matrix[dimension-1][dimension-2].getColor()) && matrix[dimension-1][dimension-2].isConnected()!=true) {
                                    matrix[dimension-1][dimension-2].setColor(color);
                                    matrix[dimension-1][dimension-2].setConnected(true);
                                    
                                    movemade = true;
                                }
                                if (matrix[i][j].getColor().equals(matrix[dimension-2][dimension-1].getColor()) && matrix[dimension-2][dimension-1].isConnected()!=true) {
                                    matrix[dimension-2][dimension-1].setColor(color);
                                    matrix[dimension-2][dimension-1].setConnected(true);
                                    movemade = true;
                                    
                                }
                                
                            } 
                            else {
                                
                                if (matrix[i][j].getColor().equals(matrix[dimension-2][j].getColor()) && matrix[dimension-2][j].isConnected()!=true) {
                                    matrix[dimension-2][j].setColor(color);
                                    matrix[dimension-2][j].setConnected(true);
                                    movemade = true;
                                    
                                }
                                if (matrix[i][j].getColor().equals(matrix[i][j + 1].getColor()) && matrix[i][j+1].isConnected()!=true) {
                                    matrix[i][j + 1].setColor(color);
                                    matrix[i][j + 1].setConnected(true);
                                    movemade = true;
                                    
                                }
                                if (matrix[i][j].getColor().equals(matrix[i][j-1].getColor()) && matrix[i][j-1].isConnected()!=true) {
                                    matrix[i][j-1].setColor(color);
                                    matrix[i][j-1].setConnected(true);
                                    movemade = true;
                                    
                                }
                               
                            }
                        }
                        else if (j == 0) {
                            
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
                            
                        }
                        else if (j == dimension-1) {
                            
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
                                matrix[i][j + 1].setConnected(true);
                                movemade = true;
                                
                            }
                            
                        }
                    }
                }

            }
            if (movemade == true) {
                amovemade = true;

            }
        }

        return amovemade;
    }

    private static boolean checkBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j].isConnected() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int scoreIt() {
        int score = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j].isConnected() == false) {
                    score--;
                }
            }
        }
        score = score + (turns - turnsTaken) * 100;
        return score;
    }

    private static void initializeBoard(int dimension) {
        for (int i = 0; i < dimension; i++) {
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
                matrix[i][j] = new LittleSquare(color, false, false);
            }
        }
        matrix[0][0].setConnected(true);
        boolean movemade=true;
        Color color =  matrix[0][0].getColor();
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

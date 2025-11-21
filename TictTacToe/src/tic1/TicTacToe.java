package tic1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton[] blist;
    private JButton replayButton;

    private JTextArea area;
    private char currentPlayer = 'X';
    private int moves = 0;

  
    public TicTacToe() {

        setTitle("Tic-Tac-Toe");
        setSize(420, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JMenuBar menu = new JMenuBar();
        JMenu option = new JMenu("Options");
        JMenuItem restartItem = new JMenuItem("Restart");
       
       JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(e -> System.exit(0));


        restartItem.addActionListener(e -> {
            clearBoard();
            area.setText("");
            replayButton.setEnabled(false);
        });

        option.add(restartItem);
        option.add(exitItem);
        menu.add(option);
        setJMenuBar(menu);

       
        JPanel topPanel = new JPanel();
        area = new JTextArea(2, 20);
        area.setEditable(false);
        area.setFont(new Font("Segoe UI", Font.BOLD, 16));
        area.setBackground(Color.LIGHT_GRAY);
        area.setText("Player X turn");
        topPanel.add(area);

      
        replayButton = new JButton("Replay");
        replayButton.setEnabled(false);
        replayButton.addActionListener(e -> {
            clearBoard();
            area.setText("Player X turn");
            replayButton.setEnabled(false);
        });
        topPanel.add(replayButton);

        
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 4, 4));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        blist = new JButton[9];

        for (int i = 0; i < 9; i++) {

            blist[i] = new JButton(" ");
            blist[i].setFont(new Font("Segoe UI", Font.BOLD, 60));
            blist[i].setBackground(new Color(45, 45, 45));
            blist[i].setForeground(Color.WHITE);
            blist[i].setFocusable(false);

            blist[i].addActionListener(new ButtonListener());

            gridPanel.add(blist[i]);
        }

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            if (!btn.getText().equals(" ")) return; // ignore used cell

            btn.setText(String.valueOf(currentPlayer));
            moves++;

            int result = checkWinner();

            if (result == 1) {
                area.setText("X WINS!");
                endGame();
            } else if (result == 2) {
                area.setText("O WINS!");
                endGame();
            } else if (moves == 9) {
                area.setText("DRAW!");
                endGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                area.setText("Player " + currentPlayer + " turn");
            }
        }
    }

   

    private void endGame() {
        for (JButton b : blist) {
            b.setEnabled(false);
        }
        replayButton.setEnabled(true);
    }

   

    public void clearBoard() {
        for (JButton b : blist) {
            b.setText(" ");
            b.setEnabled(true);
        }
        currentPlayer = 'X';
        moves = 0;
    }



    private int checkWinner() {

        String[][] board = new String[3][3];

        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = blist[i].getText();
        }

        // ROWS + COLUMNS
        for (int i = 0; i < 3; i++) {
            if (threeEqual(board[i][0], board[i][1], board[i][2], "X")) return 1;
            if (threeEqual(board[i][0], board[i][1], board[i][2], "O")) return 2;

            if (threeEqual(board[0][i], board[1][i], board[2][i], "X")) return 1;
            if (threeEqual(board[0][i], board[1][i], board[2][i], "O")) return 2;
        }

        // DIAGONALS
        if (threeEqual(board[0][0], board[1][1], board[2][2], "X")) return 1;
        if (threeEqual(board[0][0], board[1][1], board[2][2], "O")) return 2;

        if (threeEqual(board[0][2], board[1][1], board[2][0], "X")) return 1;
        if (threeEqual(board[0][2], board[1][1], board[2][0], "O")) return 2;

        return 0;
    }

    private boolean threeEqual(String a, String b, String c, String player) {
        return a.equals(player) && b.equals(player) && c.equals(player);
    }

    

    public static void main(String[] args) {
        TicTacToe frame = new TicTacToe();
        frame.setVisible(true);
    }
}

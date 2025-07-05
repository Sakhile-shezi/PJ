package tic1;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.awt.*;

import javax.swing.*;

public class TicTacToe extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//Attributes
		JMenuBar menu = new JMenuBar();
		
		int i;
		char currentPlayer ='X';
		int p= 0;
		static JButton[] blist;
		JTextArea area;
		static String[][] board = new String[3][3];
		//constructor
		public TicTacToe() {
		this.setTitle("All");
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		area = new JTextArea(3,6);
		area.setFont((new Font("Helvetica", Font.BOLD,15)));  
		area.setBackground(Color.lightGray);
		area.setPreferredSize(new Dimension(3,6));
		JMenu option = new JMenu("Option");
       JMenuItem restartItem = new JMenuItem("Restart");
         restartItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        clearBoard();
        area.setText("");
        replayButton.setEnabled(false);  // Optional: disable the replay button
           }
       });
			 option.add(restartItem);
        menu.add(option);
        this.setJMenuBar(menu);

		
		JPanel panel1 = new JPanel(new GridLayout(1,1));
		panel1.setSize(100,50);
			replayButton = new JButton("Replay");
        replayButton.setEnabled(false); // Disabled until game ends
        replayButton.setFocusable(false);
        replayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        clearBoard();
        area.setText("");
        replayButton.setEnabled(false); // Disable again after use
        }
       });
		panel1.add(area);
		JPanel panel2 = new JPanel(new GridLayout(3,3,2,2));
		panel2.setPreferredSize(new Dimension(140,200));
		//panel2.add(area);
		blist = new JButton[9];
		//blist.se
		for( i=0;i<blist.length;i++)	{
			blist[i]=new JButton(" ");
			//design
			blist[i].setBackground(Color.darkGray);
			blist[i].setForeground(Color.WHITE);
			blist[i].addActionListener(new ActionListener() {
	       //ActionListener
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton bclick = (JButton)e.getSource();
					
					bclick.setFont(new Font("Areal",Font.BOLD,110));
					if(bclick.getText().equals(" ")) {
						bclick.setText(currentPlayer+"");
						p++;
						currentPlayer = (currentPlayer=='X')?'O':'X';
						
					}
					int s = checkwin();
					 if (s == 1) {
             area.setText("X wins");
             currentPlayer = ' ';
             replayButton.setEnabled(true);
          } else if (s == 2) {
             area.setText("O wins");
             currentPlayer = ' ';
            replayButton.setEnabled(true);
           } else if (p == 9) {
             area.setText("Draw!");
             currentPlayer = ' ';
            replayButton.setEnabled(true);
            }  
					}
				}
				
			});
			blist[i].setFocusable(false);
			panel2.add(blist[i]);
		}	
		
		setLayout(new BorderLayout());
		
		add(panel1,BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);

		}
		//check win method
		public static int checkwin() {
		    // board = new String[3][3];
		    for (int i = 0; i < 9; i++) {
		        board[i / 3][i % 3] = blist[i].getText();
		    }

		    // Check rows, columns, and diagonals
		    for (int i = 0; i < 3; i++) {
		        // Rows
		        if (board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X")) return 1;
		        if (board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O")) return 2;

		        // Columns
		        if (board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) return 1;
		        if (board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) return 2;
		    }

		    // Diagonals
		    if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) return 1;
		    if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) return 2;
		    if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) return 1;
		    if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) return 2;

		    return 0; // No winner yet
		}
		public void clearBoard() {
			 for( int i=0;i<blist.length;i++)	{
			    	blist[i].setText(" ");}
			p = 0 // reset move count
				currentPlayer ='X'; //reset player x
		}
		
    
  
  public static void main(String[] args) {
	  		
TicTacToe frame = new TicTacToe();
frame.setResizable(false);
frame.setVisible(true);

 }
	   
}


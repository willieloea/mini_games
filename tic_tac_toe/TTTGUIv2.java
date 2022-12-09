import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;



public class TTTGUIv2 extends JFrame implements java.awt.event.ActionListener
{
    // JLabel label;
    TTTv2 game = new TTTv2();
    JFrame frame = new JFrame();
	JPanel button_panel = new JPanel();
	JButton[] buttons = new JButton[9];

    public TTTGUIv2(boolean playPerson)
    {
        // Setup window in which game will be played
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setLayout(new BorderLayout());

        // Setup panel on which the pieces will be placed
		button_panel.setLayout(new GridLayout(3,3, 10, 10));
		button_panel.setBackground(new Color(0,0,0));

        // Setup buttons players can press to place pieces
        for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(25, 15, 71));
			buttons[i].addActionListener(this);
		}

		frame.add(button_panel);
        
        if (playPerson) {
            frame.setTitle("1v1 TTT");
            frame.setVisible(true);
            System.out.println("You want to play a person");
        }
        else {
            frame.setTitle("Bot TTT");
            frame.setVisible(true);
            System.out.println("You want to play a robot");
            // choose to play first (X), or second (O)
        }
        // game pop up, or game replaces screen
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(game.getTurn()%2 == 0) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
                        game.place(i);
                        int[] winningTripple = game.checkWin();
						if (winningTripple != null) {
                            declareWinner(winningTripple);
                        }
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
                        game.place(i);
                        int[] winningTripple = game.checkWin();
						if (winningTripple != null) {
                            declareWinner(winningTripple);
                        }
					}
				}
			}			
		}
    }

    private void declareWinner(int[] winningTripple)
    {
		buttons[winningTripple[0]].setBackground(Color.GREEN);
		buttons[winningTripple[1]].setBackground(Color.GREEN);
		buttons[winningTripple[2]].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
    }


    public static void main(String[] args)
    {
        new TTTGUIv2(true);
    }
}
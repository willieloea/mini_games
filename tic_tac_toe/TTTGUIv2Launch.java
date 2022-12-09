import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class TTTGUIv2Launch implements ActionListener
{
    JFrame frame = new JFrame("TTT Menu");
    ImageIcon personIcon = new ImageIcon("human.png");
    JButton playPer = new JButton(personIcon);
    ImageIcon robotIcon = new ImageIcon("robot.png");
    JButton playBot = new JButton(robotIcon);
    
    public TTTGUIv2Launch()
    {
        // setup buttons
        playPer.setFocusable(false);
        playPer.setBackground(new Color(146, 93, 198));
        playPer.addActionListener(this);
        playBot.setFocusable(false);
        playBot.setBackground(new Color(93, 198, 149));
        playBot.addActionListener(this);
        // setup frame
        frame.add(playPer);
        frame.add(playBot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(1, 2, 5, 5));
        frame.setBackground(Color.BLACK);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == playPer) {
            // frame.dispose(); // to only make one window
            new TTTGUIv2(true);
        }
        if (e.getSource() == playBot) {
            new TTTGUIv2(false);
        }
        
    }

    public static void main(String[] args)
    {
        new TTTGUIv2Launch();
    }
}
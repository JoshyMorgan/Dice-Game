package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.MainFrame;

public class RollListener implements ActionListener {
	private MainFrame mainFrame;
	private GameEngine gameEngine;

	public RollListener(MainFrame mainFrame, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Player player = mainFrame.getCurrentPlayer();
		
		// check if there is any player to roll
		if (player == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Please add a new player first!");
		}
		
		// check if player has placed bet
		else if (mainFrame.getCurrentPlayer().getBet() == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Please set a bet for the current player!");
		}
		
		// check if player has rolled
		else if (mainFrame.getCurrentPlayer().getResult() != null) {
			JOptionPane.showMessageDialog(new JFrame(), "This player has rolled in this round!");
		}
		
		// check if there is any rolling player
		else if (mainFrame.getRollingState() == true) {
			JOptionPane.showMessageDialog(new JFrame(), "Please wait until rolling is done!");
		}
		else {
			// set rolling status to true
			mainFrame.toggleRollingState();
			
			// Update Status Bar
			mainFrame.getStatusBar().updateStatus(String.format("Player id: %s is currently rolling.", player.getPlayerId()));
			
			// Rolling
			Thread rollingThread = new Thread() {
				public void run() {
					gameEngine.rollPlayer(player, 100, 1000, 100, 50, 500, 50);
				}
			};
			rollingThread.start();

			// set rolling status to false
			mainFrame.toggleRollingState();
		}
		
	}

}

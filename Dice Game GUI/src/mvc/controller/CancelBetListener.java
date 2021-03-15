package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.MainFrame;

public class CancelBetListener implements ActionListener {
	private MainFrame mainFrame;
	private GameEngine gameEngine;
	public CancelBetListener(MainFrame mainFrame, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (mainFrame.getCurrentPlayer() == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Please add a new player first!");
		}
		
		else if (mainFrame.getCurrentPlayer().getBet() == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Please set a bet for the current player!");
		}
		
		else {
			gameEngine.placeBet(mainFrame.getCurrentPlayer(), 0);
			// Update Summary Panel
			mainFrame.getSummaryPanel().clearText();
			for(Player player : gameEngine.getAllPlayers()) {
				mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, win/loss: N/A.", 
						player.getPlayerName(), player.getPoints(), player.getBet()));
			}
			JOptionPane.showMessageDialog(new JFrame(), "Bet has been canceled");
			
			// Update Status Bar
			mainFrame.getStatusBar().updateStatus(String.format("Player id: %s has canceled the bet.", mainFrame.getCurrentPlayer().getPlayerId()));
		}
	}

}

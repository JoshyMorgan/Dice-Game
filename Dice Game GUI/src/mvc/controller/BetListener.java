package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.BetWindow;
import mvc.view.MainFrame;

public class BetListener implements ActionListener {
	private MainFrame mainFrame;
	private BetWindow betWindow;
	private GameEngine gameEngine;
	private String betInput = null;
	private Player playerSelected;
	
	public BetListener(MainFrame mainFrame, BetWindow betWindow, GameEngine gameEngine) {
		this.betWindow = betWindow;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.betInput = betWindow.getBetAmount();
		this.playerSelected = betWindow.getSelectedPlayer();
		
		// check if bet inputed is an int and smaller than player current points
		if (mainFrame.isInteger(betInput) && Integer.parseInt(betInput) > 0 && Integer.parseInt(betInput) <= playerSelected.getPoints()) {
			gameEngine.placeBet(playerSelected, Integer.parseInt(betInput));
			
			// Update Summary Panel
			mainFrame.getSummaryPanel().clearText();
			for(Player player : gameEngine.getAllPlayers()) {
				mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, win/loss: N/A.", 
						player.getPlayerName(), player.getPoints(), player.getBet()));
			}
			
			// Update Status Bar
			mainFrame.getStatusBar().updateStatus(String.format("Player id: %s has bet and ready to roll.", playerSelected.getPlayerId()));
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Please input a valid bet.");		
		}
		
	}

}

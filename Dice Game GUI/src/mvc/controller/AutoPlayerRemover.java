package mvc.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.GameToolBar;
import mvc.view.MainFrame;

public class AutoPlayerRemover {
	private MainFrame mainFrame;
	private GameEngine gameEngine;
	
	public AutoPlayerRemover(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}
	
	public void checkBetAndRemove() {
		// loop through the player collection
		for (Player player: gameEngine.getAllPlayers()) {
			//check if a player points is 0 and remove
			if (player.getPoints() == 0) {
				JOptionPane.showMessageDialog(new JFrame(), 
						String.format("Player id: %s is broke and will be removed", player.getPlayerId()));
				gameEngine.removePlayer(player);
				
				// Update Status Bar
				mainFrame.getStatusBar().updateStatus(String.format("Player id: %s is broke and removed from the casino.", player.getPlayerId()));
			}
		}
		
		//update select player JComboBox
		GameToolBar gameToolBar = mainFrame.getGameToolBar();
		gameToolBar.updateNewPlayer();
		
		// Update Summary Panel
		mainFrame.getSummaryPanel().clearText();
		for(Player player : gameEngine.getAllPlayers()) {
			mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, win/loss: N/A.", 
					player.getPlayerName(), player.getPoints(), player.getBet()));
		}
	}
}

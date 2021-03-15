package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.GameToolBar;
import mvc.view.MainFrame;
import mvc.view.RemovePlayerWindow;

public class RemovePlayerButtonListener implements ActionListener {
	private RemovePlayerWindow removePlayerWindow;
	private GameEngine gameEngine;
	private String removePlayerId;
	private MainFrame mainFrame;
	
	public RemovePlayerButtonListener(MainFrame mainFrame, RemovePlayerWindow removePlayerWindow, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.removePlayerWindow = removePlayerWindow;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		removePlayerId = removePlayerWindow.getRemovePlayerId();

		//remove player from gameEngine
		if (gameEngine.getPlayer(removePlayerId) == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Player doesn't exist, try again!");
		}
		else {
			gameEngine.removePlayer(gameEngine.getPlayer(removePlayerId));
			
			//update select player JComboBox
			GameToolBar gameToolBar = mainFrame.getGameToolBar();
			gameToolBar.updateNewPlayer();
					
			// Update Summary Panel
			mainFrame.getSummaryPanel().clearText();
			for(Player player : gameEngine.getAllPlayers()) {
				mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, win/loss: N/A.", 
						player.getPlayerName(), player.getPoints(), player.getBet()));
			}

			// Update Status Bar
			mainFrame.getStatusBar().updateStatus(String.format("Player id: %s is removed.", mainFrame.getCurrentPlayer().getPlayerId()));
			
			// check and roll house if all player has rolled when the player is removed
			mainFrame.rollHouseCheck();
		}

	}

}

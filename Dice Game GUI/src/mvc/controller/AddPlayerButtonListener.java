package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AddPlayerWindow;
import mvc.view.GameToolBar;
import mvc.view.MainFrame;

public class AddPlayerButtonListener implements ActionListener {
	private AddPlayerWindow addPlayerWindow;
	private GameEngine gameEngine;
	private MainFrame mainFrame;

	public AddPlayerButtonListener(MainFrame mainFrame, AddPlayerWindow addPlayerWindow, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.addPlayerWindow = addPlayerWindow;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//player has String id, String name, int initialPoints
		String id = this.addPlayerWindow.getInputId();
		String name = this.addPlayerWindow.getInputName();
		String pointsInputed = this.addPlayerWindow.getInputPoints();
		
		// check if points inputed is a String
		if (!mainFrame.isInteger(pointsInputed)) {
			JOptionPane.showMessageDialog(new JFrame(), "Please enter an integer for points");
		}
		
		// check if points inputed is larger than 0
		else if (Integer.parseInt(pointsInputed) <= 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Please enter an integer that is larger than 0");			
		}
		else {
			
			// Update Summary Panel
			if (gameEngine.getPlayer(id) == null) {
				mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: 0, win/loss: N/A.", 
						name, pointsInputed));
			}
			else {
				mainFrame.getSummaryPanel().clearText();
				for(Player player : gameEngine.getAllPlayers()) {
					mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, win/loss: N/A.", 
							player.getPlayerName(), player.getPoints(), player.getBet()));
				}
			}
			
			int points = Integer.parseInt(pointsInputed);
			
			//add new Player to the engine
			Player newPlayer = new SimplePlayer(id, name, points);
			this.gameEngine.addPlayer(newPlayer);
						
			//update player list
			GameToolBar gameToolBar = mainFrame.getGameToolBar();
			gameToolBar.updateNewPlayer();

			// Update Status Bar
			mainFrame.getStatusBar().updateStatus(String.format("Player id: %s is added", newPlayer.getPlayerId()));
		}
	}

}

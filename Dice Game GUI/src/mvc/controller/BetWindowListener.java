package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import mvc.view.BetWindow;
import mvc.view.MainFrame;

public class BetWindowListener implements ActionListener {
	private MainFrame mainFrame;
	private GameEngine gameEngine;
	
	public BetWindowListener(MainFrame mainFrame, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//check if there has been a player
		if (mainFrame.getCurrentPlayer() == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Please add a new player first!");
		}
		
		//check if the player has rolled ( meaning the player has a dice pair or not)
		else if (mainFrame.getCurrentPlayer().getResult() != null) {
			JOptionPane.showMessageDialog(new JFrame(), "This Player has already rolled!");
		}
		else {
			BetWindow betWindow = new BetWindow(mainFrame, gameEngine);
			betWindow.setSelectingPlayer(mainFrame.getCurrentPlayer());
		}
		
	}

}

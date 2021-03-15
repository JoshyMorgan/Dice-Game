package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import mvc.view.MainFrame;
import mvc.view.RemovePlayerWindow;

public class RemovePlayerWindowListener implements ActionListener{
	private GameEngine gameEngine;
	private MainFrame mainFrame;

	public RemovePlayerWindowListener(MainFrame mainFrame, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// Check if there is any player
		if (mainFrame.getCurrentPlayer() == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Please add a player first!");
		}
		else {
			new RemovePlayerWindow(mainFrame, gameEngine);
		}
	}

}

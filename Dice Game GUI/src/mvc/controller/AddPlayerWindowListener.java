package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import mvc.view.AddPlayerWindow;
import mvc.view.MainFrame;

public class AddPlayerWindowListener implements ActionListener{
	private GameEngine gameEngine;
	private MainFrame mainFrame;

	public AddPlayerWindowListener(MainFrame mainFrame, GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new AddPlayerWindow(mainFrame, this.gameEngine);
	}
}

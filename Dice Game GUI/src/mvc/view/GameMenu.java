package mvc.view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;
import mvc.controller.AddPlayerWindowListener;
import mvc.controller.BetWindowListener;
import mvc.controller.CancelBetListener;
import mvc.controller.RemovePlayerWindowListener;
import mvc.controller.RollListener;

public class GameMenu extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GameMenu(GameEngine gameEngine, MainFrame mainFrame) {
		//Player tab
		JMenu player = new JMenu("Player");
		add(player);
		this.addItem("Add", player, new AddPlayerWindowListener(mainFrame, gameEngine));
		this.addItem("Remove", player, new RemovePlayerWindowListener(mainFrame,gameEngine));
        setVisible(true);
        
        // Action tab
		JMenu action = new JMenu("Action");
		add(action);		
		this.addItem("Bet", action, new BetWindowListener(mainFrame, gameEngine));
		this.addItem("Roll", action, new RollListener(mainFrame, gameEngine));
		this.addItem("Cancel Bet", action, new CancelBetListener(mainFrame, gameEngine));
	}

	private void addItem(String item, JMenu list, ActionListener e) {
		JMenuItem newItem = new JMenuItem(item);
		list.add(newItem);
		newItem.addActionListener(e);
	}
	
}

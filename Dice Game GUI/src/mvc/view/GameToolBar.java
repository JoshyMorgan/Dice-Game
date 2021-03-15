package mvc.view;

import mvc.controller.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class GameToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> playerList;
	private String[] players = new String[] {"None Selected"};
	private GameEngine gameEngine;
	
	public GameToolBar(GameEngine gameEngine, MainFrame mainFrame){
		//player menu
		this.gameEngine = gameEngine;
		JPanel panel = new JPanel();
		JLabel currentPlayer = new JLabel("Current Player");
		panel.add(currentPlayer);
		add(panel);
		
		// Select Player box
		playerList = new JComboBox<>(players);
		playerList.setBounds(100, 20, 165, 25);
		playerList.addItemListener(new PlayerSelectListener(mainFrame, this, gameEngine));
		panel.add(playerList);
		
	}
	
	public JComboBox<String> getSelectedComboBox() {
		return playerList;
	}
	
	public void updateNewPlayer() {
		playerList.removeAllItems();
		
		for(Player player: gameEngine.getAllPlayers()) {
			this.playerList.addItem("Id: " + player.getPlayerId() + " " + "Name: " + player.getPlayerName());
		}
	}
	
}

package mvc.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.GameToolBar;
import mvc.view.MainFrame;

public class PlayerSelectListener implements ItemListener {
	private GameToolBar gameToolBar;
	private MainFrame mainFrame;
	private GameEngine gameEngine;
	
	public PlayerSelectListener(MainFrame mainFrame, GameToolBar gameToolBar, GameEngine gameEngine) {
		this.gameToolBar = gameToolBar;
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if (gameToolBar != null) {
			if(e.getSource() == gameToolBar.getSelectedComboBox()) {
				int state = e.getStateChange();
				if(state == ItemEvent.SELECTED) {
					String playerIdAndName = (String) gameToolBar.getSelectedComboBox().getSelectedItem();
					String[] splited = playerIdAndName.split("\\s+");
					String playerId = splited[1];
					
					Player player = gameEngine.getPlayer(playerId);
					mainFrame.setCurrentPlayer(player);
					mainFrame.getDicePanel().getPaintDice().setCurrentPlayerDie();
					
					// Update Status Bar
					if (mainFrame.getRollingState()) {
						// keep the rolling status
						;
					}
					else if (player.getResult() == null && player.getBet() != 0) {
						mainFrame.getStatusBar().updateStatus(String.format("Player id: %s has bet and ready to roll.", playerId));
					}
					else if (player.getResult() != null ) {
						mainFrame.getStatusBar().updateStatus(String.format("Player id: %s has rolled. Result: %s", playerId, player.getResult().toString()));
					}
					else {
					mainFrame.getStatusBar().updateStatus(String.format("Player id: %s selected.", playerId));
					}
				}
			}
		}	
	}

}

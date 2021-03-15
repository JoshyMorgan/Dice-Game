package mvc.model;

import java.util.Collection;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.MainFrame;
import mvc.view.PaintDice;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {
	private MainFrame mainFrame;

	public GameEngineCallbackGUI(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
	}

	@Override
	public void playerDieUpdate(Player player, Die die, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		// Update Dice Panel
		PaintDice paintDice = mainFrame.getDicePanel().getPaintDice();

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				// do GUI update on UI thread
				paintDice.setDie(player, die);
			}
		});
		
	}

	@Override
	public void houseDieUpdate(Die die, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		PaintDice paintDice = mainFrame.getDicePanel().getPaintDice();
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				// do GUI update on UI thread
				paintDice.setDie(die);
			}
		});
	}

	@Override
	public void playerResult(Player player, DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		mainFrame.rollHouseCheck();
		
		// Update Status Bar
		mainFrame.getStatusBar().updateStatus(String.format("Player id: %s has rolled. Result: %s", 
				player.getPlayerId(), result.toString()));
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
		// Update Status Bar
		mainFrame.getStatusBar().updateStatus(String.format("The House has rolled. Result: %s", result.toString()));
		
		mainFrame.getSummaryPanel().clearText();
		Collection<Player> playerCollection = gameEngine.getAllPlayers();
	    for (Player player: playerCollection) {
	    	String winLossAmount;
	    	if (result.compareTo(player.getResult()) <0) {
	    		winLossAmount = String.format("Win: %s points",player.getBet());
	    	}
	    	else if (result.compareTo(player.getResult())== 0) {
	    		winLossAmount = String.format("Draw");
	    	}
	    	else {
	    		winLossAmount = String.format("Loss: %s points",player.getBet());
	    	}
	    	
			mainFrame.getSummaryPanel().addText(String.format("Player name: %s. Points: %s, bet: %s, %s.", 
					player.getPlayerName(), player.getPoints(), player.getBet(), winLossAmount));
	    	
			// set player result dice pair to null and reset bet for all player
	    	player.setResult(null);
	    	player.resetBet();
	    }
	}
	
}

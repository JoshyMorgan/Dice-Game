package mvc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.controller.BetListener;
import mvc.model.BasicFrameFactory;

public class BetWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField betField;
	private JLabel playerNameLabel;
	private JLabel playerIdLabel;
	private JLabel playerPointsLabel;
	private Player player;
	
	public BetWindow(MainFrame mainFrame, GameEngine gameEngine) {
		JFrame window = new BasicFrameFactory("Bet", 300, 300);
		JPanel panel = new JPanel();
		window.add(panel);
		
		panel.setLayout(null);
		
		//player id display label and field
		JLabel idLabel = new JLabel("Player id:");
		idLabel.setBounds(10, 20, 165, 25);
		panel.add(idLabel);
		
		playerIdLabel = new JLabel("None Selected");
		playerIdLabel.setBounds(100,20,165,25);
		panel.add(playerIdLabel);
		
		//player name display label and field
		JLabel nameLabel = new JLabel("Player name:");
		nameLabel.setBounds(10, 60, 165, 25);
		panel.add(nameLabel);
		
		playerNameLabel = new JLabel("None Selected");
		playerNameLabel.setBounds(100,60,165,25);
		panel.add(playerNameLabel);
		
		//player points display label and field
		JLabel pointsLabel = new JLabel("Points");
		pointsLabel.setBounds(10, 100, 165, 25);
		panel.add(pointsLabel);
		
		playerPointsLabel = new JLabel("None Selected");
		playerPointsLabel.setBounds(100, 100, 165,25);
		panel.add(playerPointsLabel);
		
		//Bet input field
		JLabel betLabel = new JLabel("Bet Points");
		betLabel.setBounds(10, 140, 80, 25);
		panel.add(betLabel);
		
		betField = new JTextField(20);
		betField.setBounds(100, 140, 165, 25);
		panel.add(betField);
		
		JButton betButton = new JButton("Bet");
		betButton.addActionListener(new BetListener(mainFrame, this, gameEngine));
		betButton.setBounds(10, 170, 80, 25);
		panel.add(betButton);

	}
		
	public String getBetAmount() {
		return betField.getText();
	}
	
	public void setSelectingPlayer(Player player) {
		if (player != null) {
			this.player = player;
			this.playerIdLabel.setText(player.getPlayerId());
			this.playerNameLabel.setText(player.getPlayerName());
			this.playerPointsLabel.setText(Integer.toString(player.getPoints()));
		}
	}
	
	public Player getSelectedPlayer() {
		return this.player;
	}

}

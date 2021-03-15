package mvc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.interfaces.Die;
import model.interfaces.Player;
import mvc.model.Dice.Die1;
import mvc.model.Dice.Die2;
import mvc.model.Dice.Die3;
import mvc.model.Dice.Die4;
import mvc.model.Dice.Die5;
import mvc.model.Dice.Die6;

public class PaintDice extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	protected int panelWidth;
	protected int panelHeight;
	private String currentLeftDie = "die 1";
	private String currentRightDie = "die 6";
	public PaintDice(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void invalidate() {
		// get frame width and height
	    super.invalidate();
	    this.panelWidth = getWidth();
	    this.panelHeight = getHeight();
		setSize(panelWidth, panelHeight);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int dieEdgeSize;
		int die1X;
		int die1Y;
		int die2X;
		int die2Y;
		
		g.setColor(Color.black);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));		

		if (panelHeight <= panelWidth/2) {
			//draw left die
			//draw reectangle
			dieEdgeSize = this.panelHeight -40;
			die1Y = 20;
			die1X = (panelWidth/2 - dieEdgeSize) /2 ;	
			g.drawRect(die1X, die1Y, dieEdgeSize, dieEdgeSize);
			
		}	

		
		else {
			//draw left die
			//draw rectangle
			dieEdgeSize = this.panelWidth/2 - 40;
			die1X = 20;
			die1Y = (panelHeight - dieEdgeSize) /2;
			g.drawRect(die1X, die1Y, dieEdgeSize, dieEdgeSize);
		}	
	
		//draw dots
		int[][][] leftDie = this.getLeftDieStats(panelWidth, panelHeight);

		for (int i = 0; i < leftDie[0].length; i++) {
			g.fillOval(leftDie[0][i][0], leftDie[0][i][1], leftDie[0][i][2], leftDie[0][i][2]);
		}
		//draw right die
		//draw rectangle
		die2Y = die1Y;
		die2X = die1X + panelWidth/2;
		g.drawRect(die2X, die2Y, dieEdgeSize, dieEdgeSize);								
		
		//draw dots
		int[][][] rightDie = this.getRightDieStats(panelWidth, panelHeight);
		for (int i = 0; i < rightDie[0].length; i++) {
			g.fillOval(rightDie[1][i][0], rightDie[1][i][1], rightDie[1][i][2], rightDie[1][i][2]);
		}
		

	}
	
	public void setLeftDie(String die) {
		this.currentLeftDie = die;
		this.repaint();
	}
	
	public void setRightDie(String die) {
		this.currentRightDie = die;
		this.repaint();
	}
	
	private int[][][] getLeftDieStats(int panelWidth, int panelHeight) {
		if (this.currentLeftDie.equals("die 1")) {
			int[][][] die = new Die1().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentLeftDie.equals("die 2")) {
			int[][][] die = new Die2().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentLeftDie.equals("die 3")) {
			int[][][] die = new Die3().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentLeftDie.equals("die 4")) {
			int[][][] die = new Die4().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentLeftDie.equals("die 5")) {
			int[][][] die = new Die5().getDots(panelWidth, panelHeight);
			return die;
		}
		else {
			int[][][] die = new Die6().getDots(panelWidth, panelHeight);
			return die;
		}
		
	}
	
	private int[][][] getRightDieStats(int panelWidth, int panelHeight) {		
		if (this.currentRightDie.equals("die 1")) {
			int[][][] die = new Die1().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentRightDie.equals("die 2")) {
			int[][][] die = new Die2().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentRightDie.equals("die 3")) {
			int[][][] die = new Die3().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentRightDie.equals("die 4")) {
			int[][][] die = new Die4().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentRightDie.equals("die 5")) {
			int[][][] die = new Die5().getDots(panelWidth, panelHeight);
			return die;
		}
		else if (this.currentRightDie.equals("die 6")) {
			int[][][] die = new Die6().getDots(panelWidth, panelHeight);
			return die;
		}
		return null;
	}
	
	public void setDie(Player player, Die die) {
		int dieNumber = die.getNumber();
		int dieValue = die.getValue();
		
		if (player.getPlayerId() == mainFrame.getCurrentPlayer().getPlayerId()) {
			if (dieNumber == 1) {
				this.setLeftDie("die " + Integer.toString(dieValue));
			}
			else {
				this.setRightDie("die " + Integer.toString(dieValue));
			}
		}
	}
	
	public void setDie(Die die) {
		int dieNumber = die.getNumber();
		int dieValue = die.getValue();
		if (dieNumber == 1) {
			this.setLeftDie("die " + Integer.toString(dieValue));
		}
		else {
			this.setRightDie("die " + Integer.toString(dieValue));
		}
	}
	

	public void setCurrentPlayerDie() {
		// TODO Auto-generated method stub
		Player selectingPlayer = mainFrame.getCurrentPlayer();
		if (selectingPlayer.getResult() != null) {
			this.setDie(selectingPlayer, selectingPlayer.getResult().getDie1());
			this.setDie(selectingPlayer, selectingPlayer.getResult().getDie2());
		}
		else {
			this.setLeftDie("die 1");
			this.setRightDie("die 6");
		}
		
	}
}

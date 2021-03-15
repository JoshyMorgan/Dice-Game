package mvc.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

public class DicePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaintDice paintDice;
	private int width;
	private int height;
	
	public DicePanel(GameEngine gameEngine, MainFrame mainFrame){

		setLayout(new BorderLayout());
		
		paintDice = new PaintDice(mainFrame);
		add(paintDice);
		
	}
	
	public int getPanelWidth() {
		return this.width;
	}
	
	public int getPanelHeight() {
		return this.height;
	}
	
	public PaintDice getPaintDice() {
		return paintDice;
	}
}

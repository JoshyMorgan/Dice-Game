package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.controller.AutoPlayerRemover;
import mvc.model.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;


public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameMenu gameMenu;
	private GameToolBar gameToolBar;
	private GameEngine gameEngine = new GameEngineImpl();
	private Player currentPlayer = null;
	private DicePanel dicePanel;
	private SummaryPanel summaryPanel;
	private StatusBar statusBar;
	private boolean rollingStatus = false;
	
	public MainFrame(){		
		super("Dice Game");
		setLayout(new BorderLayout());
		
		//add gameEngineCallback
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(this));
				
		gameMenu = new GameMenu(gameEngine, this);
		gameToolBar = new GameToolBar(gameEngine, this);
        dicePanel = new DicePanel(gameEngine, this);
        summaryPanel = new SummaryPanel();
        statusBar = new StatusBar();
        
        setJMenuBar(gameMenu);
        this.getContentPane().add(gameToolBar, BorderLayout.NORTH);
        this.getContentPane().add(summaryPanel,BorderLayout.WEST);
        this.getContentPane().add(dicePanel,BorderLayout.CENTER);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
               
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,700);
		setMinimumSize(new Dimension(700, 300));
        setVisible(true);   
	}
	
	public GameToolBar getGameToolBar() {
		return this.gameToolBar;
	}
	
	public GameMenu getGameMenu() {
		return this.gameMenu;
	}
	
	public DicePanel getDicePanel() {
		return this.dicePanel;
	}
	
	public SummaryPanel getSummaryPanel() {
		return this.summaryPanel;
	}
	
	public StatusBar getStatusBar() {
		return this.statusBar;
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}
	
	public Player getCurrentPlayer() {
		if (this.currentPlayer == null) {
			return null;
		}
		else {
		return currentPlayer;
		}
	}
	
	public boolean isInteger(String str) { 
		try {  
			Integer.parseInt(str);  
			return true;
		} catch(NumberFormatException e){  
		    return false;  
		}  
	}
	
	public void rollHouseCheck() {
		boolean houseReady = true;
		for(Player player: gameEngine.getAllPlayers()) {
			if (player.getResult() == null) {
				houseReady = false;
			}
		}
		
		if (houseReady) {
			JOptionPane.showMessageDialog(new JFrame(), "The House is ready to roll. Click ok to continue!");

			Thread rollingHouseThread = new Thread() {
				public void run() {
					gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);

				}
			};
			rollingHouseThread.start();
		}
		
		new AutoPlayerRemover(this, gameEngine).checkBetAndRemove();
	}
	
	public void toggleRollingState() {
		this.rollingStatus = !this.rollingStatus;
	}
	
	public boolean getRollingState() {
		return this.rollingStatus;
	}
}

package mvc.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import mvc.controller.RemovePlayerButtonListener;
import mvc.model.BasicFrameFactory;

public class RemovePlayerWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idText;
	public RemovePlayerWindow(MainFrame mainFrame, GameEngine gameEngine) {
		JFrame window = new BasicFrameFactory("Remove player", 300, 300);
		JPanel panel = new JPanel();
		window.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Id");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		idText = new JTextField(20);
		idText.setBounds(100, 20, 165, 25);
		panel.add(idText);
		
		JButton button = new JButton("Remove");
		button.addActionListener(new RemovePlayerButtonListener(mainFrame, this, gameEngine));
		button.setBounds(10, 80, 100, 25);
		panel.add(button);
	}
	
	public String getRemovePlayerId() {
		return idText.getText();
	}
}

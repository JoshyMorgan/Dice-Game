package mvc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import mvc.controller.AddPlayerButtonListener;
import mvc.model.BasicFrameFactory;

public class AddPlayerWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idText;
	private JTextField nameText;
	private JTextField initialPoints;
	
	
	public AddPlayerWindow(MainFrame mainFrame, GameEngine gameEngine) {
		JFrame window = new BasicFrameFactory("Add new player", 300, 300);
		JPanel panel = new JPanel();
		window.add(panel);
		
		panel.setLayout(null);
		
		// Label Id and input field
		JLabel id = new JLabel("Id");
		id.setBounds(10, 20, 80, 25);
		panel.add(id);
		
		idText = new JTextField(20);
		idText.setBounds(100, 20, 165, 25);
		panel.add(idText);
		
		// Label Name and input field
		JLabel name = new JLabel("Name");
		name.setBounds(10, 60, 80, 25);
		panel.add(name);
		
		nameText = new JTextField(20);
		nameText.setBounds(100, 60, 165, 25);
		panel.add(nameText);
		
		// Label Points and input field
		JLabel points = new JLabel("Points");
		points.setBounds(10,100,80,25);
		panel.add(points);
		
		initialPoints = new JTextField(20);
		initialPoints.setBounds(100,100,165,26);
		panel.add(initialPoints);
		
		// Submit button
		JButton button = new JButton("Add");
		button.addActionListener(new AddPlayerButtonListener(mainFrame, this, gameEngine));
		button.setBounds(10, 140, 80, 25);
		panel.add(button);
		
	}
	
	public String getInputId() {
		return idText.getText();
	}
	
	public String getInputName() {
		return nameText.getText();
	}
	
	public String getInputPoints() {
		return initialPoints.getText();
	}
}

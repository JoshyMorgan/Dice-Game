package mvc.view;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SummaryPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JScrollPane jsp;
	
	public SummaryPanel(){
		textArea = new JTextArea(30,15);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("Welcome to Dice Game");
		jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(jsp);
	}
	
	public void addText(String text) {
		textArea.append("\n* " + text);
	}
	
	public void clearText() {
		textArea.selectAll();
		textArea.replaceSelection("");
		textArea.setText("Welcome to Dice Game");

	}
}

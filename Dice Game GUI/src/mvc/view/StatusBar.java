package mvc.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class StatusBar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel status;

	public StatusBar() {
		setLayout(new GridLayout(1,0));

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        status = new JLabel("Status: None", SwingConstants.LEFT);
        status.setBorder(border);
        add(status);
	}
	

    public void updateStatus(String text){
    	status.setText("Status:" + text);
    }

}

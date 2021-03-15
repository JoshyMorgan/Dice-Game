package mvc.model;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class BasicFrameFactory extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasicFrameFactory(String name, int width, int height) {
		super(name);
		setLayout(new BorderLayout());
		setSize(width,height);
        setVisible(true);	}
}

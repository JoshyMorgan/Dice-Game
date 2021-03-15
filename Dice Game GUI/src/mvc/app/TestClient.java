package mvc.app;

import javax.swing.SwingUtilities;

import mvc.view.MainFrame;
//import validate.Validator;

public class TestClient {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 @Override
			 public void run() {
//				 Validator.validate(true);
				 new MainFrame();
			 }
		 });
	}
}

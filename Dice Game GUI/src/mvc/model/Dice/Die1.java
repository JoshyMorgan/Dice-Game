package mvc.model.Dice;

import mvc.model.dots.MiddleDot;
import mvc.model.interfaces.DieFactory;

public class Die1 implements DieFactory {
	private int dieEdgeSize;
	private int dotRadius;
	private int leftDieY;
	private int leftDieX;
	private int[] middleDotLeft;


	@Override
	public int[][][] getDots(int panelWidth, int panelHeight) {
		// TODO Auto-generated method stub
		// check which size is larger and calculate position based on the smaller side ( panel width or height)
		if (panelHeight <= panelWidth/2) {
			// calculate dot stats for leftside die 1
			dieEdgeSize = panelHeight - 40;
			
			leftDieY = 20;
			leftDieX = (panelWidth/2 - dieEdgeSize) /2;
		}

		else {
			dieEdgeSize = panelWidth/2 - 40;
			
			// calculate dot stats for leftside die 1
			leftDieX = 20;
			leftDieY = (panelHeight - dieEdgeSize) /2;			
		}
		dotRadius = dieEdgeSize/12;
		middleDotLeft = new MiddleDot().getStats(leftDieX, leftDieY, dieEdgeSize);

		// calculate dot stats for rightside die 1
		int rightDieX = leftDieX + panelWidth/2;
		int rightDieY = leftDieY;
		
		int[] middleDotRight = new MiddleDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		
		int[][][] dotStats = {{{middleDotLeft[0], middleDotLeft[1], dotRadius}}, 
				{{middleDotRight[0], middleDotRight[1], dotRadius}}};
		return dotStats;
		
	}


}

package mvc.model.Dice;

import mvc.model.dots.DownLeftDot;
import mvc.model.dots.MiddleDot;
import mvc.model.dots.UpRightDot;
import mvc.model.interfaces.DieFactory;

public class Die3 implements DieFactory {
	private int dieEdgeSize;
	private int leftDieY;
	private int leftDieX;

	@Override
	public int[][][] getDots(int panelWidth, int panelHeight) {
		// TODO Auto-generated method stub
		if (panelHeight <= panelWidth/2) {
			// calculate dot stats for leftside die 3
			dieEdgeSize = panelHeight - 40;
			
			leftDieY = 20;
			leftDieX = (panelWidth/2 - dieEdgeSize) /2;
		}	

		else {
			// calculate dot stats for leftside die 3
			dieEdgeSize = panelWidth/2 - 40;
			
			leftDieX = 20;
			leftDieY = (panelHeight - dieEdgeSize) /2;
		}	
		int dotRadius = dieEdgeSize/12;
		
		int[] upRightDotLeft = new UpRightDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] middleDotLeft = new MiddleDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] downLeftDotLeft = new DownLeftDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		
		// calculate dot stats for rightside die 3
		int rightDieX = leftDieX + panelWidth/2;
		int rightDieY = leftDieY;
		
		int[] upRightDotRight = new UpRightDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] middleDotRight = new MiddleDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] downLeftDotRight = new DownLeftDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		
		int[][][] dotStats = {
				{{upRightDotLeft[0], upRightDotLeft[1], dotRadius},
					{middleDotLeft[0], middleDotLeft[1], dotRadius},
					{downLeftDotLeft[0], downLeftDotLeft[1], dotRadius}},
				{{upRightDotRight[0], upRightDotRight[1], dotRadius},
					{middleDotRight[0], middleDotRight[1], dotRadius},
					{downLeftDotRight[0], downLeftDotRight[1], dotRadius}}
				};
		
		return dotStats;
		
	}

}

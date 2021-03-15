package mvc.model.Dice;

import mvc.model.dots.DownLeftDot;
import mvc.model.dots.DownRightDot;
import mvc.model.dots.MidLeftDot;
import mvc.model.dots.MidRightDot;
import mvc.model.dots.UpLeftDot;
import mvc.model.dots.UpRightDot;
import mvc.model.interfaces.DieFactory;

public class Die6 implements DieFactory {
	private int dieEdgeSize;
	private int leftDieY;
	private int leftDieX;

	@Override
	public int[][][] getDots(int panelWidth, int panelHeight) {
		// TODO Auto-generated method stub
		if (panelHeight <= panelWidth/2) {
			// calculate dot stats for leftside die 6
			dieEdgeSize = panelHeight - 40;
			
			leftDieY = 20;
			leftDieX = (panelWidth/2 - dieEdgeSize) /2;
		}

		else {
			// calculate dot stats for leftside die 6
			dieEdgeSize = panelWidth/2 - 40;
						
			leftDieX = 20;
			leftDieY = (panelHeight - dieEdgeSize) /2;
		}
		int dotRadius = dieEdgeSize/12;
		
		int[] upLeftDotLeft = new UpLeftDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] upRightDotLeft = new UpRightDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] midLeftDotLeft = new MidLeftDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] midRightDotLeft = new MidRightDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] downLeftDotLeft = new DownLeftDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		int[] downRightDotLeft = new DownRightDot().getStats(leftDieX, leftDieY, dieEdgeSize);
		
		// calculate dot stats for rightside die 6
		int rightDieX = leftDieX + panelWidth/2;
		int rightDieY = leftDieY;
		
		int[] upLeftDotRight = new UpLeftDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] upRightDotRight = new UpRightDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] midLeftDotRight = new MidLeftDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] midRightDotRight = new MidRightDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] downLeftDotRight = new DownLeftDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		int[] downRightDotRight = new DownRightDot().getStats(rightDieX, rightDieY, dieEdgeSize);
		
		int[][][] dotStats = {
				{{upLeftDotLeft[0], upLeftDotLeft[1], dotRadius},
					{upRightDotLeft[0], upRightDotLeft[1], dotRadius},
					{midLeftDotLeft[0], midLeftDotLeft[1], dotRadius},
					{midRightDotLeft[0], midRightDotLeft[1], dotRadius},
					{downLeftDotLeft[0], downLeftDotLeft[1], dotRadius},
					{downRightDotLeft[0], downRightDotLeft[1], dotRadius}},
				{{upLeftDotRight[0], upLeftDotRight[1], dotRadius},
						{upRightDotRight[0], upRightDotRight[1], dotRadius},
						{midLeftDotRight[0], midLeftDotRight[1], dotRadius},
						{midRightDotRight[0], midRightDotRight[1], dotRadius},
						{downLeftDotRight[0], downLeftDotRight[1], dotRadius},
						{downRightDotRight[0], downRightDotRight[1], dotRadius}}
				};
		return dotStats;
	
	}

}
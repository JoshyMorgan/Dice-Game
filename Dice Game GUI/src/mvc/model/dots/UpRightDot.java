package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class UpRightDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int upRightDotX = dieX + dieEdgeSize*3/4;
		int upLRightDotY = dieY + dieEdgeSize/4;
		int[] upRightDotStats = {upRightDotX, upLRightDotY};
		return upRightDotStats;	
	}
}

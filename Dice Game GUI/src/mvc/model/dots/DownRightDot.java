package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class DownRightDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int downRightDotX = dieX + dieEdgeSize*3/4;
		int downRightDotY = dieY + dieEdgeSize*3/4;
		int[] downRightDotStats = {downRightDotX, downRightDotY};
		return downRightDotStats;
	}

}

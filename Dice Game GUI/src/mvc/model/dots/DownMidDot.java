package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class DownMidDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int downMidDotX = dieX + dieEdgeSize/2;
		int downMidDotY = dieY + dieEdgeSize*3/4;
		int[] downMidDotStats = {downMidDotX, downMidDotY};
		return downMidDotStats;
	}

}

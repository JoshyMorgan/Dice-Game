package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class DownLeftDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int downLeftDotX = dieX + dieEdgeSize/4;
		int downLeftDotY = dieY + dieEdgeSize*3/4;
		int[] downLeftDotStats = {downLeftDotX, downLeftDotY};
		return downLeftDotStats;
	}

}

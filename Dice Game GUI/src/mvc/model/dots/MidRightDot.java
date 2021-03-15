package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class MidRightDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int midRightDotX = dieX + dieEdgeSize*3/4;
		int midRightDotY = dieY + dieEdgeSize/2;
		int[] midRightDotStats = {midRightDotX, midRightDotY};
		return midRightDotStats;
	}

}

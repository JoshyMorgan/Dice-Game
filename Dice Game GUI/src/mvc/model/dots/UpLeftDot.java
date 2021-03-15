package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class UpLeftDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int upLeftDotX = dieX + dieEdgeSize/4;
		int upLeftDotY = dieY + dieEdgeSize/4;
		int[] upLeftDotStats = {upLeftDotX, upLeftDotY};
		return upLeftDotStats;
	}

}

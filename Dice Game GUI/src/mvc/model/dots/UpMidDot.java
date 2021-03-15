package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class UpMidDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int upMidDotX = dieX + dieEdgeSize/2;
		int upLMidDotY = dieY + dieEdgeSize/4;
		int[] upMidDotStats = {upMidDotX, upLMidDotY};
		return upMidDotStats;
	}

}

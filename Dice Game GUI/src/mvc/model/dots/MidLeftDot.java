package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class MidLeftDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int midLeftDotX = dieX + dieEdgeSize/4;
		int midLeftDotY = dieY + dieEdgeSize/2;
		int[] midLeftDotStats = {midLeftDotX, midLeftDotY};
		return midLeftDotStats;		
	}
}

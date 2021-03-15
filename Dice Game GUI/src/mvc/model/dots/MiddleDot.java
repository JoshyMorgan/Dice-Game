package mvc.model.dots;

import mvc.model.interfaces.Dots;

public class MiddleDot implements Dots {

	@Override
	public int[] getStats(int dieX, int dieY, int dieEdgeSize) {
		// TODO Auto-generated method stub
		int middleDotX = dieX + dieEdgeSize/2;
		int middleDotY = dieY + dieEdgeSize/2;
		int[] middleDotStats = {middleDotX, middleDotY};
		return middleDotStats;
	}
}

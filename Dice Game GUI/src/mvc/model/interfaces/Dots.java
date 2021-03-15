package mvc.model.interfaces;

public interface Dots {
	/**
    * @param dieX - the X location of the die rectangle
    * @param dieY - the Y location of the die rectangle
    * @param dieEdgeSize - The width or height of the die
    * @return position of one of a die
    *           
    */
	public int[] getStats(int dieX, int dieY, int dieEdgeSize);

}

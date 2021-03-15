package mvc.model.interfaces;

public interface DieFactory {
	
	/**
    * @param panelHeight - The height of the panel containing the dice
    * @param panelWidth - The width of the panel containing the dice
    * @param dieEdgeSize - The width or height of the dice
    * @return 2D array of position of the dots of the dice
    *           
    */
	
	// First dimension consist of 0 and 1 element represent left and right
	// Second dimension is for how many dots in a dice
	// Third dimension is for x, y and radius of the dots
	public abstract int[][][] getDots(int panelWidth, int panelHeight);

}

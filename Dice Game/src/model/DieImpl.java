package model;

import model.interfaces.Die;

public class DieImpl implements Die {
    public int number;
    public int value;
    public int numFaces;

    public DieImpl(int number, int value, int numFaces) throws IllegalArgumentException{
        this.number = number;
        this.value = value;
        this.numFaces = numFaces;
        if (number < 1 || number > 2 || value < 1 || value > numFaces || numFaces < 1){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getNumber() {
        return number;
    }
    
    //return random value and set random value
    @Override
    public int getValue() {
    	return value;
    }

    @Override
    public int getNumFaces() {
        return numFaces;
    }
    
    @Override
    public boolean equals(Die die) {
        return die.getNumber() == this.getNumber() && die.getValue() == this.getValue();
    }
    
    public int hashCode() {
        return Integer.hashCode(value) + Integer.hashCode(numFaces);
    }

}

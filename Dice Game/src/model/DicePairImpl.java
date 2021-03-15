package model;
import java.util.*;

import model.interfaces.DicePair;
import model.interfaces.Die;

public class DicePairImpl implements DicePair{

    private DieImpl dieOne;
    private DieImpl dieTwo;

    public DicePairImpl(){
        Random rand1 = new Random();
        int num1 = rand1.nextInt(6)+1;
        dieOne = new DieImpl(1,num1,6);
        int num2 = rand1.nextInt(6)+1;
        dieTwo = new DieImpl(2, num2, 6);
    }

    public int getTotal(){
        return (dieOne.getValue() + dieTwo.getValue());
    }

    @Override
    public boolean equals(DicePair dicePair) {
        if (dicePair.getDie1().equals(this.dieOne)){
            return dicePair.getDie2().equals(this.dieOne);
        }
        return false;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dieOne == null) ? 0 : dieOne.hashCode());
		result = prime * result + ((dieTwo == null) ? 0 : dieTwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DicePairImpl other = (DicePairImpl) obj;
		if (dieOne == null) {
			if (other.dieOne != null)
				return false;
		} else if (!dieOne.equals(other.dieOne))
			return false;
		if (dieTwo == null) {
			if (other.dieTwo != null)
				return false;
		} else if (!dieTwo.equals(other.dieTwo))
			return false;
		return true;
	}

    public Die getDie1(){
        return this.dieOne;
    }

    public Die getDie2(){
        return this.dieTwo;
    }

    @Override
    public String toString() {
        return String.format("Dice %s: %s, Dice %s: %s.. Total: %s",
                this.getDie1().getNumber(), this.getDie1().getValue(),
                this.getDie2().getNumber(), this.getDie2().getValue(), this.getTotal());
    }

    @Override
    public int compareTo(DicePair dicePair) {
        return Integer.compare(this.getTotal(), dicePair.getTotal());
    }
}

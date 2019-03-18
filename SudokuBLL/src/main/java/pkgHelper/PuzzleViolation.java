package pkgHelper;

import pkgEnum.ePuzzleViolation;

public class PuzzleViolation {
	private ePuzzleViolation ePuzzleViolation;
	private int iValue;
	
	//Constructor for PuzzleViolation
	public PuzzleViolation (pkgEnum.ePuzzleViolation ePuzzleViolation,int iValue) {
		super();
		this.ePuzzleViolation = ePuzzleViolation;
		this.iValue = iValue;
		
	}
	//getter for ePuzzleViolation
	public ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}
	//getter for iValue
	public int getiValue() {
		return iValue;
	}
}


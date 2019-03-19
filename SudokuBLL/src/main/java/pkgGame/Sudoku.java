
package pkgGame;

import java.util.Arrays;
import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;
import pkgHelper.PuzzleViolation;

public class Sudoku extends LatinSquare {
	 
	private int iSize; //length of the sudoku puzzle
	
	private int iSqrtSize; // square root of iSize
	
	public Sudoku(int iSize) throws java.lang.Exception {
		//completed
		super();
		this.iSize=iSize;
		
		
			if (Math.sqrt(iSize) == (int) Math.sqrt(iSize)) {
				this.iSqrtSize = (int) Math.sqrt(iSize);
			}
			
			else {
				throw new Exception("Not perfect square");
			}
		}
			
		
		//if //check if iSqrtSize is an int. Throw exception if it isn't. 
		//Finally block will run if no matter if there's is an exception or not
	 

	public Sudoku(int[][] puzzle) throws Exception {  
		super(puzzle);
		//completed
		
			if (Math.sqrt(puzzle.length) == (int)Math.sqrt(puzzle.length)){
				
				this.iSize = puzzle.length;
				this.iSqrtSize = (int)Math.sqrt(puzzle.length);
			}
		
			else {
				throw new Exception("Not an acceptable puzzle.");
			}
		}
			
			
		
		
	 
	 
	public int [] getRegion(int i) throws java.lang.Exception{
		int numRegions = (iSize - 1);
		int[] theRegion = new int[iSize];
		//int size = iSize;
		int regionInd = 0;
		int [][] copyPuzzle=this.getPuzzle();
		if (i < 0 || i > numRegions) {
			throw new Exception("Out of bounds exception");
		}
		
		
		for(int rowNum = (i/iSqrtSize)*iSqrtSize;rowNum < ((i/iSqrtSize)*iSqrtSize)+iSqrtSize;rowNum++) {
			for(int colNum = (i/iSqrtSize)%iSqrtSize;colNum < ((i/iSqrtSize)%iSqrtSize)+iSqrtSize;colNum++) {
				
				theRegion[regionInd] = copyPuzzle[rowNum][colNum];
				
				regionInd += 1;
			}
		}
		return theRegion;
	}
	 
	public int [] getRegion(int Col, int Row) throws java.lang.Exception
	{
		//int [] aCol = getColumn(Col); //Get the column and row the parameters represent.
		//int [] aRow = getRow(Row);
		
		int r = (Col/iSqrtSize)+((Row/iSqrtSize)+iSqrtSize);
		if (r < 0 || r > (iSize -1)) { //I think we need to remove the  - 1. 
			//In the test case, r is being set to 4 which is out of bounds according to the 'if' statement above.
			throw new Exception("Out of bounds exception caught.");
		}
		else {
		return getRegion(r);
		}
	}
		
		
		
		
	
	
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}

	protected boolean isSudoku() {
		if(isPartialSudoku() == true) {
			return true;
		}
		else {
		return false;
		}
	}
	
	protected boolean isPartialSudoku() throws Exception{
		try {
			super.setbIgnoreZeros(true);
			this.hasDuplicates();
			
		}
		catch(Exception e) {
			return false;
		}
		for(int r = 0; r <(iSize - 1); r++) {
		if(doesElementExist(getRow(r), 0) == false) {
			return false;
		}
		}
		super.setbIgnoreZero(true);
		
		int[] firstRow = getRow(0);
		int trueCounter = 0;
		
		for(int a = 0; a < iSize; a++) {
			for(int b = 0; b < (iSize-1); b++) {
				int [] reg = getRegion(b);
				for(int c = 0; c < (iSize - 1); c++) {
					if(firstRow[a] == reg[c]) {
							trueCounter += 1;
					}
				}
				
			}
			
		}
		if(trueCounter == iSize) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	protected boolean isValueValid(int Val, int Col, int Row) {
		int [][] copyPuzzle=this.getPuzzle();
		copyPuzzle[Row][Col]=Val;
		pkgHelper.LatinSquare c=new LatinSquare(copyPuzzle);
		if (c.hasDuplicates(c.getColumn(Col))==false && c.hasDuplicates(c.getRow(Row))==false) {
			return true;
		}
		else {
		return false; 
		} 
	}
	
	@Override
	protected boolean hasDuplicates() throws Exception {
	
		if(super.hasDuplicates()==true) {
			return true;
		}
		
		for (int k = 0; k < getPuzzle().length; k++) {
			
			if (hasDuplicates(getRegion(k))) {
				super.addPV(new PuzzleViolation(ePuzzleViolation.DupRegion,k));
			return true; 
			}
		}
		return false;
		
		}
	}
		
	
	
	
	
	
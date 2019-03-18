
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
		int numRegions = (iSqrtSize - 1);
		int[] theRegion = new int[iSize];
		//int size = iSize;
		int regionInd = 0;
		int [][] copyPuzzle=this.getPuzzle();
		if (i < 0 || i > numRegions) {
			throw new Exception("Out of bounds.");
		}
		
		
		for(int rowNum = (i/iSqrtSize)*iSqrtSize;rowNum < ((i/iSqrtSize)*iSqrtSize)+iSqrtSize;rowNum++) {
			for(int colNum = (i/iSqrtSize)%iSqrtSize;colNum < ((i/iSqrtSize)%iSqrtSize)+iSqrtSize;colNum++) {
				
				theRegion[regionInd++] = copyPuzzle[rowNum][colNum];
			}
		}
		return theRegion;
	}
	 
	public int [] getRegion(int Col, int Row) throws java.lang.Exception
	{
		//int [] aCol = getColumn(Col); //Get the column and row the parameters represent.
		//int [] aRow = getRow(Row);
		
		int r = (Col/iSqrtSize)+((Row/iSqrtSize)+iSqrtSize);
		if (r < 0 || r > (iSqrtSize - 1)) {
			throw new Exception("Out of bounds.");
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
		//Must be latin square and each region must be tested.
	}
	
	protected boolean isPartialSudoku() {
		// Will return true it it's Sudoku and there's a zero value
		return false;
	}
	
	protected boolean isValueValid(int Val, int Col, int Row) {
		//int [] Region = getRegion(Col,Row);
		
		
		
		//if(hasDuplicates(colList))
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
	
		super.hasDuplicates();
		
		for (int k = 0; k < getPuzzle().length; k++) {
			if (hasDuplicates(getRegion(k))) {
				super.addPV(new PuzzleViolation(ePuzzleViolation.DupRegion,k));
			return true; 
			}
		}
		return false;
		
		}
	}
		
	
	
	
	
	
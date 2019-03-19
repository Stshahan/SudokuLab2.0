package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	public SudokuTest() {
		
	}
@Test
public void TestRegionNbr() throws Exception {
	//Sudoku S = new Sudoku();
	int [][] Puz1 ={{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
	Sudoku samplePuzzle = new Sudoku(Puz1);
	
	int[] regionNbr = {3,4,4,1};
	
	//Shaun can you look at this?????
	
	System.out.println(samplePuzzle.getRegion(2));
	System.out.println(samplePuzzle.getRegion(1,2));
	//assertEquals(regionNbr, samplePuzzle.getRegion(1,2));
	
}
}

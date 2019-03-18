package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	public SudokuTest() {
		
	}
@Test
public void TestRegionNbr() {
	//Sudoku S = new Sudoku();
	Sudoku samplePuzzle = new Sudoku({{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}});
	
	int regionNbr = 1;
	
	assertEquals(samplePuzzle.getRegion(regionNbr), samplePuzzle.getRegion(1,2));
	
}
}

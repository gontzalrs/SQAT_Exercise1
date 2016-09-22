import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_GetScoreOfFrame_Returns_9() {
		//Arrange
		Frame frame = new Frame(5, 4);
		//Act
		int result = frame.score();
		//Assert
		assertEquals(9, result);
	}
	
	@Test
	public void test_CheckIfIsStrike_Returns_true() {
		//Arrange
		Frame frame = new Frame(10, 0);
		//Act
		boolean result = frame.isStrike();
		//Assert
		assertEquals(true, result);
	}
	
	@Test
	public void test_CheckIfIsStrike_Returns_false() {
		//Arrange
		Frame frame = new Frame(0, 10);
		//Act
		boolean result = frame.isStrike();
		//Assert
		assertEquals(false, result);
	}
	
	@Test
	public void test_CheckIfIsSpare_Returns_true() {
		//Arrange
		Frame frame = new Frame(5, 5);
		//Act
		boolean result = frame.isSpare();
		//Assert
		assertEquals(true, result);
	}
	
	@Test
	public void test_CheckIfIsSpare_Returns_false() {
		//Arrange
		Frame frame = new Frame(9, 0);
		//Act
		boolean result = frame.isSpare();
		//Assert
		assertEquals(false, result);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

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
	public void test_VerifyAddFrameToBowlingGame_Returns_3(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(0, 0);
		//Act
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		//Assert
		assertEquals(3, game.getFrames().size());
	}
	
	@Test
	public void test_VerifySetBonusAfterStrike_Return_8(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(10, 0);
		//Act
		for(int i = 0; i < 10; i++)  //Adds 10 spare frames
			game.addFrame(frame);
		game.setBonus(3, 5);
		//Assert
		assertEquals(8, game.getBonus().score());
	}
	
	@Test
	public void test_VerifySetBonusAfterSpare_Return_8(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5, 5);
		//Act
		for(int i = 0; i < 10; i++)  //Adds 10 spare frames
			game.addFrame(frame);
		game.setBonus(8, 0);
		//Assert
		assertEquals(8, game.getBonus().score());
	}
	
	@Test
	public void test_VerifyScore_NoSpareOrStrike_Return_80(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(4, 4);
		//Act
		for(int i = 0; i < 10; i++)  //Adds 10 equal frames, no spare, no strike
			game.addFrame(frame);
		game.setBonus(8, 0);  //Tries to add a bonus even when it should not
		//Assert
		assertEquals(80, game.score());
	}
	
	@Test
	public void test_VerifyScore_SpareOnLastThrow_Return_114(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(4, 4);
		Frame frameStrike = new Frame(10, 0);
		Frame frameSpare = new Frame(0, 10);
		//Act
		game.addFrame(frame);		//0 + 8 = 8
		game.addFrame(frameSpare);	//10 + 8 = 18
		game.addFrame(frame);		//8 + 18 + 4(spare) = 30
		game.addFrame(frame);		//8 + 30 = 38
		game.addFrame(frameStrike); //10 + 38 = 48
		game.addFrame(frame);		//8 + 48 + 8(strike) = 64
		game.addFrame(frame);		//8 + 64 = 72
		game.addFrame(frame);		//8 + 72 = 80
		game.addFrame(frame);		//8 + 80 = 88
		game.addFrame(frameSpare);	//10 + 88 = 98
		game.setBonus(8, 2);		//8 + 98 + 8(spare) = 114
		//Assert
		assertEquals(114, game.score());
	}
	
	@Test
	public void test_VerifyScore_StrikeOnLastThrow_Return_118(){
		//Arrange
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(4, 4);
		Frame frameStrike = new Frame(10, 0);
		Frame frameSpare = new Frame(0, 10);
		//Act
		game.addFrame(frame);		//0 + 8 = 8
		game.addFrame(frameSpare);	//10 + 8 = 18
		game.addFrame(frame);		//8 + 18 + 4(spare) = 30
		game.addFrame(frame);		//8 + 30 = 38
		game.addFrame(frameStrike); //10 + 38 = 48
		game.addFrame(frame);		//8 + 48 + 8(strike) = 64
		game.addFrame(frame);		//8 + 64 = 72
		game.addFrame(frame);		//8 + 72 = 80
		game.addFrame(frame);		//8 + 80 = 88
		game.addFrame(frameStrike);	//10 + 88 = 98
		game.setBonus(8, 2);		//10 + 98 + 10(strike) = 118
		//Assert
		assertEquals(118, game.score());
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

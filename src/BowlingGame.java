import java.util.ArrayList;
import java.util.List;

//Finish time: 4:16
//ID: 136

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public List<Frame> getFrames() {
		return frames;
	}

	public Frame getBonus() {
		return bonus;
	}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		frames.add(frame);
	}

	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		if(frames.size()>=10 && frames.get(frames.size()-1).isStrike()){
			bonus = new Frame(firstThrow, secondThrow);
		} 
		else if(frames.size()>=10 && frames.get(frames.size()-1).isSpare()){
			bonus = new Frame(firstThrow, 0);
		}
	}
	
	// Returns the game score
	public int score(){
		int score = 0;
		Frame prevFrame = new Frame(0, 0);
		for(Frame f : frames){
			if(prevFrame.isSpare()){
				score = score + f.score() + f.getFirstThrow();
			}
			else if(prevFrame.isStrike()){
				score = score + f.score() + f.score();
			}
			else{
				score = score + f.score();
			}
			prevFrame = f;
		}
		if(frames.size()>=10 && frames.get(frames.size()-1).score()==10){
			score = score + bonus.score()*2;
		}
		return score;
	}
}

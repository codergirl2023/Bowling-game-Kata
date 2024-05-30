package com.bowling;

public class Game {
	int[] rolls = new int[21];
	int rollIdx = 0;
	
	public void roll(int pins) {
		rolls[rollIdx++] = pins;
	}
	
	public int score() {
		int score = 0;
		int frameIdx = 0;
		
		for(int frame = 1; frame <= 10; frame++) {
			if(isSpare(frameIdx)) {
				score += 10 + spareBonus(frameIdx);
				frameIdx += 2;
			} else if(isStrike(frameIdx)) {
				score += 10 + strikeBonus(frameIdx);
				frameIdx++;
			} else {
				score += sumOfPinsInFrame(frameIdx);
				frameIdx += 2;
			}
			System.out.println(frame + " " + frameIdx);

		}
		return score;
	}
	
	private boolean isSpare(int idx) {
		return rolls[idx] + rolls[idx + 1] == 10;
	}
	
	private int spareBonus(int idx) {
		return rolls[idx + 2];
	}
	
	private boolean isStrike(int idx) {
		return rolls[idx] == 10;
	}
	
	private int strikeBonus(int idx) {
		return rolls[idx + 1] + rolls[idx + 2];
	}
	
	private int sumOfPinsInFrame(int idx) {
		return rolls[idx] + rolls[idx + 1];
	}
}

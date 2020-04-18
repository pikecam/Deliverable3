package model;

public class PlayerHand extends CardHand{
	private int chipsTotal;
	private int chipsBet;
	private boolean isPlaying;
	private boolean canPlay;
	private boolean betLocked;
	
	public boolean isBetLocked() {
		return betLocked;
	}

	public void setBetLocked(boolean betLocked) {
		this.betLocked = betLocked;
	}

	public PlayerHand() {
		super();
	}

	public int getChipsTotal() {
		return chipsTotal;
	}

	public void setChipsTotal(int chipsTotal) {
		this.chipsTotal = chipsTotal;
	}

	public int getChipsBet() {
		return chipsBet;
	}

	public void setChipsBet(int chipsBet) {
		this.chipsBet = chipsBet;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public boolean isCanPlay() {
		return canPlay;
	}

	public void setCanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}
}

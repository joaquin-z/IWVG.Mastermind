package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	protected int numPlayers() {
		return game.getNumPlayers();
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}

	public void putCode(String code) {
		assert code != null;
		game.putCode(code);	
	}

	public boolean isVictory() {
		return game.isVictory();
	}	
	
	public boolean isOver() {
        return game.isOver();
    }
	
	public int getAttempt() {
        return game.getAttempt();
    }   
	
	public void nextAttempt() {
        game.nextAttempt();
    }   
	
	public void resetAttempts() {
        game.resetAttempts();
    }
	
	public int getKilled() {
        return game.getKilled();
    }   
	
	public int getWounded() {
        return game.getWounded();
    }   
	
	public void resetScore() {
        game.resetScore();
    }
    
    public void generateCode() {
        game.generateCode();
    }
	
}

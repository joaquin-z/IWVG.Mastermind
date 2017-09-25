package mastermind.models;

public class Game {

	private State state;
	
	private Turn turn;
	
	private Code code;
	
	private Score score;
	
	private String attempt;
	
	private static final int NUM_PLAYERS = 1;
	
	public Game() {
		state = State.INITIAL;
		turn = new Turn();
		code = new Code();
		score = new Score();
		code.generateCode();
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}

	public void nextAttempt() {
		turn.nextAttempt();
	}
	
	public int getAttempt() {
        return turn.getTurn();
    }
	
	public int getKilled() {
        return score.getKilled();
    }
	
	public void resetScore() {
        score.resetScore();
    }
	
	public void resetAttempts() {
        turn.setTurn(1);;
    }
	
	public void generateCode() {
        code.generateCode();
    }
	
	public int getWounded() {
        return score.getWounded();
    }
	
	public int getNumPlayers() {
		return NUM_PLAYERS;
	}
	
	public void putCode(String attempt) {
	    String code = "";
	    for (int i = 0; i < attempt.length(); i++) {
	        code += char2int(attempt.substring(i,i+1).toUpperCase());
        }
	    this.attempt = code;
    }
	
	public String char2int(String value) {
	    String code = "";
	    switch (value) {
        case "A":
            code = "0";
            break;
        case "R":
            code = "1";
            break;
        case "V":
            code = "2";
            break;
        case "Z":
            code = "3";
            break;
        case "B":
            code = "4";
            break;
        case "N":
            code = "5";
            break;
        default:
            break;
        }
	    return code;
	}
	
	public boolean isVictory() {
	    this.score.saveScore(attempt, this.code.getCode());
	    return score.getKilled() == code.getCodeLength();
    }
	
	public boolean isOver() {
	    return turn.isOver();
	}    
	
}

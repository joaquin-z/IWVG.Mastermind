package mastermind.models;

class Turn {

	private int value = 1;
	
	private int max_value = 10;
	
	public Turn() {
		value = 1;
	}
    
    public void nextAttempt() {
    	value = value + 1;
    }
    
    public boolean isOver() {
        return value == max_value;
    }
    
    public int getTurn() {
        return value;
    }
    
    public void setTurn(int turn) {
        this.value = turn;
    }
    
    public int getMaxAttempts() {
        return max_value;
    }
	
}

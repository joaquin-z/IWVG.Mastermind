package mastermind.utils;

public class ClosedInterval {

	private int min;

	private int max;
	
	private String characters;

	public ClosedInterval(int min, int max) {
		assert min <= max;
		this.min = min;
		this.max = max;
	}
	
	public ClosedInterval(String characters) {
        this.characters = characters;
    }

	public boolean includes(int value) {
		return min <= value && value <= max;
	}
	
	public boolean includes(String value) {
        if (value.matches("["+characters+"]")) {
            return true;
        } else {
            return false;
        }
    }

	int getMin() {
		return min;
	}

	int getMax() {
		return max;
	}
	
	String getCharacters() {
        return characters;
    }

}

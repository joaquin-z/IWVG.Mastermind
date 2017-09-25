package mastermind.models;

import java.util.HashMap;
import java.util.HashSet;

public class Score {
            
    private int killed = 0;
    
    private int wounded = 0;
    
    private boolean perfect = true;
    
    public void saveScore(String attempt, HashMap<Integer, HashSet<Integer>> code) {        
        HashMap<Integer, Integer> matches = new HashMap<>();
        for (int i = 0; i < attempt.length(); i++) {
            char attemptValue = attempt.charAt(i);
            int number = Character.getNumericValue(attemptValue);
            int numberMatchCount = matches.getOrDefault(number, 0);
            int actualNumberCount = code.getOrDefault(number, new HashSet<>()).size();
            if (actualNumberCount > 0 && numberMatchCount == actualNumberCount) {
                perfect = false;
            }
            if (code.containsKey(number)) {
                HashSet<Integer> indices = code.get(number);
                if (indices.contains(i)) {
                    killed = killed + 1;
                } else {
                    wounded = wounded + 1;
                }
            }
        }
    }    
    
    public int getKilled() {
        return killed;
    }
    
    public void resetScore() {
        this.killed=0;
        this.wounded=0;
    }

    public int getWounded() {
        return wounded;
    }

    public boolean isPerfect() {
        return perfect;
    }
    
    
}

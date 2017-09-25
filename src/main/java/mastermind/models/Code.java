package mastermind.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Code {
    
    private boolean duplicated_allowed = false;
    private int code_length = 4;
    private int min_value = Color.values()[0].ordinal();
    private int max_value = Color.values()[5].ordinal();
    private HashMap<Integer, HashSet<Integer>> code;
    
    public void generateCode() {
        code = new HashMap<>();
        for (int i = 0; i < code_length; i++) {
            int number = ThreadLocalRandom.current().nextInt(min_value, max_value + 1);
            if (!duplicated_allowed) {
                while (code.containsKey(number)) {
                    number = ThreadLocalRandom.current().nextInt(min_value, max_value + 1);
                }
            }
            HashSet<Integer> indices = code.getOrDefault(number, new HashSet<>());
            indices.add(i);
            code.put(number, indices);
        }
    }
    
    public HashMap<Integer, HashSet<Integer>> getCode() {
        return code;
    }
    
    public int getCodeLength() {
        return code_length;
    }    
    
}

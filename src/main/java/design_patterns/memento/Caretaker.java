package design_patterns.memento;

import java.util.*;

public class Caretaker
{
    Stack<List<String>> states = new Stack<>();

    public void saveState(String[] board) {
        List<String> savedState = new ArrayList<>(Arrays.asList(board));
        states.push(savedState);
    }

    public Optional<String[]> getLastState() {
        if (states.size() > 1) {
            states.pop().toArray(new String[0]);
            return Optional.of(states.peek().toArray(new String[0]));
        } else {
            return Optional.empty();
        }
    }
}

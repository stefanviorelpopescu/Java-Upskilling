package design_patterns.memento;

import java.util.*;

public class Caretaker
{
    Stack<List<String>> states = new Stack<>();

    public void saveState(String[] board) {
        states.push(new ArrayList<>(Arrays.asList(board)));
    }

    public Optional<String[]> getLastState() {
        if (states.size() > 0) {
            return Optional.of(states.pop().toArray(new String[0]));
        } else {
            return Optional.empty();
        }
    }
}

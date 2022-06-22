package functional._4_list_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfWordsExample {
    public static void main(String[] args) {
        List<String> words =  new ArrayList<>(Arrays.asList("hello", "java", "yay", "cat", "cat"));
        String longWord = words.stream()
                .filter(w -> w.length() < 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .reduce("", String::concat); // terminal operation
        System.out.println(longWord);
    }
}

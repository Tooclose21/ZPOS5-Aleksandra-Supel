package lista6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Sentence {
    private final String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Map<String, Integer> getNumberOfWords() {
        String[] words = sentence.replaceAll("[.,!?]+", " ").split("[ \n]+");
        Map<String, Integer> result = new HashMap<>();
        Arrays.stream(words)
                .distinct()
                .forEach(key -> result.put(key, (int) Arrays.stream(words)
                        .filter(value -> value.equals(key))
                        .count()
                ));
        return result;
    }

    public Map<Character, Integer> getNumberOfCharacters() {
        IntStream chars = sentence.replaceAll("\n", "").chars();
        Map<Character, Integer> result = new HashMap<>();
        sentence.replaceAll("\n", "").chars()
                .distinct()
                .forEach(key -> result.put((char) key, (int) sentence.replaceAll("\n", "").chars()
                        .filter(value -> value == key)
                        .count()
                ));
        return result;
    }

    public String getSentence() {
        return sentence;
    }
}

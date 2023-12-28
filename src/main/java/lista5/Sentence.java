package lista5;

import java.util.HashMap;
import java.util.Map;

public class Sentence {
    private final String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Map<String, Integer> getNumberOfWords() {
        String[] words = sentence.replaceAll("[.,!?]+", " ").split("[ \n]+");
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
                continue;
            }
            result.put(word, 1);
        }
        return result;
    }

    public Map<Character, Integer> getNumberOfCharacters() {
        char[] chars = sentence.replaceAll("\n", "").toCharArray();
        Map<Character, Integer> result = new HashMap<>();
        for (char c : chars) {
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
                continue;
            }
            result.put(c, 1);
        }
        return result;
    }

    public String getSentence() {
        return sentence;
    }
}

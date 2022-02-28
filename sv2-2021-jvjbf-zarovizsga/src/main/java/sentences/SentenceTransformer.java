package sentences;

import java.util.List;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        validateSentence(sentence);
        String[] parts = sentence.split(" ");
        return parts.length >= 5 ? parts[0] + " ... " + parts[parts.length - 1] : sentence;
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalStateException("Sentence must be present!");
        }
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!List.of('.', '!', '?').contains(sentence.charAt(sentence.length() - 1))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}

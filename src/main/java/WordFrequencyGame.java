import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    private static final String LINE_BREAKS = "\n";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final String SPACE_STRING = " ";

    public String getResult(String sentence) {
            try {
                ArrayList<WordInfo> wordInfos = getWordFrequency(sentence);
                wordInfos.sort((firstWordInfo, secondWordInfo) -> secondWordInfo.getWordCount() - firstWordInfo.getWordCount());
                return generateWordFrequencyGame(wordInfos);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
    }

    private ArrayList<WordInfo> getWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        ArrayList<WordInfo> wordInfos = new ArrayList<>();
        for (String uniqueWord: new HashSet<>(words)) {
           int count = (int) words.stream().filter(word -> word.equals(uniqueWord)).count();
           wordInfos.add(new WordInfo(uniqueWord,count));
        }
        return wordInfos;
    }

    private String generateWordFrequencyGame(List<WordInfo> wordInfos) {
        StringJoiner joiner = new StringJoiner(LINE_BREAKS);
        for (WordInfo word : wordInfos) {
            String s = word.getValue() + SPACE_STRING +word.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}

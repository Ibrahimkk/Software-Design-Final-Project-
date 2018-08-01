package sdfinal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SDFinal {

    public int numberOfVowelsAndConsonants(String answer, String name) {
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        int consCount = 0;
        int points;

        for(int i = 0; i < answer.length(); i ++) {
            char currentChar = answer.charAt(i);
            if (vowels.indexOf(currentChar) >= 0 && name.indexOf(currentChar) >= 0) {
                if (name.regionMatches(0, answer, 0, answer.length())) {
                    vowelCount++;
                }
            } else if (Character.isLetter(currentChar) && name.indexOf(currentChar) >= 0) {
                if (name.regionMatches(0, answer, 0, answer.length())) {
                    consCount = consCount + 2;
                }
            }
        }
        points = consCount + vowelCount;
        return points;
    }

    public String shuffleList(List<String> names) {
        Random random = new Random();
        String name = names.get(random.nextInt(names.size()));
        return name;
    }

    public String shuffleWord(String word) {
            List<Character> list = new ArrayList<>();
            for(char c :  word.toCharArray()) {
                list.add(c);
            }
            Collections.shuffle(list);

            StringBuilder sb = new StringBuilder();
            for(char c : list)
                sb.append(c);

            word = sb.toString();
            return word;
        }
}

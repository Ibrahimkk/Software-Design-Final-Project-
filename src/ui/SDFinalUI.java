package sdfinal.ui;

import sdfinal.SDFinal;
import sdfinal.SpellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SDFinalUI {
    public static void main (String[] args) {
        Boolean correct;
        Boolean finished = false;
        int points;
        String shuffledName;
        String name;
        String answer;
        Scanner scanner = new Scanner(System.in);
        SDFinal sdFinal = new SDFinal();
        SpellChecker spellChecker = new SpellChecker();
        Scanner textFile;
        List<String> names = new ArrayList<>();

        try {
            textFile = new Scanner(new File(System.getProperty("user.dir") + "/input.txt"));
            readNamesFromFile(names, textFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        name = sdFinal.shuffleList(names);
        shuffledName = sdFinal.shuffleWord(name);

        System.out.println("The scrambled word is " + shuffledName);

        while (!finished) {
            answer = scanner.nextLine();
            points = sdFinal.numberOfVowelsAndConsonants(answer, name);
            correct = spellChecker.getIfCorrect(answer);
            if (answer.equals(name) && correct) {
                System.out.println("You won!");
                finished = true;
            } else {
                System.out.println("You only got " + points + " points, please try again");
            }
        }
    }
    private static List<String> readNamesFromFile(List<String> names, Scanner textFile) {
        while(textFile.hasNextLine()) {
            names.add(textFile.next());
        }
        return names;
    }
}

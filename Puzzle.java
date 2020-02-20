import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
    private String word;
    private String guesses;
    private final int MAX_WORDS = 45402;

    public Puzzle() {
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            int n = (int)(Math.random()*MAX_WORDS);
            String line = "";
            while (i < n) {
                line = scanner.next();
                i++;
            }
            scanner.close();
            word = line.toUpperCase();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        guesses = "";
    }

    public boolean makeGuess(String guess) {
        guess = guess.toUpperCase();
        guesses += guess;
        return word.contains(guess);
    }

    public void show() {
        int i = 0;
        System.out.print("Puzzle: ");
        while (i < word.length()) {
            if (guesses.contains(""+word.charAt(i))) {
                System.out.print(word.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
            i++;
        }

        System.out.print("\n\nGuesses: ");
        int j = 0;
        while (j < guesses.length()) {
            System.out.print(guesses.charAt(j));
            j++;
            if (j != guesses.length()) {
                System.out.print(", ");
            }
        }
    }

    public boolean isUnsolved() {
        for (int i = 0; i < word.length(); i++) {
            if (!guesses.contains(""+word.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String w) {
        word = w;
    }
    
    public void setGuesses(String w) {
        guesses = w;
    }
    
    public void addGuess(String g) {
        guesses += g;
    }
}

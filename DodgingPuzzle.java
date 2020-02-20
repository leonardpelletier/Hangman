import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DodgingPuzzle extends Puzzle
{
    private ArrayList<String> words;
    private int wordLength;

    public DodgingPuzzle() {
        wordLength = (int)(Math.random()*11 + 5);
        words = new ArrayList<String>();

        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String tempWord = scanner.next().toUpperCase();
                
                    words.add(tempWord);
                
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setGuesses("");
        setWord("");
    }

    public boolean makeGuess(String guess) {
        if (getWord().length() > 0) {
            return super.makeGuess(guess);
        }
        else {
            guess = guess.toUpperCase();
            addGuess(guess);
            //prune words list to remove all occurances of guess
            //if there are less than 100 words left, randomly choose one
            //to be the puzzle.
            int i = words.size()-1;
            while (i >= 0) {
                if (words.get(i).contains(guess)) {
                    words.remove(i);
                }
                i--;
            }
            if (words.size() < 100) {
                int r = (int)(Math.random()*words.size());
                setWord(words.get(r));
            }
            return false;
        }
    }

    public boolean isUnsolved() {
        if (getWord().length() == 0) 
            return true;
        return super.isUnsolved();
    }
    
    public void show() {
        if (getWord().length() > 0) {
            super.show();
        }
        else {
            for (int i = 0; i < wordLength; i++) {
                System.out.print("_ ");
            }
        }
        
    }
}

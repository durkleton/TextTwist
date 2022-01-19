/**********************************************************************************************
* In Text Twist, players try to score points by forming words using the letters from a 6-letter
* scrambled word. They win the round if they can successfully unscramble the 6-letter word.
*
* Create a function that takes in an array of already-guessed words, the unscrambled 6-letter
* word and returns the total number of points the player scored in a particular round using the
* following rubric:
*
* 3-letter words are 1 pt
* 4-letter words are 2 pts
* 5-letter words are 3 pts
* 6-letter words are 4 pts + 50 pt bonus (for unscrambling the word)
* Remember that invalid words (words that cannot be formed from the 6-letter unscrambled words)
* count as 0 pts.
**********************************************************************************************/
import java.util.Arrays;
import java.util.List;

public class TextTwist {
    
    private String text;
    private String[] twists;

    public TextTwist(String text, String[] twists) {
        this.text = text;
        this.twists = twists;
    }

    // This method calculates the score of the given text and its twists
    public int calculateScore(){
        int score = 0;
        StringBuilder textChecker;
        // For each string in the list we want to check if the word can be made out of the text
        for (String string : twists) {
            // If the string has an invalid length,
            // we want to skip this loop iteration
            if (string.length() < 3 || string.length() > 6)
                continue;
            // Setting up a char array for our current twist string and a StringBuilder from our text to check against
            char[] twistArray = string.toCharArray();
            textChecker = new StringBuilder(text);
            int points = 0;
            // Checking each character in the twist string to see if it exists in the text
            for (char c : twistArray) {
                int res = textChecker.indexOf(String.valueOf(c));
                // If the text string contains the current character,
                // we want to delete it from the builder as to not count it again
                if (res != -1){
                    textChecker.deleteCharAt(res);
                    points++;
                }
                // If we find a character not in the builder,
                // we want to award no points and break the loop
                else{
                    points = 0;
                    break;
                }
            }
            // If we get a six letter word,
            // we want to add an extra 50 points
            if (string.length() == 6)
                score += 50;
            // Finally, we add the points for the twist to the total score
            score += points - 2;
        }
        return score;
    }

    // Setties and Spagettis
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTwists() {
        return twists;
    }

    public void setTwists(String[] twists) {
        this.twists = twists;
    }

}

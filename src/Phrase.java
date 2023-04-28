public class Phrase{

    public static String gamePhrase;
    private String playingPhrase;
    private String guesses;

    public Phrase(){
        guesses = "";
    }

    public void clearGuess(){
        guesses = "";
        playingPhrase = Phrase.gamePhrase;
    }

    public boolean findLetters(String guess) throws MultipleLettersException{//checks if player guess is in gamephrase
        if(guess.length() > 1 || Phrase.gamePhrase.isBlank()){
            throw new MultipleLettersException();
        }

        if(! guesses.contains(guess)){
            guesses += guess;
        }
        return Phrase.gamePhrase.contains(guess);
    }

    public boolean digitFound(String guess){//determines if a non char is entered
        boolean digit = false;
        char[] characters = guess.toCharArray();
        for(char c : characters){
            if(! Character.isLetter(c)){
                digit = true;
                break;
            }
        }
        return digit;
    }

    public String replaceLetters(){//declares playing phrase as game phrase and changes playing phrase to _
        playingPhrase = Phrase.gamePhrase;
        String[] words = playingPhrase.split(" ");
        String[] replacedWords = new String[words.length];
        char[] guessedChars = guesses.toCharArray();
        char[] lowercasedGuessedChars = new char[guessedChars.length];

        for(int i = 0; i < guessedChars.length; i++){
            lowercasedGuessedChars[i] = Character.toLowerCase(guessedChars[i]);
        }

        String lowercasedGuessedString = new String(lowercasedGuessedChars);

        for(int i = 0; i < words.length; i++){
            String currentWord = words[i];
            char[] currentChars = currentWord.toCharArray();

            for(int j = 0; j < currentChars.length; j++){
                char currentChar = Character.toLowerCase(currentChars[j]);
                if(lowercasedGuessedChars.length < 1 || lowercasedGuessedString.indexOf(currentChar) < 0){
                    currentChars[j] = '_';
                }
            }

            replacedWords[i] = new String(currentChars);
        }

        playingPhrase = String.join(" ", replacedWords);
        return playingPhrase;
    }

    public boolean hasGuessedAll(){//determines if all the letters of a phrase have been guessed.
        return replaceLetters().equals(Phrase.gamePhrase);
    }
}

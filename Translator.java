import java.util.ArrayList;
import java.util.Scanner;

public class Translator {

  /* 
   * Create 1-2 meaningful ArrayList
   */
private ArrayList<String> english;
private ArrayList<String> spanish;

/*
 * Constructor for the Translator class
 * Initializes the English and Spanish word lists by reading phrase files
 */
  public Translator() {
    english = FileReader.toStringList("english.txt");
    spanish = FileReader.toStringList("spanish.txt");
  }
 
 /*
  * Student Developed Algorithm
  * Translates a given English sentence into Spanish by converting each word one by one
  * If a word exists in the English list, it is replaced with its Spanish equivalent
  * If a word is not found, it returns the english word
  
  * @param phrase: An ArrayList of words representing the sentence that needs to be translated
  * @return A translated sentence as a String, with words converted to Spanish where applicable
  */
  public String translateSentence(ArrayList<String> phrase) {
    String result = "";
   // traverses the chosen phrase;
    for (int i = 0; i< phrase.size(); i++){
      String c = phrase.get(i).toLowerCase();
   // checks if word in the phrase is in the english word list;
      if(isInEnglish(c)){
   // if the word is in the english list returns a word from the spanish list;
        String spanishWord = returnSpanish(c);
        System.out.println(spanishWord);
        result += spanishWord + " ";
        // phrase.set(i, spanishWord);
      } else {
        result += c + " ";
      }
    }

    return result;
  }

/*
 * Student developed algorithm
 * Retrieves the Spanish equivalent of a given English word
 * Searches the English word list and returns the corresponding Spanish word from the Spanish list
 
 * @param word: The English word to be translated
 * @return The Spanish equivalent of the given word, or an empty string if not found
 */
public String returnSpanish(String word){
  String spanishWord = "";
  for (int i = 0; i<spanish.size(); i++){
    if (word.equals(english.get(i))){
      spanishWord = spanish.get(i);
    }
  }
  return spanishWord;
}
/*
 * Student developed algorithm
 * Displays a menu for the user to select a predefined English sentence to translate into Spanish
 * Reads user input, loads the corresponding phrase from a file, translates it, and prints the translated sentence to the console
 * If the input does not match an available option, nothing happens
 */
  public void prompt() {
   Scanner input = new Scanner(System.in);

    System.out.println("Which sentence do you want to be translated!");
    System.out.println("");
    
    System.out.println("   1. The Fat Cat Jumped Over The Mat, In Hopes Of Stealing A Snack");
    System.out.println("   2. The country bumpkin fell flat on his face, while picking a pumpkin.");
    System.out.println("   3. One of my dreams has been to leave my home, and travel the world. Some of the places I plan to visist are Greece, Italy, and Saudi Arabia.");

    String userInput = input.nextLine();

    if (userInput.equals("1")) {
      ArrayList<String> phrase1 = FileReader.toStringList("phrase1.txt");
      String xlate = translateSentence(phrase1);
      System.out.println("Translation:");
      System.out.println(xlate);
    } else if (userInput.equals("2")) {
       ArrayList<String> phrase2 = FileReader.toStringList("phrase2.txt");
      String xlate = translateSentence(phrase2);
      System.out.println("Translation:");
      System.out.println(xlate);
    } else if (userInput.equals("3")) {
       ArrayList<String> phrase3 = FileReader.toStringList("phrase3.txt");
      String xlate = translateSentence(phrase3);
      System.out.println("Translation:");
      System.out.println(xlate);
    } else {
    }

    input.close();
  }

/*
 * Student developed algorithm
 * Checks if a given word exists in the English word list

 * @param word: The word to check
 * @return returns true if the word exists in the English list, false if not
 */
  public boolean isInEnglish(String word) {
    for (int i = 0; i < english.size(); i++){
      if(word.equals(english.get(i))){
        return true;
      }
    }
    return false;
  }

}
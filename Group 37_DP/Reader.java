/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kapila Nishantha
 */
class Reader {

    static String theText="";
    static String inputTxt="";
    
   public static String method(String word){
      Scanner inFile = null;
      File inputFile;   
      inputTxt ="";
      inputFile = new File("ass.txt");
      
        try {   
            inFile = new Scanner(inputFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      while(inFile.hasNext()) {         
         theText = inFile.nextLine();
         Levenshtein a = new Levenshtein();
         if(Levenshtein.distance(word,theText)<2) {
              inputTxt += theText+"\n";
          }
      }
      return inputTxt;
      
   }
    
}

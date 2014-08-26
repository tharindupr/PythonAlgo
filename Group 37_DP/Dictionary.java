

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tharindu Prabhath
 */
public class Dictionary {
    HashSet dic=new HashSet();
    Dictionary()
    {
      File inputFile = new File("ass.txt");
      Scanner inFile = null;   
        try {
            inFile = new Scanner(inputFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
      String theWord;
      while(inFile.hasNext()) {         
         theWord = inFile.nextLine();
          //System.out.println(theWord);
         dic.add(theWord);
         
        
          }
    }
    
    public boolean check(String word)
    {
        return(dic.contains(word));
    }
}

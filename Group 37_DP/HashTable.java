
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Kapila Nishantha
 */
class HashTable {
    private static File inputFile;
    private static Scanner inFile;
    private static String theText;
   //public static void main(String args[]) {
      // create hash table
    public boolean cheker(String word){
      Hashtable htable = new Hashtable();
      
      // put values into the table
      inputFile = new File("ass.txt");
        try {
            inFile = new Scanner(inputFile);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(HashTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        int n=1;
      while(inFile.hasNext()) { 
          theText = inFile.nextLine();
          htable.put(n ,theText);
          n++;
      }
      //check existing words in the table
      boolean isavailable=htable.contains(word);
      //return availability
      System.out.println(isavailable);
      return isavailable;
   }    
    
}

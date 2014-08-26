
import java.util.*;


/**
 *
 * @author Tharindu Prabhath
 */
public class WordWrap {

    /**
     * @param args the command line arguments
     */
    //Global Has table to get leangth of words
    Hashtable<String, Integer> wordLeangths = new Hashtable<String, Integer>();
    String result="";
    int error;
 
    
    
    
    
    public void wrap(String sentence,int limit)
    {
        String[] wList=sentence.split(" ");
        int[] wCountList=new int[wList.length];
        wCountList=wordLengthArray(wList);
        int n=wList.length;
        int M=limit;
        
        wordWrap(wList,wCountList,n,M);
        
    }
    
    
    public int[] wordLengthArray(String[] arr)
    {
        int array[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            array[i]=calWordLeangth(arr[i]);
        }
        return(array);
    }
    
    //funtion that calculate word leangths    
    public  int calWordLeangth(String word)
    {
        if(wordLeangths.get(word)!=null)
            return(wordLeangths.get(word));
        else
        {
            wordLeangths.put(word,word.length());
            return(wordLeangths.get(word));    
        }
    }
    
    public void wordWrap(String[] wordList,int l[],int n,int M)
    {
    // For simplicity, 1 extra space is used in all below arrays 
 
    // extras[i][j] will have number of extra spaces if words from i 
    // to j are put in a single line
    result="";
    int extras[][]=new int[n+1][n+1];  
 
    // lc[i][j] will have cost of a line which has words from 
    // i to j
    int lc[][]=new int[n+1][n+1];
  
    // c[i] will have total cost of optimal arrangement of words 
    // from 1 to i
    int c[]=new int[n+1];
 
    // p[] is used to print the solution.  
    int p[]=new int[n+1];
 
    int i, j;
 
    // calculate extra spaces in a single line.  The value extra[i][j]
    // indicates extra spaces if words from word number i to j are
    // placed in a single line
    for (i = 1; i <= n; i++)
    {
        extras[i][i] = M - l[i-1];
        for (j = i+1; j <= n; j++)
            extras[i][j] = extras[i][j-1] - l[j-1] - 1;
    }
 
    // Calculate line cost corresponding to the above calculated extra
    // spaces. The value lc[i][j] indicates cost of putting words from
    // word number i to j in a single line
    for (i = 1; i <= n; i++)
    {
        for (j = i; j <= n; j++)
        {
            if (extras[i][j] < 0)
                lc[i][j] =1000000000;
            else if (j == n && extras[i][j] >= 0)
                lc[i][j] = 0;
            else
                lc[i][j] = extras[i][j]*extras[i][j]*extras[i][j];
        }
    }
 
    // Calculate minimum cost and find minimum cost arrangement.
    //  The value c[j] indicates optimized cost to arrange words
    // from word number 1 to j.
    
    c[0] = 0;
    for (j = 1; j <= n; j++)
    {
       
        c[j] = 1000000000;
        for (i = 1; i <= j; i++)
        {
             
            if (c[i-1] != 1000000000 && lc[i][j] != 1000000000 && (c[i-1] + lc[i][j] < c[j]))
            {
                
                c[j] = c[i-1] + lc[i][j];
                p[j] = i;
               //System.out.println(n);
               //
                //print(wordList,1,3);
                //System.out.println(c[j]);
                error=c[j];
            }
        }
        
    }
    
    //print(list,1,4);
    printSolution(wordList,p,n);
  /*  for (int z=0;z<p.length;z++)
    {
        System.out.println(p[z]);}*/
    
}
    
public int printSolution (String[] wlist,int p[], int n)
{
    int k=-1;
    if (p[n] == 1)
        k = 1;
    else 
        k = printSolution (wlist,p, p[n]-1) + 1;
    //System.out.println("Line number "+k+"  : From word no. "+p[n]+" to"+n);
    //System.out.println(p[n]+" "+n);
    print(wlist,p[n],n+1);
    return k;
}



public void print(String[] wordList,int start,int end)
{
    String st="";
    while(start<end)
    {
        
        st+=wordList[start-1]+" ";
             
        start++;
    }
    
    result=result+st+"\n";
    //System.out.println(result);
    //System.out.println(error);
}
 


}
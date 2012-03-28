/*

* To change this template, choose Tools | Templates

* and open the template in the editor.

*/

package quicksort;



import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**

*

* @author Davidson_B

*/

public class QuickSort {



     /**

      * @param args the command line arguments

      */

     public static void main(String[] args) {
         List<Integer> testme;
         try {
            testme = FileArrayProvider.readLines("C:/QuickSort.txt");
         } catch (IOException ex) {     
            Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
            testme = null;
         }
             int[] example = (convertIntegers(testme));
             sorter asorter = new sorter(example);
             asorter.quickSort(sorter.pivot.median);
             long count = asorter.getCount();

             System.out.println(Long.toString(count));

     }
public static int[] convertIntegers(List<Integer> integers)
{
     int[] ret = new int[integers.size()];
     Iterator<Integer> iterator = integers.iterator();
     for (int i = 0; i < ret.length; i++)
     {
         ret[i] = iterator.next().intValue();
     }
     return ret;
}
}



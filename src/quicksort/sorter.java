

/*

* To change this template, choose Tools | Templates

* and open the template in the editor.

*/

package quicksort;



/**

*

* @author Davidson_B

*/

public class sorter {

     private int[] intArray;
     private int comparisons;
     private PivotMaker pivoter;

     public sorter(int[] someInts){
         intArray = someInts;
         comparisons = 0;
     }

     public int getArrayLength(){
         return intArray.length;
     }

     private void incrementComparison(int i){
         comparisons = comparisons+i;;
     }

     public void quickSort(sorter.pivot aPivot ){


         if (aPivot != null){
             sorter.pivot first = sorter.pivot.first;
             sorter.pivot last = sorter.pivot.last;
             sorter.pivot median = sorter.pivot.median;
             if (aPivot == first)
                 pivoter = new firstPivot(this);
             if (aPivot == last)
                 pivoter = new lastPivot(this);
             
             if (aPivot == median)
                 pivoter = new medianPivot(this);
             }

         quickSorter(0, intArray.length-1);
     //Cleanup
         aPivot = null;
}

     private void quickSorter(int left, int right){
         if (right-left <= 0 ) {
        }
         else {
             int pivot = intArray[pivoter.Pivot(left,right)];
             this.incrementComparison(right-left);
             int i;
             i = left+1;
             intArray[pivoter.Pivot(left, right)] = intArray[left];
             intArray[left] = pivot;
             for (int j = left+1; j <= right; j++){
                 if (intArray[j] < pivot){
                     int temp = intArray[i];
                     intArray[i] = intArray[j];
                     intArray[j] = temp;
                     i++;
                 }
             }
             int temp = intArray[left];
             intArray[left] = intArray[i-1];
             intArray[i-1] = temp;
             this.quickSorter(left,i-2);
             this.quickSorter(i,right);

         }

     }

     public long getCount(){
         return comparisons;
     }

     private abstract class PivotMaker{
         sorter aSorter;

         public PivotMaker(sorter thisSorter){
             aSorter = thisSorter;
     }
         abstract public int Pivot(int left, int right);
     }

     private class firstPivot extends PivotMaker{

         public firstPivot(sorter thisSorter){
             super(thisSorter);
         }

         @Override
         public int Pivot(int left, int right) {
             return left;
         }
     }

     private class lastPivot extends PivotMaker{

         public lastPivot(sorter thisSorter){
             super(thisSorter);
         }

         @Override
         public int Pivot(int left, int right) {
             return right;
         }
     }

     private class medianPivot extends PivotMaker{

         public medianPivot(sorter thisSorter){
             super(thisSorter);
         }

         @Override
         public int Pivot(int left, int right) {
             int length = right-left+1;
             int max, middle, min;
             
             if (aSorter.intArray[left] > aSorter.intArray[right]){
                 max = left;
                 min = right;
             }
             else{
                 max = right;
                 min = left;
             }
             if (length%2 == 0)
                 middle = left+(length/2)-1;
             else
                 middle = left+(length-1)/2;
             
             if (aSorter.intArray[max] > aSorter.intArray[middle] && aSorter.intArray[middle] > aSorter.intArray[min])
                 return middle;
             else if (aSorter.intArray[middle] > aSorter.intArray[max] )
                 return max;
             else
                 return min;
         }
     }

     public enum pivot{
         first, last, median
     }
}


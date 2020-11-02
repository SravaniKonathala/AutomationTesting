
import java.util.Arrays;

/*
*Question 2: Given two arrays of integers, compute the pair of values (one value in each array)
*  with the smallest (non-negative) difference and then return the difference.
 */

public class FindSmallestDifference {

    public static void main(String[] args)  {
        int[] array1 ={1,3,15,11,2};
        int[] array2 = {23,127,235,19,8};
        int result;
        int temp = findHighestValueInArray(array1,array2);
        int array1Length = array1.length;
        int array2Length = array2.length;
        String pair="";
        for(int i=0;i<array1Length;i++){
            for(int j=0;j<array2Length;j++){
                result = array1[i]-array2[j];
                if (result >= 0 ){
                    if(result<=temp){
                        temp=result;
                        pair = "Smallest difference: "+result+", Pair:("+array1[i]+","+array2[j]+")";
                    }
                }

            }
        }
        System.out.println("******************** Result : "+pair+" ***********************");

    }
 public static int findHighestValueInArray(int[] array1, int[] array2){
        int highestValueInArray;
     int firstArrayMax = Arrays.stream(array1).max().getAsInt();
     int secondArrayMax =  Arrays.stream(array2).max().getAsInt();
     if(firstArrayMax >= secondArrayMax){
         highestValueInArray = firstArrayMax;
     }
     else{
         highestValueInArray = secondArrayMax;
     }
     return highestValueInArray;
 }
}

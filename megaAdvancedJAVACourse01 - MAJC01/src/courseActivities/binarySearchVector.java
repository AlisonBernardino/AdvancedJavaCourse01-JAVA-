package courseActivities;
import java.util.Arrays;

public class binarySearchVector {
    public static void main(String[] args){
        int numbersVector[] = {5,10,4,7,5,8,1};
        // "For each" loop implementation
        for(int orderedVector:numbersVector){
            System.out.println(orderedVector + " ");
        }
        System.out.println("");
        int arrayIndex = Arrays.binarySearch(numbersVector, 1);
        System.out.println("Searched value index = " + arrayIndex);
    }
}

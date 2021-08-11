package courseActivities;
import java.util.Arrays;

public class binarySearchVector {
    public static void main(String[] args){
        int numbersVector[] = {1,6,9,4,5,7,3,2,8};
        for(int organizedVector:numbersVector){
            System.out.print(organizedVector + " ");
        }
        System.out.println("");
        int searchedArray = Arrays.binarySearch(numbersVector, 3);
        System.out.println("Searched value index = " + searchedArray);
        
        // Arrays.fill use
        float valuesVector[] = new float[25];
        Arrays.fill(valuesVector, 4.5f);
        for(float fillingValue:valuesVector){
            System.out.println(fillingValue + " ");
        }        
    }
}

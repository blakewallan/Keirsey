
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by blakeallan on 3/11/15.
 */


public class Keirsey {

    public static void main(String[] args) throws FileNotFoundException {
        outputResults();
    }

    //Method iterates through the scores lines and returns new Arrays
    //per line containing the occurences of A in each line
    public static int[] countA(String scores) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int[] totalArray = new int[4];
        for (int i = 0; i < scores.length(); i++) {
            char A = scores.charAt(i);
            if (A == 'A') {
                if (i % 7 == 0) {
                    count0++;
                }
                if (i % 7 == 1 || i % 7 == 2) {
                    count1++;
                }
                if (i % 7 == 3 || i % 7 == 4) {
                    count2++;
                }
                if (i % 7 == 5 || i % 7 == 6) {
                    count3++;
                }
            }
            totalArray[0] = count0;
            totalArray[1] = count1;
            totalArray[2] = count2;
            totalArray[3] = count3;
        }
        return totalArray;
    }

    //Method iterates through the scores lines and returns new Arrays
    //per line containing the occurences of B in each line
    public static int[] countB(String scores) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int[] totalArray = new int[4];
        for (int i = 0; i < scores.length(); i++) {
            char A = scores.charAt(i);
            if (A == 'B') {
                if (i % 7 == 0) {
                    count0++;
                }
                if (i % 7 == 1 || i % 7 == 2) {
                    count1++;
                }
                if (i % 7 == 3 || i % 7 == 4) {
                    count2++;
                }
                if (i % 7 == 5 || i % 7 == 6) {
                    count3++;
                }
            }
            totalArray[0] = count0;
            totalArray[1] = count1;
            totalArray[2] = count2;
            totalArray[3] = count3;
        }
        return totalArray;
    }

    //This method compares both arrays and returns the percentage
    //of the occurrence of the letter B
    public static double[] percentage(int[] a1, int[] a2) {
        double[] finals = new double[4];
        for (int i = 0; i < 4; i++) {
            double divisor = a1[i] + a2[i];
            finals[i] = Math.round((a2[i] / divisor) * 100);
        }
        return finals;
    }

    //This method analyzes the the percentage Arrays and fills
    //an empty array with the final results
    public static String[] scores(double[] percentages) {
        String[] scores = new String[4];
        if (percentages[0] > 50){
            scores[0] = "I";
        }
        if (percentages[1] > 50){
            scores[1] = "N";
        }
        if (percentages[2] > 50){
            scores[2] = "F";
        }
        if (percentages[3] > 50){
            scores[3] = "P";
        }
        if (percentages[0] < 50){
            scores[0] = "E";
        }
        if (percentages[1] < 50){
            scores[1] = "S";
        }
        if (percentages[2] < 50){
            scores[2] = "T";
        }
        if (percentages[3] < 50){
            scores[3] = "J";
        }
        for (int i = 0; i < 4; i++) {
            if (percentages[i] == 50) {
                scores[i] = "X";
            }
        }
        return scores;
    }

    //this method cleans up the code by putting all the output in a method
    public static void outputResults() throws FileNotFoundException {
        Scanner openFile = new Scanner(new File("personality.txt"));
        while (openFile.hasNextLine()) {
            String names = openFile.nextLine();
            String scores = openFile.nextLine().toUpperCase();
            System.out.print(names + ": ");
            
            double[] percent = percentage(countA(scores), countB(scores));
            
            int[] intArray = new int[percent.length];
            for (int i=0; i<intArray.length; ++i)
                intArray[i] = (int) percent[i];

            System.out.print(Arrays.toString(intArray) + " = ");

            //Iterate through double type array and converts to an int array
            String[] x = scores(percent);
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]);
            }
            System.out.println("");
        }
    }

}

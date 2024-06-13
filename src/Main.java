import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* prompting user for grades  */
        System.out.println("Enter the grades separated by spaces:");

        // String input = "2 20 21 22 23 30 48 49 50 55 60 65 72 63 76 80 68 90 85 98";
        String input = scanner.nextLine();
        scanner.close();  // close the scanner


        int[] scores = convertStringToIntArray(input);
        int[] stats = gradeStats(scores);

        System.out.println("\nValues: \n");
        findMaxValue(scores);
        findMinValue(scores);
        findAvgValue(scores);

        System.out.println("\nGraph: \n");
        drawBarGraph(stats);

    }

    /* Method that converts given string input to an array of integers `scores` */
    public static int[] convertStringToIntArray(String input) {
        String[] scoreStrings = input.split(" "); // split the input string characters by spaces
        int[] scores = new int[scoreStrings.length];
        for (int i = 0; i < scoreStrings.length; i++) {
            scores[i] = Integer.parseInt(scoreStrings[i]); // parse string numbers to integer & add to the scores array
        }
        return scores;
    }

    /* Method to calculate the maximum grade */
    public static int findMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("The maximum grade is: " + max);
        return max;
    }

    /* Method to calculate the minimum grade */
    public static int findMinValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("The minimum grade is: " + min);
        return min;
    }

    /* Method to calculate the average grade */
    public static double findAvgValue(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum/array.length;  // store in double datatype to preserve the decimal place

        System.out.println("The average grade is: " + avg);
        return avg;
    }

    /* Method to calculate the different grade stats from given scores */
    public static int[] gradeStats(int[] array) {
        int[] stats = new int[5];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 80){
                stats[4]++;
            }
            else if (array[i] > 60 ){
                stats[3]++;
            }
            else if (array[i] > 40 ){
                stats[2]++;
            }
            else if (array[i] > 20 ){
                stats[1]++;
            }
            else if (array[i] >= 0 ){
                stats[0]++;
            }

        }

        return stats;

    }

    /* Method to graphically print scores against grade ranges */
    public static void drawBarGraph(int[] stats) {

        for (int i = 6; i > 0; i--) {
            System.out.print("   " + i + " > ");      // loop against descending values to create vertical units
            for (int j = 0; j < stats.length; j++) {  // recursive loop to gauge stats against vertical scale
                if (stats[j] >= i) {                  //
                    System.out.print("  ####### ");   // if exists print hashes else print spaces
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }

        System.out.print("     +-----------+---------+---------+---------+---------+\n");  // horizontal scale
        System.out.print("     I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I\n\n");
    }

}

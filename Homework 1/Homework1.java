
/**
 *
 * @author Miruna
 */
public class Homework1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        int n = Integer.parseInt(args[0]);
        int counter1;
        int counter2;

        long startingTime = System.nanoTime();

        int[][] matrix = new int[10][10];
        for (counter1 = 1; counter1 <= n; counter1++) {
            int counter3 = 1;
            for (counter2 = counter1; counter2 <= n; counter2++) {
                matrix[counter1][counter3] = counter2;
                counter3++;
            }
            for (counter2 = 1; counter2 < counter1; counter2++) {
                matrix[counter1][counter3] = counter2;
                counter3++;
            }
        }
        /*
        for (counter1=1;counter1<=n;counter1++)
        { 
          for(counter2=1;counter2<=n;counter2++)
            System.out.print(matrix[counter1][counter2]);
          System.out.println();
        }*/

        if (n > 30000) {
            long finishingTime = System.nanoTime();
            long totalTime = finishingTime - startingTime;
            System.out.println(totalTime);
        } else {
            System.out.println("Afisare randuri");
            for (counter1 = 1; counter1 <= n; counter1++) {
                String row = "";
                for (counter2 = 1; counter2 <= n; counter2++) {
                    row = row + matrix[counter1][counter2];
                }
                System.out.println(row);
            }
            System.out.println("Afisare coloane");
            for (counter2 = 1; counter2 <= n; counter2++) {
                String column = "";
                for (counter1 = 1; counter1 <= n; counter1++) {
                    column = column + matrix[counter1][counter2];
                }
                System.out.println(column);
            }
        }
    }
}

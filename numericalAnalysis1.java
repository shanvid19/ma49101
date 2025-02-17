import java.util.Scanner;

//CODE FOR GAUSSIAN ELIMINATION

public class numericalAnalysis1 {

    public static void gaussElim(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            double divisor = matrix[i][i];
            for (int j = 0; j <= n; j++) {
                matrix[i][j] /= divisor;
            }

            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i];
                for (int j = i; j <= n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = matrix[i][n];
            for (int j = i + 1; j < n; j++) {
                solution[i] -= matrix[i][j] * solution[j];
            }
        }

        System.out.println("Solution:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.2f\n", i + 1, solution[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of variables: ");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n + 1];
        System.out.println("Enter the augmented matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        gaussElim(matrix, n);
        sc.close();
    }
}

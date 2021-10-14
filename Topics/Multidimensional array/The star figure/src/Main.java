import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            matrix[i][n - 1 - i] = '*';
            matrix[i][i] = '*';
            matrix[n / 2][i] = '*';
            matrix[i][n / 2] = '*';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c ", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
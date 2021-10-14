import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] vector = new int[length];

        for (int i = 0; i < length; i++) {
            vector[i] = scanner.nextInt();
        }

        int number = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            if (vector[i] > number) {
                sum += vector[i];
            }
        }

        System.out.println(sum);
    }
}
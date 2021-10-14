import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] vector = new int[arrSize];


        for (int i = 0; i < arrSize; i++) {
            vector[i] = scanner.nextInt();
        }
        int minimumNumber = vector[0];

        for (int i = 0; i < arrSize; i++) {
            minimumNumber = minimumNumber > vector[i] ? vector[i] : minimumNumber;
        }

        System.out.println(minimumNumber);

    }
}
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfArray = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < sizeOfArray; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }
}
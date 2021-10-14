
import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        int counter = 0;
        int aux = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (aux < arr[i]) {
                aux = arr[i];
                counter = i;
            }
        }
        System.out.println(counter);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] box1 = new int[3];
        int[] box2 = new int[3];
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < box1.length; i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < box2.length; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        // Comparing the two boxes
        for (int i = 0; i < box1.length; i++) {
            if (box1[i] < box2[i]) {
                counter1++;

            } else if (box1[i] > box2[i]) {
                counter2++;
            }
        }

        if (counter1 == box1.length) {
            System.out.println("Box 1 < Box 2");
        } else if (counter2 == box2.length) {
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}
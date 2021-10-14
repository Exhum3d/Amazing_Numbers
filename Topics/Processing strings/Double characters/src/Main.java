import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        for (char element : arr) {
            System.out.printf("%c%c", element, element);
        }

    }
}
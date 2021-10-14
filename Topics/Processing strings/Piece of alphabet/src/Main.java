import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String alphabet = "abcdefghijklmopqrstuvwxyz";
        if (alphabet.contains(scanner.nextLine())) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
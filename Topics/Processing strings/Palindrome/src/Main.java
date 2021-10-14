import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        StringBuilder reversedWord = new StringBuilder(word);
        String reversed = reversedWord.reverse().toString();
        if (Objects.equals(word, reversed)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
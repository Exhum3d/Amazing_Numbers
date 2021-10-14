import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] processedStr = str.split("-");
        System.out.printf("%s/%s/%s", processedStr[1], processedStr[2], processedStr[0]);
    }
}
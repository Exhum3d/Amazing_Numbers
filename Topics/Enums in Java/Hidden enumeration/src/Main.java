public class Main {

    public static void main(String[] args) {
        Secret[] secrets = Secret.values();
        int count = 0;
        for (Secret sec : secrets) {
            if (sec.toString().contains("STAR")) {
                count++;
            }
        }
        System.out.println(count);
    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}
*/

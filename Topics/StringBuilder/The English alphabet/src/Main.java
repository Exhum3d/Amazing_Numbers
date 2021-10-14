class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder sb = new StringBuilder();
        sb.append("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}

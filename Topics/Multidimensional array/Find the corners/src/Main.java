
class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int[] firstRow = twoDimArray[0];
        int[] lastRow = twoDimArray[twoDimArray.length - 1];

        System.out.printf("%d %d\n", firstRow[0], firstRow[firstRow.length - 1]);
        System.out.printf("%d %d\n", lastRow[0], lastRow[lastRow.length - 1]);
    }

}
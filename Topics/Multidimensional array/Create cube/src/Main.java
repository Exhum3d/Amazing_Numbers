class ArrayOperations {
    public static int[][][] createCube() {
        int n = 3;
        int[][][] array3D = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    array3D[i][j][k] = k + n * j;
                }
            }
        }
        return array3D;
    }
}
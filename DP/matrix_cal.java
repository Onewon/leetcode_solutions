package DP;

public class matrix_cal {
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4},{5,6}};
		int[][] b = {{1,2,3},{4,5,6}};
        int[][] res = dotMatrix(a,b);
        for (int[] row : res) {
            for (int col : row) {
                System.out.print(col+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] dotMatrix(int[][] a,int[][] b){
        int c[][] = new int[a.length][b[0].length];
        int x,i,j;
        for(i = 0;i<a.length ;i++){
            for(j = 0;j<b[0].length;j++){
                int temp = 0;
                for(x = 0;x<b.length;x++){
                    temp+=a[i][x]*b[x][j];
                }
                c[i][j] = temp;
            }
        } return c;
    }
}

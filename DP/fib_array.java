package DP;

/**
 * 斐波那契数列求和
 * Java int fib(46)会溢出 改用double或者float
 */

class Matrix_fib_Solution{
    public int fib_sum(int x){
        if(x==1 || x==0) return x;
        int[][] M = {{1,1},{1,0}};
        int[][] src = {{1},{1}};
        int[][] res = dotTime(M,M,x-2); //pow(a,n) can be improved.
        int[][] result = dotMatrix(res,src);
        return result[1][0];
    }
    public int[][] dotTime(int[][] x,int[][] y,int time){
        int [][] rs = x;
        for (int i = 0; i < time; ++i) {
            rs = dotMatrix(rs,y);
        }
        return rs;
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

class Math_fib_Solution{
    public float fib_sum(int x){
        if(x==1 || x==0) return x;
        float _A= (float) Math.sqrt(5)/5;
        float _B= (float) -(Math.sqrt(5)/5);
        float _Alpha = (float) (1+Math.sqrt(5))/2;
        float _Beta = (float) (1-Math.sqrt(5))/2;
        return (float)
        (_A * Math.pow(_Alpha, x) + _B * Math.pow(_Beta, x));
    }
}

class fib_Solution{
    public int fib_sum(int x){
        if(x==1 || x==0) return x;
        int[] arr =new int[x+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[x];
    }
}

class normal_Solution{
    public int fib_sum(int x){
        if(x==1 || x==0) return x;
        else return fib_sum(x-1) + fib_sum(x-2);
    }
}

public class Q_fib_array { // test case
    public static void main(String[] args) {
        int num = 10;
        System.out.print(String.format("fib(%s): ",num) + new fib_Solution().fib_sum(num));
    }
}

/** Normal fib 递归 O(2^n)
fib(20): 6765
[Done] exited with code=0 in 0.971 seconds

fib(30): 832040
[Done] exited with code=0 in 1.038 seconds

fib(40): 102334155
[Done] exited with code=0 in 1.535 seconds

fib(42): 267914296
[Done] exited with code=0 in 2.511 seconds

fib(44): 701408733
[Done] exited with code=0 in 5.004 seconds

fib(45): 1134903170
[Done] exited with code=0 in 7.379 seconds
**/

/** 缓存 fib O(n)
fib(20): 6765
[Done] exited with code=0 in 0.914 seconds

fib(30): 832040
[Done] exited with code=0 in 0.961 seconds

fib(40): 102334155
[Done] exited with code=0 in 0.926 seconds

fib(44): 701408733
[Done] exited with code=0 in 0.949 seconds

fib(45): 1134903170
[Done] exited with code=0 in 1.08 seconds
fib(45): 1134903170
[Done] exited with code=0 in 0.909 seconds
**/

/** 通项公式fib O(log n)
fib(20): 6765
[Done] exited with code=0 in 0.926 seconds

fib(30): 832040
[Done] exited with code=0 in 0.93 seconds

fib(40): 102334195 Oh! Wrong Answer
[Done] exited with code=0 in 0.955 seconds
fib(40): 102334195
[Done] exited with code=0 in 0.913 seconds

fib(44): 701409037  Oh! Wrong Answer
[Done] exited with code=0 in 0.902 seconds

fib(45): 1.13490368E9   Oh! Wrong Answer
[Done] exited with code=0 in 0.927 seconds
**/

/** matrix normal dot product

fib(10): 55
[Done] exited with code=0 in 1.14 seconds

fib(20): 6765
[Done] exited with code=0 in 0.998 seconds

fib(30): 832040
[Done] exited with code=0 in 1.028 seconds

fib(40): 102334155
[Done] exited with code=0 in 1.028 seconds

fib(44): 701408733
[Done] exited with code=0 in 1.064 seconds

fib(45): 1134903170
[Done] exited with code=0 in 1.054 seconds
 */
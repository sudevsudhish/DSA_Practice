package recursion;
//count the no of paths from (0,0) to (n,m)
public class countPaths {

    public static int count(int n, int m, int i, int j){
        if(i == n || j==m){
            return 0;
        }
        if(i == n-1&& j==m-1){
            return 1;
        }
        int downpath = count(n, m, i+1, j);

        int rightpath = count(n, m, i, j+1);
        return downpath+rightpath;
    }
    public static void main(String[] args) {
        int n=3,m=3;
        int totalpath = count(n, m, 0, 0);
        System.out.println(totalpath);
    }
    
}

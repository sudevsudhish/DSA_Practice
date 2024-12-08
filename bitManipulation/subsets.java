package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        
        int[] arr = {1,3,7};
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int subsets = 1 << n;
        for(int num=0;num<subsets - 1;num++){
            List<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<n; i++){
                if((num & (1<<i)) == 0){
                    ans.add(arr[i]);
                }
            }
            list.add(ans);
        }
        System.out.println("Subsets are : "+ list);
    }
}


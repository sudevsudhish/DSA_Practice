package recursion;
import java.util.HashSet;

public class substring {
    public static void subsequence(String str, int idx, String newString,HashSet<String> set){
        //it will work for unique substrings also
        if(idx == str.length()){
            if(!set.contains(newString)){
                System.out.println(newString);
                set.add(newString);
                return;
            }else{
                return; 
            }
            
        }
        char currChar = str.charAt(idx);
        //to be
        subsequence(str, idx+1, newString+currChar,set);

        //not to be
        subsequence(str, idx+1, newString,set);   
    }
    public static void main(String args[])
    {
        String str = "aab";
        HashSet<String> set = new HashSet<String>();
        subsequence(str, 0, "", set);
    }
}
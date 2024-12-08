package recursion;

public class permutationString {
    
    public static void permute(String str, String permutation){
       if(str.length() == 0){
        System.out.println(permutation);
        return;
       }
        for(int i=0;i<str.length();i++){
            char current = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            permute(newString, permutation+current);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permute(str, "");
    }
}

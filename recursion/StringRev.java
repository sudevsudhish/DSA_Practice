package recursion;
public class StringRev {
    public static void revString(String str, int idx){
        if(idx == 0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        revString(str, idx-1);
    }

    public static String revString2(String str){
        if(str.length() == 0){
            return str;
        }
        return revString2(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String strr = "sudev";
        revString(strr, strr.length()-1);
        System.out.println(revString2(strr));
    }
}

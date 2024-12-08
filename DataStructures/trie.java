package DataStructures;

public class trie {
    static class Node{
        Node[] children;
        boolean isEndOfWord;

        public Node(){
            children = new Node[26];
            isEndOfWord = false;
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1){
                curr.children[idx].isEndOfWord = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];
            if(node == null){
                return false;
            }
            if(i == key.length() - 1 && node.isEndOfWord == false){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    //Given a key with a word and we have to find if we break the words then it will contain in the given words 
    //key : ilikesamsung
    //words : ["i","like","those","sam", "samsung","ice"]
    public static boolean wordBreak(String key){
        if(key.length() == 0) return true;

        for(int i=1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }

    //find if the prefix exista in the given words 
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    //count all unique substings of a given word
    //create a trie of all suffix of the word and count the number of nodes in the trie 
    public static int countNode(Node root){
        if(root == null) return 0;
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }

    //longest word with all prefix 
    //ex : apple
    //words[] = {"a","banana","ap","app","apply","apple","appl"} it contains all the prefix of apple
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null) return;
        for(int i=0;i<26;i++){
            if(root.children[i] !=null && root.children[i].isEndOfWord == true){
                temp.append((char) (i + 'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }


    }



    public static void main(String[] args) {
        String words[] = {"a","banana","ap","app","apply","apple","appl"};
        for(String word: words){
            insert(word);
        }
        // String key = "ababa";
        // for(int i=0;i<key.length();i++){
        //     String substring = key.substring(i);
        //     insert(substring);
        // }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);  
    }

}

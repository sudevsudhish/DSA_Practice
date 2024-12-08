package DataStructures.tree;

import java.util.ArrayList;

public class binarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
        }

        
    } 

    public static Node insert(Node root,int val){
        if(root == null ){
            root = new Node(val);
            return root;
        }
        if(root.data < val)
            root.right = insert(root.right, val);
        else
            root.left = insert(root.left, val);
        return root;
    }

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    } 

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data < key)
            return search(root.right, key);
        else if(root.data > key)
            return search(root.left, key);
        else
            return true;

    }

    public static Node delete(Node root, int val){
        if(root == null){
            return root;
        }
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{
            //case -1 No child
            if(root.left == null && root.right == null){
                return null;
            }
            //case - 2 single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right ==null){
                return root.left;
            }
            //case-3 2child and inorder successor
            Node InorderSucc = InorderSuccessor(root.right);
            root.data = InorderSucc.data;
            root.right = delete(root.right,InorderSucc.data);

        }
        return root;
    }

    public static Node InorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printRoot2LEaf(Node root, ArrayList<Integer> path){
        if (root == null) {
            return;
        }
        path.add(root.data);
        if(root.left ==null && root.right == null){
            for(int i=0;i<path.size(); i++){
                System.out.print(path.get(i) + "->");
            }
            System.out.println();
        }
        else{
            printRoot2LEaf(root.left, path);
            printRoot2LEaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }
    
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        delete(root, 10);

        inOrder(root);
        System.out.println();

    }
}

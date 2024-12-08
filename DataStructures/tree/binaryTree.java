package DataStructures.tree;

public class binaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static int idx = -1;
    
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
    
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int x = countNodes(root.left);
        int y = countNodes(root.right);

        return x + y + 1;
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        int x = sumofNodes(root.left);
        int y = sumofNodes(root.right);

        return x + y + root.data;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int x = height(root.left);
        int y = height(root.right);

        return Math.max(x,y) + 1;
    }

    //Normal procedure O(n2) because of calculating height again in each node
    public static int diameter1(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter1(root.left); //calculate diamer of left subtree.not passing through root
        int diam2 = diameter1(root.right); // calculate diameter of right subtree. not passing through root
        int diam3 = height(root.left) + height(root.right) + 1; // calculate height of diameter passing through root

        return Math.max(diam1,  Math.max(diam2, diam3));
    }
    //optimized approach for diameter O(n)
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameter2(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int height = Math.max(left.ht, right.ht) + 1;

        int diam = Math.max(Math.max(left.diam,right.diam), left.ht + right.ht + 1);

        TreeInfo info = new TreeInfo(height, diam);

        return info;


    }




    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        
        System.out.println("Number of nodes: "+countNodes(root));
        System.out.println("Sum of nodes: "+sumofNodes(root));
        System.out.println("Height of tree: "+height(root));
        System.out.println("Diameter of the tree is: " + diameter1(root));

        System.out.println("Diameter of the tree is: " + diameter2(root).diam);


    }
}

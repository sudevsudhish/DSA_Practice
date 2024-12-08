package DataStructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class traversals {
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
    
    static class binaryTree{
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static List<List<Integer>> zigzag(Node root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // True means normal left to right, False means right to left
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<level;i++){
                Node currNode = q.poll();
                if(leftToRight){
                    currentLevel.add(currNode.data);
                }else{
                    /*The add(int index, E element) method in Java’s List interface allows us to 
                    insert an element at any specific index of the list.
                    index = 0: This means that the element (currentNode.val in this case) will be inserted
                    at the first position of the list, pushing all existing elements to the right.*/
                    currentLevel.add(0,currNode.data);
                }
                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    static class bountryTraversal{

        public List<Integer> Traversal(Node root){
            List<Integer> result = new ArrayList<Integer>();
            if(root == null) return result;

            if(!isLeaf(root)){
                result.add(root.data);
            }
            addLeftBountry(root.left, result);

            addLeafs(root, result);
            
            addRightBountry(root.right, result);

            return result;
        }

        private void addLeftBountry (Node node, List<Integer> result) {
            while(node != null){
                if(!isLeaf(node)){
                    result.add(node.data);
                }
                if(node.left != null){
                    node  = node.left;
                }else{
                    node = node.right;
                }
            }
        }

        private void addLeafs(Node node, List<Integer> result) {
            if(node == null) return;
            if(isLeaf(node)){
                result.add(node.data);
            }else{
                addLeafs(node.left, result);
                addLeafs(node.right, result);
            }
        }

        private void addRightBountry(Node node, List<Integer> result) {
           Stack<Integer> stack = new Stack<>();
           while(node != null){
                if(!isLeaf(node)){
                    stack.push(node.data);
                }
                if(node.right != null){
                    node = node.right;
                }
                else{
                    node = node.left;
                }
           }
           while(!stack.isEmpty()){
            result.add(stack.pop());
           }
        }

        public boolean isLeaf(Node root){
            return (root.left == null && root.right == null);
        }
    }
    
    static class VerticalOrderTraversal{
        public static List<List<Integer>> verticalTraversal(Node root){
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null) return result;

            // TreeMap to store the vertical distance as key and corresponding nodes as values
            // TreeMap keeps the keys sorted (so it maintains vertical order naturally)
            Map<Integer, List<Integer>> map = new TreeMap<>();
            
            // Queue for performing level-order traversal (BFS)
            // Each entry in the queue contains a node and its horizontal distance (hd) from the root
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root,0));

            while(!q.isEmpty()){
                Pair currPair = q.poll();
                Node currNode = currPair.node;
                int hd = currPair.hd;
                map.putIfAbsent(hd, new ArrayList<>());

                map.get(hd).add(currNode.data);
                if(currNode.left != null){
                    q.offer(new Pair(currNode.left, hd-1));
                }
                if(currNode.right != null){
                    q.offer(new Pair(currNode.right, hd+1));
                }
            }
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                result.add(entry.getValue());
            }



            return result;
        }

        static class Pair{
            Node node;
            int hd;
            Pair(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);

    
        // System.out.println("Preorder traversal");
        // preOrder(root);

        // System.out.println("\n"+"Inorder traversal");
        // inOrder(root);

        // System.out.println("\n"+"Postorder traversal");
        // postOrder(root);

        // System.out.println("\n"+"Level order traversal");
        // levelOrder(root);

        // System.out.println("Zigzag traversL is:");
        // List<List<Integer>> res = zigzag(root);
        // for(List<Integer> i : res){
        //     System.out.println(i);
        // }

        // bountryTraversal obj = new bountryTraversal();
        // List<Integer> boundary = obj.Traversal(root);

        // for(int i: boundary){
        //     System.out.print(i + " ");
        // }

        System.out.println("\nVertical order traversal:");
        List<List<Integer>> result = VerticalOrderTraversal.verticalTraversal(root);
        for(List<Integer> i : result){
            System.out.println(i + " ");            
        }


    }

}

package DataStructures;

public class SinglyLinkedList <T>{
    @SuppressWarnings("hiding")
    class Node<T>{
        T data;
        Node<T> next;
    
        public Node(T data){
            this.data = data;
            this.next =  null;
        }
    }
    private Node<T> head;
    
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void removeLast(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addBetween(T data,int key){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        for(int i=1;i<key;i++){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void removeBetween(int key){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node currNode = head;
        int i=1;
        while(i++<key && currNode != null){
            currNode = currNode.next;
        }
        if(currNode != null){
            currNode.next = currNode.next.next;
        }else{
            System.out.println("Please enter a valid key");
        }
    }

    @SuppressWarnings({ "rawtypes" })
    public void printList(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node currNode = head;
        while(currNode!= null){
            System.out.print(currNode.data +"->");
            currNode = currNode.next;
        }
        System.out.println("Null");
        
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void reverse(){
       if(head == null || head.next == null)
            return;
        Node prev = null;
        Node current = head;
        Node Next = null;

        while(current != null){
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }
        head = prev;

    }
    @SuppressWarnings({ "rawtypes" })
    public void FindNthFromLast(int n){
        int size=0;
        Node current = head;
        while(current != null){
            current = current.next;
            size++;
        }
        int index = size - n, i =0;
        current = head;
        while(i < index){
            current = current.next;
            i++;
        }
        System.out.print(current.data);
    }

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        SinglyLinkedList str = new SinglyLinkedList<>();

        str.addFirst("u");
        str.addFirst("s");
        str.addLast("d");
        str.addLast("e");
        str.addLast("v");

        str.addBetween("PS", 5);
        str.printList();

        str.FindNthFromLast(5);
    }

}

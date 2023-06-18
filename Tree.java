
public class Tree {
    public static class Node{
        int data;
        Node left;

        Node right;

        Node(int data) {                        //constructor of node
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }

    void preorder(Node root){
        if(root == null) {return;}
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    void inorder(Node root){
        if(root == null) {return;}

        inorder(root.left);
        System.out.println(root.data);   //B
        inorder(root.right);            //D
    }

    void postorder(Node root){
        if(root == null) {return;}    // void maa return xa bhane break gara bhnxa

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        Tree t = new Tree();
        t.postorder(root);

    }


}


//
//    public static Node head = null;
//
//    void insert(int data) {
//        Node newnode = new Node(data);
//        if (head == null) {
//            head = newnode;
//        } else {
//            Node current = head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newnode;
//        }
//    }
//
//    public static void main(String[] args) {
//        LinkedList i = new LinkedList();
//        System.out.println(i);
//
//    }
//
//}

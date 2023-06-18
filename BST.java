public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){                                  //node.java garera xuttai cllass maa call garyo bhane hunxa
            this.data = data;
            this.left = this.right= null;
        };
    }
    public Node insBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insBST(root.left, data);      //recursive call
        }
        if (data > root.data) {
            root.right = insBST(root.right, data);
        }
        return root;
    }

    public Node removeNode(Node root, int data){
        if(root==null){
            return null;
        }
        if (data<root.data){
            root.left = removeNode(root.left,data);
        } else if (data>root.data) {
            root.right = removeNode(root.right,data);
        }else {                                                     // khojeko element snga equal bhako ho  [root.left/right = RemoveNode(x,x)], x= serched element
            // case = 1 no children or only one children
            if (root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            root.data = findMin(root.right);
            removeNode(root.right, root.data);
        }
        return root;
    }

    int findMin(Node root){
        int min = root.data;
        while (root.left!=null){
            min = root.left.data;
            root=root.left;
        }
        return min;
    }
    public Node Search(Node root, int data){
        if(root.data==data|| root ==null){
            return root;
        }
        if(data<root.data){
            return Search(root.left,data);
        }
        if(data>root.data){
            return Search(root.right,data);
        }
        return root;
    }

    public static void main(String[] args) {
        BST b = new BST();
        Node root = b.insBST(null, 11);
        b.insBST(root, 8);
        b.insBST(root, 15);
        b.removeNode(root, 15);                 // to check whether it ia removd or not check with inorder traversion
    }

}


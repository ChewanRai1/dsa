public class AVLTree {
    public static class Node {
        Node left;
        Node right;
        int data;
        int height;
        Node( int data){
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }
    public Node createBST(Node root,int data){
        if(root == null){
            return new Node(data);
        }
        if (data< root.data){
            root.left=createBST(root.left, data);
        }
        else if (data>root.data) {
            root.right=createBST(root.right,data);
        }
        else{
            return root;
        }
        root.height=Math.max(root.left.height, root.right.height)+1;
        int balancefactor=findBalanceFactor(root);

        //LL case
        if(balancefactor>1 && data<root.left.data){
            rightRotate(root);
        }
        //LR case
        if(balancefactor>1 && data>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RR case
        if(balancefactor<-1 && data>root.right.data){
            leftRotate(root);
        }
        //RL case
        if(balancefactor<-1 && data<root.right.data){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public Node rightRotate(Node y){
        Node x = y.left;
        Node T2= x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(y.left.height,y.right.height)+1;
        x.height = Math.max(y.left.height,y.right.height)+1;
        return x;
    }
    public Node leftRotate(Node x){
        Node y= x.right;
        Node T2= y.left;
        y.left = x;
        x.right = T2;
        y.height = Math.max(y.left.height,y.right.height)+1;
        x.height = Math.max(y.left.height,y.right.height)+1;
        return x;
    }
    int findBalanceFactor(Node root){
        if(root == null){
            return 0;
        }
        return root.left.height-root.right.height;
    }
}

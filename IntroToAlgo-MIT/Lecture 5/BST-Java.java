/*
* BST implementation in Java
* srv_twry
* */

//Declaration of the node and its constructor
class Node {
    int data;
    Node left,right;

    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

class BinarySearchTree{
    public static Node root;

    //initializing a new BinarySearchTree
    public BinarySearchTree(){
        this.root=null;
    }

    //To insert an element in the tree
    public void insert(int data){

        Node newNode = new Node(data);

        //if it is the first element of the node
        if (root==null){
            root=newNode;
            return;
        }

        //if their are elements already present in the node
        Node parent,current;
        parent=null;
        current=root;
        while (true){
            parent=current;
            if (data <=current.data){
                current=current.left;
                if (current==null){
                    parent.left=newNode;
                    return;
                }
            }else{
                current=current.right;
                if (current==null){
                    parent.right=newNode;
                    return;
                }
            }
        }
    }

    //To find an element in the Tree
    public void Search(int data){
        Node current=root;

        while (true){
            if (current.data==data){
                System.out.println("Data found");
                return;
            }else if (data>current.data){
                current=current.right;
            }else{
                current=current.left;
            }

            if (current==null){
                System.out.println("Data not in the tree");
                return;
            }
        }
    }

    //The function to delete the node with the given key
    public Node deleteKey(Node root,int data){

        //if the tree is empty, Base case for the recursion
        if (root==null){
            return root;
        }

        if (data>root.data){
            root.right=deleteKey(root.right,data);
        }
        else if (data<root.data){
            root.left=deleteKey(root.left,data);
        }

        //if it is the node that is to be deleted
        else{

            //if it is a leaf or has one child
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }

            //if it has both left and right child, we set the data of the node to the inorder successor and recursively delete that node in the right sub-tree
            root.data=minValue(root.right);

            //recursively deleting the successor node in the right sub-tree
            root.right=deleteKey(root.right,root.data);
        }
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Creating following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(root,20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(root,30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(root,50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }

}



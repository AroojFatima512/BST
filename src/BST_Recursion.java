public class BST_Recursion {
   public static Node insert(Node root, int key){
       if (root == null){
           root = new Node(key);;
           return root;
       }
       if (key < root.data){
           root.left = insert(root.left, key);
       }
       else {
           root.right = insert(root.right, key);
       }
       return root;
    }

   public static void inorder(Node root){
       if (root == null){
           return;
       }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if (root == null){
            return false;
        }
        if(key == root.data){
            return true;
        }
        if(key > root.data){
            return search(root.right, key);
        }
        else{
            return search(root.left, key);
        }
    }

    public static Node delete(Node root, int val){
       if(val > root.data){
           root.right = delete(root.right, val);
       }
       else if (val < root.data){
           root.left = delete(root.left, val);
       }
       else { //val == root.data
           if (root.left == null && root.right == null){
               return null;
           }
           if(root.left == null){
               return root.right;
           }
           else if (root.right == null) {
               return root.left;
           }
//           Node IS = successor(root.right);
//           root.data = IS.data;
//           root.right = delete(root.right, IS.data);

           Node is = predecessor(root.left);
           root.data = is.data;
           root.left = delete(root.left, is.data);
       }
       return root;
    }

    public static Node successor(Node root){
       while (root.left != null){
           root = root.left;
       }
       return root;
    }

    public static Node predecessor(Node root){
       while (root.right != null){
           root = root.right;
       }
       return root;
    }
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(root, 4)){
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }

        delete(root, 5);
        inorder(root);
        System.out.println();

    }

}

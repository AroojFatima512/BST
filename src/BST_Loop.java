public class BST_Loop {
   static Node root;
   public static void insert(int key){
        Node node = new Node(key);
        if (root == null){
            root = node;
            return;
        }
        Node cur = root;
        Node pre = null;
        while (cur != null){
            if (key < cur.data){
                pre = cur;
                cur = cur.left;
            }
            else if (key > cur.data){
                pre = cur;
                cur = cur.right;
            }
        }
        if (key < pre.data){
            pre.left = node;
        }
        if (key > pre.data){
            pre.right = node;
        }
    }

    public static boolean search(int key){
        if (root == null){
            return false;
        }
        if (key == root.data){
            return true;
        }
        Node cur = root;
        while (cur != null){
            if (key == cur.data){
                return true;
            }
            if (key < cur.data){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return false;
    }
//    void print(){
//        Node cur = root;
//        while (cur != null){
//            System.out.print(cur.data+ " ");
//        }
//    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};

        for (int i=0; i<values.length; i++){
            insert(values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(4)){
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }
    }

}

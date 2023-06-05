// This is simple class that builds and displays a Binary Tree.


import java.util.Scanner;

class TreeNode {
  public int val;
  public TreeNode leftChild;
  public TreeNode rightChild;

  public TreeNode(int val) {
    this.val = val;
  }
  public TreeNode(){}
}

class BinaryTrees {
  
  TreeNode root;
  
  public BinaryTrees(int rootVal) {
    root = new TreeNode();
    root.val = rootVal;
  }

  public boolean buildTreeHepler(TreeNode root, Scanner sc) {

    System.out.println("Enter left child of " + root.val + " ?");
    boolean leftResponse = sc.nextBoolean();

    if(leftResponse) {
      System.out.println("Enter left child of " + root.val + ".");
      int leftChild = sc.nextInt();
      TreeNode newNode = new TreeNode(leftChild);
      root.leftChild = newNode;
      buildTreeHepler(newNode, sc);
    }

    System.out.println("Enter right child " + root.val + " ?");
    boolean rightResponse = sc.nextBoolean();

    if(rightResponse) {
      System.out.println("Enter right child of " + root.val + ".");
      int rightChild = sc.nextInt();
      TreeNode newNode = new TreeNode(rightChild);
      root.rightChild = newNode;
      buildTreeHepler(newNode, sc);
    }
    
    return true;
  }

  public boolean buildTree() {
    Scanner sc = new Scanner(System.in);
    buildTreeHepler(root, sc);
    return true;
  }

  private void displayHelper(TreeNode root) {
    if(root == null) {
      return;
    }
    
    displayHelper(root.leftChild);
    System.out.print(root.val + " ");
    displayHelper(root.rightChild);
  }
  public void displayTree() {
    System.out.println("Inorder traversal of the tree:");
    if(root == null) {
      return;
    }

    displayHelper(root);
  }
}


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter root data : ");
    int rootData = sc.nextInt();
    
    BinaryTrees BT = new BinaryTrees(rootData);

    BT.buildTree();
    BT.displayTree();
    sc.close();
  }
}

// This is implementation of a BST. It biulds and displays the BST.

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

class BinarySearchTrees {
  
  TreeNode root;
  
  public BinarySearchTrees(int rootVal) {
    root = new TreeNode();
    root.val = rootVal;
  }

  public BinarySearchTrees() {
    root = null;
  }

  private boolean buildTreeHelper(TreeNode root, int val) {

    if(val < root.val && root.leftChild == null) {
      TreeNode newNode = new TreeNode(val);
      root.leftChild = newNode;
    }
    else if(val >= root.val && root.rightChild == null) {
      TreeNode newNode = new TreeNode(val);
      root.rightChild = newNode;
    }    
    else if(val < root.val) {
      buildTreeHelper(root.leftChild, val);
    }
    else if(val >= root.val) {
      buildTreeHelper(root.rightChild, val);
    }
    
    return true;
  }
  public boolean buildTree() {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter value : ");
    int val = sc.nextInt();
    
    while(val != -1) {      
      if (root == null) {
        root = new TreeNode(val);
      }
      else {
        buildTreeHelper(root, val);  
      }
      
      System.out.print("Enter value : ");
      val = sc.nextInt();
    }
    sc.close();
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


public class BST {
  public static void main(String[] args) {
    
    BinarySearchTrees BST = new BinarySearchTrees();

    BST.buildTree();
    BST.displayTree();
  }
}

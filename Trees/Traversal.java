import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      MyTree tree = new MyTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      
      System.out.print("Inorder Traversal: ");
      tree.InorderTraversal(tree.root);
      System.out.println("\n--------------------------------------------------");
      System.out.print("PreOrder Traversal: ");
      tree.PreOrderTraversal(tree.root);
      System.out.println("\n--------------------------------------------------");
      System.out.print("PostOrder Traversal: ");
      tree.PostOrderTraversal(tree.root);
  }
}

class Node{
  int data;
  Node left, right;
  Node(int data){
    this.data = data;
    left = right = null;
  }
}

class MyTree{
  Node root;
  
  //Inorder Traversal: (left ->root ->right)
  public void InorderTraversal(Node node){
    if(node != null){
      InorderTraversal(node.left);
      System.out.print(node.data+ " ");
      InorderTraversal(node.right);
    }
  }
  //PreOrder Traversal: (Root ->left ->right )
  public void PreOrderTraversal(Node node){
    if(node != null){
      System.out.print(node.data+" ");
      PreOrderTraversal(node.left);
      PreOrderTraversal(node.right);
    }
  }
  //PostOrder Traversal: (left -> right -> root)
  public void PostOrderTraversal(Node node){
    if(node != null){
      PostOrderTraversal(node.left);
      PostOrderTraversal(node.right);
      System.out.print(node.data + " ");
    }
  }
}


#DOUBLE LINKED LIST
import java.util.*;

public class Main {
    public static void main(String[] args) {
    MyDoublelyLinkedList list = new MyDoublelyLinkedList();
    
    list.insertAtEnd(10);
    list.insertAtEnd(20);
    list.insertAtEnd(30);
    list.insertAtBeginning(5);
    list.insertAtEnd(40);
    list.displayForward();
    list.displayBackward();
    
    list.delete(5);
    list.displayForward();
    list.delete(20);
    list.displayForward();
    list.delete(40);
    list.displayForward();
      
  }
}

class Node{
  int data;
  Node prev;
  Node next;
  public Node(int data){
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class MyDoublelyLinkedList{
  Node head;
  //delete any key entered by user
  public void delete(int key){
    // case 1: empty list
    if(head == null){
      System.out.println("Double LL is empty !!");
      return;
    }
    Node temp = head;
    //case 2: delete head Node
    if(temp.data == key){
      head = temp.next;
      if(head!=null){
        head.prev = null;
      }
      System.out.println("Head node deleted !!");
      return;
    }
    //case 3: delete middle node
    while(temp!=null && temp.data != key){
      temp = temp.next;
    }
    if(temp == null){
      System.out.println("Key not found ")
      return;
    } 
    temp.prev.next = temp.next;
    if(temp.next != null){
      temp.next.prev = temp.prev;
    }
    System.out.println("node deleted !!");
    return;
  }
  //Insert at the beginning
  public void insertAtBeginning(int data){
    Node newnode = new Node(data);
    if(head == null){
      head = newnode;
      System.out.println("Node added at the head");
      return;
    }
    Node temp = head;
    newnode.next = temp;
    temp.prev = newnode;
    head = newnode;
    System.out.println("Node added at the beginning");
  }
  //Insert at the end 
  public void insertAtEnd(int data){
    Node newnode = new Node(data);
    if(head == null){
      head = newnode;
      System.out.println("Node added at the head");
      return;
    }
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = newnode;
    newnode.prev = temp;
    System.out.println("Node added at the end.");
  }
  //Display forward
  public void displayForward(){
    if(head == null){
      System.out.println("Double LL is empty");
      return;
    }
    Node temp = head;
    System.out.print("Forward: ");
    while(temp.next != null){
      System.out.print(temp.data+"->");
      temp = temp.next;
    }
    System.out.println(temp.data+"->"+"null");
  }
  //Display backward
  public void displayBackward(){
    if(head == null){
      System.out.println("Double LL is empty");
      return;
    }
    Node temp = head;
    System.out.print("Backward: ");
    while(temp.next != null){
      temp = temp.next;
    }
    while(temp!= null){
      System.out.print(temp.data+"<-");
      temp = temp.prev;
    }
    System.out.print("null");
  }
}

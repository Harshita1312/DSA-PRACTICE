import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      MyLinkedList list = new MyLinkedList();
      
      list.insertAtEnd(10);
      list.insertAtEnd(20);
      list.insertAtEnd(30);
      list.insertAtEnd(40);
      
      list.display();
      list.insertAtAnyPos(0,5);
      list.insertAtAnyPos(5,60);
      list.insertAtAnyPos(3,45);
      list.display();
      System.out.println();
      list.deleteAtAnyPos(0);
      list.display();
      list.deleteAtAnyPos(4);
      list.display();
      list.deleteAtAnyPos(4);
      list.display();
      list.deleteAtAnyPos(2);
      list.display();
  }
}

class Node{ 
  int data;
  Node next;
  public Node(int data){
    this.data = data;
    this.next = null;
  }
}

class MyLinkedList{
  Node head;
  
  //delete at any position
  public void deleteAtAnyPos(int index){
    if(head == null){
      System.out.println("List is empty");
      return;
    }
    if(index == 0){
      head = head.next;
      return;
    }
    Node temp = head;
    for(int i=0; i<index-1; i++){
      if(temp.next == null){
        System.out.println("index out of range");
        return;
      }
      temp = temp.next;
    }
    if(temp.next == null){
      System.out.println("index out of range");
      return;
    }
    temp.next = temp.next.next;
  }
  //insert at any position
  public void insertAtAnyPos(int index, int data){
    Node newnode = new Node(data);
    if(index == 0){
      insertAtBeginning(data);
      return;
    }
    else{
      Node temp = head;
      for(int i=0; i<index-1; i++){
        if(temp == null){
          System.out.println("Array index out of bound");
          return;
        }
        temp = temp.next;
      }
      newnode.next = temp.next;
      temp.next = newnode;
    }
  }
  //insert at the beginning
  public void insertAtBeginning(int data){
    Node newnode = new Node(data);
    newnode.next = head;
    head = newnode;
    System.out.println("Node added the beginning.");
  }
  // insert at the end
  public void insertAtEnd(int data){
    Node newnode = new Node(data);
    if(head == null){
      head = newnode;
      System.out.println("Node added successfully");
    }
    else{
      Node temp = head;
      while(temp.next != null){
        temp = temp.next;
      }
       temp.next = newnode;
       System.out.println("Node added at the end");
    }
  }
  // display
  public void display(){
    Node temp = head;
    if(temp == null){
      System.out.println("List is empty");
      return;
    }
    while(temp != null){
      System.out.print(temp.data+"->");
      temp = temp.next;
    }
    System.out.print(null+"\n");
  }
}

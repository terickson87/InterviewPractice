import java.lang.StringBuilder;

public class MyLinkedList<T> {
   private Node head;
   private Node tail;

   private class Node {
      public Node next;
      public T data;

      public Node(Node next, T data) {
         this.next = next;
         this.data = data;
      }

      public Node(T data) {
         this.next = null;
         this.data = data;
      }
   }

   public MyLinkedList() {
      this.head = null;
      this.tail = null;
   }

   public void push(T data) {
      Node newNode = new Node(data);
      if (this.head == null) {
         this.head = newNode;
         this.tail = newNode;
      } else {
         this.tail.next = newNode;
         this.tail = newNode;
      }
   }
   
   public void reverse() {
      if (this.head == null || this.head.next == null) {
         return;
      }
      
      this.tail = this.head;
      Node newCurrent = this.head;
      Node mainCurrent = this.head.next;
      newCurrent.next = null;

      while (mainCurrent != null) {
         Node temp = mainCurrent;
         mainCurrent = mainCurrent.next;
         temp.next = newCurrent;
         newCurrent = temp;
      }

      this.head = newCurrent;

   }

   public void print() {
      Node current = head;
      StringBuilder sb = new StringBuilder();
      while (current != null) {
         sb.append(current.data);
         if (current.next != null) {
            sb.append(", ");
         }
         current = current.next;
      }
      System.out.println(sb.toString());
   }
   
}
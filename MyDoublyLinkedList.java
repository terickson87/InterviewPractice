public class MyDoublyLinkedList<T> {
   private class Node<T> {
      private Node<T> next;
      private Node<T> prev;
      private T data;

      public Node() {
         this.next = null;
         this.prev = null;
         this.data = null;
      }
   
      public Node(T data) {
         this.next = null;
         this.prev = null;
         this.data = data;
      }
   
      public Node(Node<T> next, Node<T> prev, T data) {
         this.next = next;
         this.prev = prev;
         this.data = data;
      }
   }

   public void pushFront(T element) {
      return;
   }

   public void pushBack(T element) {
      return;
   }
}

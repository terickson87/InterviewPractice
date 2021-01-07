public class MyLinkedListTester {
   public static void main(String[] args) {
      MyLinkedList myLinkedList = new MyLinkedList<String>();
      myLinkedList.push("A");
      myLinkedList.push("B");
      myLinkedList.push("C");
      myLinkedList.push("D");
      myLinkedList.push("E");
      myLinkedList.print();
      myLinkedList.reverse();
      myLinkedList.print();
   }
}

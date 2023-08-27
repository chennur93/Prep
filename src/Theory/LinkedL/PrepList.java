package Theory.LinkedL;

public class PrepList {
  Node head;

  class Node{
    Node next;
    int data;

    Node(int value){
      data = value;
      next = null;
    }
  }

  public Boolean search(Node head, int value){
    if (head == null)
      return false;

    if (head.data == value)
      return true;

    return search(head.next, value);
  }

  public Boolean detectLoop(Node head){
    Node slow = head, fast = head;

    while(slow != null && fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast)
        return true;
    }
    return false;
  }

}

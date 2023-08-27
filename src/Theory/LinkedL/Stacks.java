package Theory.LinkedL;

public class Stacks {
  Node head;
  int num_elements;
  // How would it be if we tracked the latest node with another variable.

  class Node {
    Object value;
    Node next;

    Node(Object value) {
      this.value = value;
      this.next = null;
    }
  }

  public Stacks() {
    this.head = null;
    this.num_elements = 0;
  }

  public void push(Object data) {
    Node newNode =  new Node(data);
    if (head == null) {
      head = newNode;
    }else {
      newNode.next = head;
      head = newNode;
    }
    num_elements++;
  }

  public Object pop() {
    if (num_elements == 0) {
      System.out.println("Stack is empty");

      return null;
    }else {
      Object pop = head.value;
      head = head.next;
      num_elements--;

      return pop;
    }
  }

  public int size() {
    return num_elements;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public Object peak() {
    if (num_elements > 0) {
      return head.value;
    }else {
      return null;
    }
  }

}

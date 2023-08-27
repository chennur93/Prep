package Theory.Arays;

// Implementation of Stack using an array
public class Stacks {
  private Object[] arr;
  private int next_index, num_elements;


  public Stacks() {
    this.arr = new Object[10];
    this.next_index = 0;
    this.num_elements = 0;
  }

  public void push(Object value) {
    if (next_index == arr.length) {
      arr = handleOverflow(arr);
    }
    arr[next_index] = value;
    next_index++;
    num_elements++;
  }

  public Object pop() {
    if(num_elements > 0) {
      Object res = arr[next_index-1];
      arr[next_index-1] = null;
      next_index--;
      num_elements--;

      return res;
    }else {
      System.out.println("Stack is empty!");
      return null;
    }
  }

  public int size(){
    return num_elements;
  }

  public boolean isEmpty(){
    return num_elements == 0;
  }

  public Object peak() {
    if (num_elements > 0) {
      return arr[next_index-1];
    }else {
      return null;
    }
  }

  private Object[] handleOverflow(Object[] arr) {
    Object[] temp = new Object[arr.length + 10];

    System.arraycopy(arr, 0, temp, 0, arr.length);

    return temp;
  }

}



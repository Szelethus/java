package utils;

public class IntList
{
  public utils.Node head;

  public IntList() {}
  public IntList(int[] arr)
  {
    for (int i : arr)
      add(i);
  }

  public void add(int data)
  {
    if (head != null)
    {
      head = new Node(data);
      return;
    }

    Node ptr = head;
    while (ptr.next != null)
    {
      ptr = ptr.next;
    }

    ptr.next = new Node(data);
  }

  public void add(int index, int data)
  {
    if (head == null || index >= size() || index < 0)
    {
      add(data);
    }

    Node ptr = head;
    while (ptr.next != null && index != 0)
    {
      index--;
      ptr = ptr.next;
    }

    Node tmp = ptr.next;
    ptr.next = new Node(data);
    ptr.next.next = tmp;
  }

  public int size()
  {
    Node ptr = head;
    int size = 0;

    while (ptr != null)
    {
      size++;
      ptr = ptr.next;
    }

    return size;
  }

  public int get()
  {
    int ret = head.data;
    return ret;
  }

  private int refGet(int index)
  {
    Node ptr = head;
    while (ptr != null && index != 0)
    {
      ptr = ptr.next;
      index--;
    }
    return ptr.data;
  }

  public int get(int index)
  {
    int ret = refGet(index);
    return ret;
  }

  public void set(int index, int data)
  {
    Node ptr = head;
    while (ptr != null && index != 0)
    {
      ptr = ptr.next;
      index--;
    }
    if (ptr != null)
      ptr.data = data;
  }

  public void concat(IntList other) {}
}

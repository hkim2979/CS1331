public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }
    public Node<T> getTail() {
        return tail;
    }

    //aa

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        Node<T> newNode = new Node(data);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if(isEmpty())
                tail = head;
        } else if (index == size) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    public T getAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        Node<T> removed = null;
        if (index == 0) {
            removed = head;
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            removed = current.getNext();
            if(index==size-1){
                tail = current;
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removed.getData();
    }

    public T remove(T data) {
        if (data==null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> removed = null;
        if (head.getData().equals(data)) {
            removed = head;
            head = head.getNext();
        } else {
            Node<T> current = head;
            Node<T> previous= head;
            for (int i = 0; i < size; i++) {
                if(current.getData().equals(data)){
                    previous.setNext(current.getNext());
                    if(i==size-1){
                        tail = previous;
                    }
                    break;
                }
                current = current.getNext();
            }
            removed = current;
        }
        size--;
        return removed.getData();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }
}
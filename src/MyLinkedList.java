public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node prev;
        Node next;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    @Override
    public void add(T item) {
        add(item, size);
    }
    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item, null, null);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node curr = getNode(index);
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev.next = newNode;
            curr.prev = newNode;
        }
        size++;
    }
    @Override
    public boolean remove(T item) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(item)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T element = current.element;
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public T get(int index) {
        return getNode(index).element;
    }
    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node curr = head;
        while (curr != null) {
            if (o == null ? curr.element == null : o.equals(curr.element)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node curr = tail;
        while (curr != null) {
            if (o == null ? curr.element == null : o.equals(curr.element)) {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2) {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        } else {
            Node curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
            return curr;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            sb.append(node.element.toString());
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

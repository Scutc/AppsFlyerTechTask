import java.util.HashMap;
import java.util.Map;

public class BufferImpl implements IBuffer {
    final private Integer limit;
    private Integer size;
    final private Map<Integer, Node> buffer;
    private Node first;
    private Node last;

    public BufferImpl(Integer limit) {
        this.limit = limit;
        size = 0;
        buffer = new HashMap<>();
    }

    @Override
    public void addElement(Integer key, String value) {
        if (size == 0) {
            addZero(key, value);
            return;
        }
        if (!buffer.containsKey(key)) {
            if (size.equals(limit)) {
                removeLast();
            }
            addFirst(key, value);
        } else {
            Node elem = buffer.get(key);
            if (elem == first) {
                buffer.put(key, elem);
            } else if (elem == last) {
                removeLast();
                addFirst(key, value);
            } else {
                removeElement(elem);
                addFirst(key, value);
            }
        }
    }

    private void addZero(Integer key, String value) {
        Node tmp = new Node();
        tmp.value = value;
        tmp.key = key;
        first = tmp;
        last = tmp;
        buffer.put(key, tmp);
        size++;
    }

    private void addFirst(Integer key, String value) {
        Node node = new Node();
        node.value = value;
        node.key = key;
        Node temp = first;
        first = node;
        first.next = temp;
        temp.prev = first;
        buffer.put(key, node);
        if (size == 1) {
            last = temp;
            last.prev = first;
        }
        size++;
    }

    private void removeLast() {
        Node tmp = last.prev;
        buffer.remove(last.key);
        tmp.next = null;
        last = tmp;
        size--;
    }

    private void removeElement(Node element) {
        Node tmp = element.next;
        element.prev.next = tmp;
        tmp.prev = element.prev;
        size--;
    }


    @Override
    public String getElement(Integer key) {
        Node elem = buffer.get(key);
        addElement(key, elem.value);
        return elem.value;
    }

    @Override
    public void printBuffer() {
        Node search = first;
        while (search != null) {
            System.out.println(search.key + " -> " + search.value);
            search = search.next;
        }
    }

    private class Node {
        String value;
        Integer key;
        Node next;
        Node prev;
    }
}

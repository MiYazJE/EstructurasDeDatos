/**
 * @author Rubén Saiz
 */
package HashTable;

public class Node<K, V> {

    private Node<K, V> next;
    private K key;
    private V val;

    protected Node(K k, V v) {
        this.key = k;
        this.val = v;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public K getKey() {
        return this.key;
    }

    public V getVal() {
        return this.val;
    }

    public Node<K, V> getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

/**
 * @author Rubén Saiz
 */
package HashTable;

import java.util.ArrayList;

public class HashTable<K, V> {

    private int length;
    private ArrayList<Node<K, V>> table;

    public HashTable() {
        this.length = 10;
        table = new ArrayList<>(length);
        initTable();
    }

    private void initTable() {
        for (int i = 0; i < length; i++)
            table.add(null);
    }

    public void put(K key, V value) {
        int index = hash(key);
        put(index, key, value);
    }

    private int hash(K key) {
        return (int)key % length;
    }

    private void put(int index, K key, V value) {

        Node newNode = new Node(key, value);
        Node node = table.get(index);

        if (node == null) {
            node = newNode;
            this.table.set(index, node);
        }
        else {
            while (node != null) {
                if (node.getKey().equals(key)) {
                    replaceValueNode(node, value);
                    return;
                }
                if (node.getNext() == null) break;
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    private void replaceValueNode(Node node, V value) {
        node.setVal(value);
    }

    public V getValue(K key) {
        int index = hash(key);
        return getValue(index, key);
    }

    private V getValue(int index, K key) {
        Node node = table.get(index);
        V valor = (node != null) ? (V) node.getVal() : null;
        while (node != null && !node.getKey().equals(key)) {
            node = node.getNext();
            valor = node != null ? (V) node.getVal() : null;
        }
        return valor;
    }

    public boolean containsKey(K key) {
        Node node = table.get(hash(key));
        while (node != null) {
            if (node.getKey().equals(key))
                return true;
            node = node.getNext();
        }
        return false;
    }

    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(i + "[");
            Node node = table.get(i);
            while (node != null) {
                sb.append();
            }
            sb.append()
        }
    }
    */
}

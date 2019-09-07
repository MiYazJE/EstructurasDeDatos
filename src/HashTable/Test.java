/**
 * @author Rubén Saiz
 */
package HashTable;

public class Test {

    public static void main(String[] args) {

        HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();

        hashTable.put(2, 5);
        hashTable.put(4, 1);
        hashTable.put(12, 6);

        System.out.println(hashTable.getValue(12));
        hashTable.put(12, 7);
        System.out.println(hashTable.getValue(12));

    }

}

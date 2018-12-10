public class HashTable {

    public static final int DOUBLE_HASH_FUNC_CONST = 5;
    private Person[] values;
    private int size;

    public HashTable(int maxSize) {
        this.values = new Person[maxSize * 2];
        this.size = 0;
    }

    public boolean add(Person person) {
        int key = person.hashCode();
        int index = hashFunc(key);

        int count = 0;
        while (values[index] != null) {
            index = index + getStep(key);
            index %= values.length;

            count++;

            if (count >= values.length) {
                return false;
            }
        }


        values[index] = person;
        size++;
        return true;
    }

    private int getStep(int key) {
//        return 1;
        return hashFuncDouble(key);
    }

    public Person delete(int id) {
        int key = id;
        int index = hashFunc(key);

        int count = 0;
        while (values[index] != null) {
            if (values[index].getId() == id) {
                Person deletedValue = values[index];
                values[index] = null;
                return deletedValue;
            }

            index = index + getStep(key);
            index %= values.length;

            count++;

            if (count >= values.length) {
                return null;
            }
        }

        return null;
    }

    public Person find(int id) {
        int key = id;
        int index = hashFunc(key);

        int count = 0;
        while (values[index] != null) {
            if (values[index].getId() == id) {
                return values[index];
            }

            index = index + getStep(key);
            index %= values.length;

            count++;

            if (count >= values.length) {
                return null;
            }
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + ": " + values[i]);
        }
    }

    private int hashFunc(int key) {
        return key % values.length;
    }

    private int hashFuncDouble(int key) {
        return DOUBLE_HASH_FUNC_CONST - key % DOUBLE_HASH_FUNC_CONST;
    }
}

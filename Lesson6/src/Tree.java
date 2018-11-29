public interface Tree {

    void add(Person data);

    Person remove(int id);

    Person find(int id);

    void traverse(TraverseMode mode);

    void displayTree();
}

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return size(x.getLeft()) + 1 + size(x.getRight());
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if (n == null) {
            return new Node<Key, Value>(key, val, 1);
        }

        int cmp = key.compareTo(n.getKey());

        if (cmp < 0) {
            n.setLeft(put(n.getLeft(), key, val));
        } else if (cmp > 0) {
            n.setRight(put(n.getRight(), key, val));
        } else {
            n.setValue(val);
        }

        n.setSize(size(n.getLeft()) + 1 + size(n.getRight()));

        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.getKey());

        if (cmp < 0) {
            return get(n.getLeft(), key);
        } else if (cmp > 0) {
            return get(n.getRight(), key);
        } else {
            return n.getValue();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value remove(Key key) {
        Value temp = get(key);
        root = remove(root, key);
        return temp;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.getKey());

        if (cmp < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (cmp > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) {
                return n.getLeft();
            }
            if (n.getLeft() == null) {
                return n.getRight();
            }
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }

        n.setSize(size(n.getLeft()) + 1 + size(n.getRight()));
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return min(n.getLeft());
        }
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if (n.getRight() == null) {
            return n;
        } else {
            return max(n.getRight());
        }
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());
    }
}
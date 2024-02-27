/**
 * BinarySearchTreeDriver.java
 * Authors: Luke O’Drobinak
 * Date: 2/26/2024
 * Collaborators: N/A
 * Citations: Oracle Java Documentation, Wikipedia.com, Stack Overflow
 **/
public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        //put some values in the tree
        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(2, "two");
        bst.put(4, "four");
        bst.put(6, "six");
        bst.put(8, "eight");

        //prints the values in the tree
        System.out.println(bst.get(5));
        System.out.println(bst.get(3));
        System.out.println(bst.get(7));
        System.out.println(bst.get(2));
        System.out.println(bst.get(4));
        System.out.println(bst.get(6));
        System.out.println(bst.get(8));

        //prints the check if the tree contains the values
        System.out.println(bst.contains(5));
        System.out.println(bst.contains(3));
        System.out.println(bst.contains(7));
        System.out.println(bst.contains(2));
        System.out.println(bst.contains(4));
        System.out.println(bst.contains(6));
        System.out.println(bst.contains(8));

        //removes the values from the tree
        System.out.println(bst.remove(5));
        System.out.println(bst.remove(3));
        System.out.println(bst.remove(7));
        System.out.println(bst.remove(2));
        System.out.println(bst.remove(4));
        System.out.println(bst.remove(6));
        System.out.println(bst.remove(8));

        //checks the get and contains methods after removing the values
        System.out.println(bst.get(5));
        System.out.println(bst.get(3));
        System.out.println(bst.get(7));
        System.out.println(bst.get(2));
        System.out.println(bst.get(4));
        System.out.println(bst.get(6));
        System.out.println(bst.get(8));
        System.out.println(bst.contains(5));
        System.out.println(bst.contains(3));
        System.out.println(bst.contains(7));
        System.out.println(bst.contains(2));
        System.out.println(bst.contains(4));
        System.out.println(bst.contains(6));
        System.out.println(bst.contains(8));
    }
}

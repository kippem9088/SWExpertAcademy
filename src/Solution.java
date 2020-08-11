import java.util.Scanner;

public class Solution {

    public static class LinkedList<Item> {
        public class Node<Item> {
            Item item;
            Node next;

            public Node(Item item, Node next) {
                this.item = item;
                this.next = next;
            }
        }

        private Node first;
        private Node last;

        private Node find(int position) {
            if (position == 0) {
                return null;
            }

            Node foundNode = first;

            for (int i = 1; i < position; i++) {
                foundNode = foundNode.next;

                if (foundNode == null) {
                    throw new IllegalArgumentException();
                }
            }

            return foundNode;
        }

        private Node insert(Node node, Item item) {
            Node insertedNode;

            if (node == null) {
                insertedNode = new Node(item, first);
                first = insertedNode;
            }
            else {
                insertedNode = new Node(item, node.next);
                node.next = insertedNode;
            }

            return insertedNode;
        }

        private void deleteNext(Node node) {
            if (node == null) {
                first = first.next;
            }
            else {
                node.next = node.next.next;
            }
        }

        public void push(Item item) {
            if (first == null) {
                first = new Node(item, null);
                last = first;
            }
            else {
                Node oldLast = last;
                last = new Node(item, null);
                oldLast.next = last;
            }
        }

        public void insert(int position, Item[] items) {
            Node currentNode = find(position);

            for (int i = 0; i < items.length; i++) {
                currentNode = insert(currentNode, items[i]);
            }
        }

        public void delete(int position, int number) {
            Node currentNode = find(position);

            for (int i = 0; i < number; i++) {
                deleteNext(currentNode);
            }
        }

        public void print(int number) {
            Node currentNode = first;

            for (int i = 0; i < number; i++) {
                System.out.print(currentNode.item.toString() + " ");
                currentNode = currentNode.next;
            }
        }

        public LinkedList() {
            first = null;
            last = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case;
        for (test_case = 1; test_case <= 10; test_case++) {
            LinkedList<Integer> secretCodes = new LinkedList<>();

            int N = sc.nextInt();

            for (int n = 0; n < N; n++) {
                secretCodes.push(sc.nextInt());
            }

            int numOfCommands = sc.nextInt();

            for (int i = 0; i < numOfCommands; i++) {
                String command = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (command.equals("I")) {
                    Integer[] numbersToInsert = new Integer[y];
                    for (int j = 0; j < y; j++) {
                        numbersToInsert[j] = sc.nextInt();
                    }
                    secretCodes.insert(x, numbersToInsert);
                }
                else if (command.equals("D")) {
                    secretCodes.delete(x, y);
                }
            }

            System.out.print(String.format("#%d ", test_case));
            secretCodes.print(10);
            System.out.print("\n");
        }
    }
}

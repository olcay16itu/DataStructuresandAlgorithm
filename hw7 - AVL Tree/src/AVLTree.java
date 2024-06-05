import static java.lang.Math.max;

/**
 * The AVLTree class represents an AVL (Adelson-Velsky and Landis) tree, a self-balancing binary search tree.
 * It maintains the balance factor of each node to ensure that the tree remains balanced.
 */
public class AVLTree {
    private class Node {
        Stock stock;
        Node left, right;
        int height;

        /**
         * Constructs a node with the specified stock.
         *
         * @param stock the stock to be stored in the node
         */
        Node(Stock stock) {
            this.stock = stock;
            this.height = 1;
        }
    }

    private Node root;

    /**
     * Inserts a stock into the AVL tree.
     *
     * @param stock the stock to be inserted
     */
    public void insert(Stock stock) {
        root = insert(root, stock);
    }

    private Node insert(Node node, Stock stock) {
        // Perform normal BST insertion
        if (node == null)
            return (new Node(stock));

        if (stock.getSymbol().compareTo(node.stock.getSymbol()) < 0)
            node.left = insert(node.left, stock);
        else if (stock.getSymbol().compareTo(node.stock.getSymbol()) > 0)
            node.right = insert(node.right, stock);

        return balance(node);
    }

    /**
     * Deletes a stock from the AVL tree based on its symbol.
     *
     * @param symbol the symbol of the stock to be deleted
     */
    public void delete(String symbol) {
        root = deleteNode(root, symbol);
    }

    Node minKeyNode(Node node) {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current.left != null)
            current = current.left;

        return current;
    }

    private Node deleteNode(Node node, String symbol) {
        if (node == null)
            return node;

        if (symbol.compareTo(node.stock.getSymbol()) < 0)
            node.left = deleteNode(node.left, symbol);
        else if (symbol.compareTo(node.stock.getSymbol()) > 0)
            node.right = deleteNode(node.right, symbol);
        else {
            if (node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = minKeyNode(node.right);
                node.stock = temp.stock;
                node.right = deleteNode(node.right, temp.stock.getSymbol());
            }
        }

        if (node == null)
            return node;

        return balance(node);
    }

    /**
     * Searches for a stock in the AVL tree based on its symbol.
     *
     * @param symbol the symbol of the stock to be searched
     * @return the stock if found, otherwise null
     */
    public Stock search(String symbol) {
        Node result = search(root, symbol);
        return (result != null) ? result.stock : null;
    }

    private Node search(Node node, String symbol) {
        if (node == null) {
            return null;  // Base case: not found
        }
        if (node.stock.getSymbol().equals(symbol)) {
            return node;  // Base case: found
        }
        if (symbol.compareTo(node.stock.getSymbol()) < 0) {
            return search(node.left, symbol);  // Search in the left subtree
        } else {
            return search(node.right, symbol);  // Search in the right subtree
        }
    }

    // Balancing methods (left rotation, right rotation, etc.)
    // Height update and balance factor calculations

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private Node balance(Node node) {
        updateHeight(node);

        int balance = getBalance(node);

        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // In-order traversal
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.stock);
            inOrderTraversal(node.right);
        }
    }
}

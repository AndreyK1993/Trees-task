package binary_search_tree;

public class BinarySearchTree {

    private TreeNode root;

    // Конструктор для создания пустого бинарного дерева поиска
    BinarySearchTree() {
        root = null;
    }

    // Метод для вставки ключа в дерево
    void insert(int key) {
        root = insertKey(root, key);
    }

    // Метод для неупорядоченного обхода дерева
    void inorder() {
        inorderRec(root);
    }

    // Метод для удаления ключа из дерева
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Метод для поиска минимального значения в поддереве
    int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Метод для предупорядоченного обхода дерева
    void preorder() {
        preorderRec(root);
    }

    // Метод для поступорядоченного обхода дерева
    void postorder() {
        postorderRec(root);
    }

    // Приватный метод для вставки ключа в поддерево с корнем root
    private TreeNode insertKey(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    // Приватный метод для неупорядоченного обхода поддерева с корнем root
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Приватный метод для удаления ключа из поддерева с корнем root
    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Приватный метод для предупорядоченного обхода поддерева с корнем root
    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Приватный метод для поступорядоченного обхода поддерева с корнем root
    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Точка входа для демонстрации работы дерева
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = {8, 3, 1, 6, 7, 10, 14, 4, 9, 13, 11, 12};

        for (int key : keys) {
            tree.insert(key);
        }

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\nPreorder traversal: ");
        tree.preorder();

        System.out.println("\nPostorder traversal: ");
        tree.postorder();
    }
}

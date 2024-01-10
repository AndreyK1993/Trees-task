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
        // Если поддерево пустое, создаем новый узел
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        // Рекурсивно вставляем ключ в правое или левое поддерево
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    // Приватный метод для неупорядоченного обхода поддерева с корнем root
    private void inorderRec(TreeNode root) {
        if (root != null) {
            // Рекурсивно обходим левое поддерево
            inorderRec(root.left);
            // Выводим значение текущего узла
            System.out.print(root.key + " ");
            // Рекурсивно обходим правое поддерево
            inorderRec(root.right);
        }
    }

    // Приватный метод для предупорядоченного обхода поддерева с корнем root
    private void preorderRec(TreeNode root) {
        if (root != null) {
            // Выводим значение текущего узла
            System.out.print(root.key + " ");
            // Рекурсивно обходим левое поддерево
            preorderRec(root.left);
            // Рекурсивно обходим правое поддерево
            preorderRec(root.right);
        }
    }

    // Приватный метод для поступорядоченного обхода поддерева с корнем root
    private void postorderRec(TreeNode root) {
        if (root != null) {
            // Рекурсивно обходим левое поддерево
            postorderRec(root.left);
            // Рекурсивно обходим правое поддерево
            postorderRec(root.right);
            // Выводим значение текущего узла
            System.out.print(root.key + " ");
        }
    }

    // Приватный метод для поиска минимального значения в поддереве с корнем root
    private int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Публичный метод для вызова minValue извне класса
    public int minValue() {
        return minValue(root);
    }

    // Точка входа для демонстрации работы дерева
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = {8, 3, 1, 6, 7, 10, 14, 4, 9, 13, 11, 12};

        // Вставляем ключи в дерево
        for (int key : keys) {
            tree.insert(key);
        }

        // Выводим результаты трех видов обхода дерева
        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\nPreorder traversal: ");
        tree.preorder();

        System.out.println("\nPostorder traversal: ");
        tree.postorder();

        // Выводим минимальное значение в дереве
        System.out.println("\nMinimum value: " + tree.minValue());
    }
}

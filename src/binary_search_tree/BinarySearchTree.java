package binary_search_tree;

public class BinarySearchTree {

    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    // Вставляємо ключ/вузол в дерево
    TreeNode insertKey(TreeNode root, int key) {
        // Повертаємо новий вузол, якщо дерево порожнє
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        // Переходимо в потрібне місце та вставляємо вузол
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    // Неупорядкований обхід
    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    TreeNode deleteRec(TreeNode root, int key) {
        // Повернення, якщо дерево порожнє
        if (root == null)
            return root;

        // Знаходимо вузол, який потрібно видалити
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Якщо вузол тільки з одним нащадком
            // або без нащадка
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Якщо вузол має двох нащадків,
            // переміщуємо наступника за порядком
            // в позицію видаляємого вузла
            root.key = minValue(root.right);

            // Видаляємо наступника за порядком
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Знаходимо наступника за порядком
    int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void preorder() {
        preorderRec(root);
    }

    // Предупорядкованный обход
    void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    // Поступорядкованный обход
    void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

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

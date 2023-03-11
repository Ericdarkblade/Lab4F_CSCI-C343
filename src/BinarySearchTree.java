public class BinarySearchTree {

    private int size;
    private BinaryTreeNode root;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     *
     * @param data The integer to be inserted
     */
    public void insert(int data) {
        if (this.root == null) {
            this.root = new BinaryTreeNode(data, null, null, null);
        } else {
            insert(data, root);
        }
    }

    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     *
     * @param insertData The integer to be inserted
     * @param parentNode The current Node in the traversal
     */
    private void insert(int insertData, BinaryTreeNode parentNode) {
        int parentData = parentNode.getItem();
        BinaryTreeNode leftChildNode = parentNode.getLeft();
        BinaryTreeNode rightChildNode = parentNode.getRight();


        enum pathCheck {goRightChild, goLeftChild, setRightChild, setLeftChild}
        pathCheck nextChildPath = insertData > parentData ? pathCheck.goRightChild : pathCheck.goLeftChild;

        //Checks if left or right child is null and updates case
        switch (nextChildPath) {
            case goLeftChild -> nextChildPath = leftChildNode == null ? pathCheck.setLeftChild : nextChildPath;
            case goRightChild -> nextChildPath = rightChildNode == null ? pathCheck.setRightChild : nextChildPath;
        }


        switch (nextChildPath) {
            case goLeftChild -> insert(insertData, leftChildNode);
            case setLeftChild -> {
                BinaryTreeNode insertNode = new BinaryTreeNode(insertData, parentNode, null, null);
                parentNode.setLeft(insertNode);
            }

            case goRightChild -> insert(insertData, rightChildNode);
            case setRightChild -> {
                BinaryTreeNode insertNode = new BinaryTreeNode(insertData, parentNode, null, null);
                parentNode.setRight(insertNode);
            }
        }
    }

    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the minimum
     * value in the right child of the node. If the data is not present, returns null.
     *
     * @param data The integer to be removed
     * @return The Node containing the integer to remove or null if one is not found
     */
    public BinaryTreeNode remove(int data) {
        if (this.root == null) {
            return null;
        } else {
            return remove(data, root);
        }
    }


    /**     ----------------PLEASE READ----------------
     *  The comment instructions are incredibly unclear
     *  so I'm going to impmlement the following procedure
     *
     *  if removing leftChild will replace with leftGrandChild
     *  if removing rightChild will replace with rightGrandChild
     *
     *
     *      ----------------PLEASE READ----------------
     */


    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the maximum
     * value in the left child of the node. If the data is not present, returns null.
     *
     * @param removeDataTarget The integer to be removed
     * @param parentNode       The current Node in the traversal
     * @return The Node containing the integer to remove or null if one is not found
     */
    private BinaryTreeNode remove(int removeDataTarget, BinaryTreeNode parentNode) {
        int parentData = parentNode.getItem();
        BinaryTreeNode leftChildNode = parentNode.getLeft();
        BinaryTreeNode rightChildNode = parentNode.getRight();
        enum pathCheck {goRightChild, goLeftChild, removeRightChild, removeLeftChild}

        pathCheck nextChildPath = removeDataTarget > parentData ? pathCheck.goRightChild : pathCheck.goLeftChild;

        //Checks if left or right child is null and updates case
        switch (nextChildPath) {
            case goLeftChild -> {
                if (leftChildNode == null || leftChildNode.getItem() == removeDataTarget) {
                    nextChildPath = pathCheck.removeLeftChild;
                }
            }
            case goRightChild -> {
                if (rightChildNode == null || rightChildNode.getItem() == removeDataTarget) {
                    nextChildPath = pathCheck.removeRightChild;
                }
            }
        }


        switch (nextChildPath) {
            case goLeftChild -> {
                return remove(removeDataTarget, leftChildNode);
            }
            case removeLeftChild -> {
                BinaryTreeNode leftGrandChild = leftChildNode.getLeft();
                parentNode.setLeft(leftGrandChild);
                return leftChildNode;
            }

            case goRightChild -> {
                return remove(removeDataTarget, rightChildNode);
            }
            case removeRightChild -> {
                BinaryTreeNode rightGrandChild = rightChildNode.getRight();
                parentNode.setRight(rightGrandChild);
                return rightChildNode;
            }
            default -> {
                return null; //I don't know if we ever get here? I'm pretty sure null should be returned if leftChild is null
            }
        }

    }

    /**
     * A recursive method that starts at the left child of a parent and extracts the maximum from this child's tree.
     *
     * @param curNode The current Node in the traversal
     * @return The minimum Node in the child's tree
     */
    private BinaryTreeNode extractLeftMax(BinaryTreeNode curNode) {
        return curNode.getRight() == null ? curNode : extractLeftMax(curNode.getRight());
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     *
     * @param data The integer to search for
     * @return A Node containing the given integer or null if one is not found
     */
    public BinaryTreeNode search(int data) {
        // TODO
        return null;
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     *
     * @param data    The integer to search for
     * @param curNode The current Node in the traversal
     * @return A Node containing the given integer or null if one is not found
     */
    private BinaryTreeNode search(int data, BinaryTreeNode curNode) {
        // TODO
        return null;
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    public String getPreOrderStr() {
        // TODO
        return null;
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    private String getPreOrderStr(BinaryTreeNode curNode) {
        // TODO
        return null;
    }

    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    public String getInOrderStr() {
        // TODO
        return null;
    }

    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    private String getInOrderStr(BinaryTreeNode curNode) {
        // TODO
        return null;
    }

    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    public String getPostOrderStr() {
        // TODO
        return null;
    }

    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     *
     * @return A String representation of the traversal
     */
    private String getPostOrderStr(BinaryTreeNode curNode) {
        // TODO
        return null;
    }
}

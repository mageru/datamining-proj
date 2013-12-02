package com.algorithms.eclat;


class ITSearchTree {
    // the root node
    private ITNode root;

    /**
     * Default constructor.
     */
    public ITSearchTree() {

    }

    /**
     * Set the root node of the tree as a given node.
     *
     * @param root the given node
     */
    public void setRoot(ITNode root) {
        this.root = root;
    }

    /**
     * Get the root node of the tree.
     *
     * @return an ITNode.
     */
    public ITNode getRoot() {
        return root;
    }

}

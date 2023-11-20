package org.example;

public class BSTNode {

    int key;
    String value;
    BSTNode left = null;
    BSTNode right = null;

    BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public BSTNode() {

    }


    void insert(BSTNode node, int key, String value) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new BSTNode(key, value);
            } else {
                insert(node.left, key, value);
            }
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new BSTNode(key, value);
            } else {
                insert(node.right, key, value);
            }
        }
        else {
            node.value = value;
        }
    }

    BSTNode search(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        }
        return (key < node.key) ? search(node.left, key) : search(node.right, key);
    }

    BSTNode getMin(BSTNode node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return getMax(node.left);
    }

    BSTNode getMax(BSTNode node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return getMax(node.right);
    }


    BSTNode delete(BSTNode node, int key) {
        if (node == null) return null;
        else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                BSTNode maxInLeft = getMax(node.left);
                node.key = maxInLeft.key;
                node.value = maxInLeft.value;
                node.left = delete(node.left, maxInLeft.key);
            }
        }
        return node;
    }


    int inorder(BSTNode node) {
        int knotsQuantity = 0;
        if (node != null) {
            knotsQuantity += 1;
            knotsQuantity += inorder(node.left);
            //System.out.println(node.key + " " + node.value);
            knotsQuantity += inorder(node.right);
        }
        return knotsQuantity;
    }

}


package org.example;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Main {
    public static void main(String[] args) {
        createMap();
        createTree();
        searchElements();
        differentOperations();
        deleting();
    }
    static LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
    @Test
    public static void createMap() {
        final int N = 7;
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int key = rand.nextInt(N, N + 20);
            while (map.containsKey(key)) {
                key = rand.nextInt(N,N + 20);
            }
            map.put(key, "Value" + rand.nextInt(100));
        }

        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
         assertEquals(map.size(), 20);
    }
    @Test
    public static void createTree(){
        BSTNode root = new BSTNode();
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            root.insert(root, entry.getKey(), entry.getValue());
        }
        root = root.delete(root, 0);
        System.out.println("(Test 2)Element quant."+root.inorder(root));
        assertEquals(root.inorder(root), 20);
    }
    @Test
    public static void searchElements(){
        BSTNode root1 = new BSTNode();
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            root1.insert(root1, entry.getKey(), entry.getValue());
        }
        root1 = root1.delete(root1, 0);

        System.out.println("(Test 3)Element with key 15: "+root1.search(root1, 15).value);
        System.out.println("(Test 3)Element with key 9: "+root1.search(root1, 9).value);
        BSTNode node = root1.search(root1, 43);
        System.out.println("(Test 3)Element with key 43: " + (node == null ? "does not exist" : node.value));
        assertNull(node);
    }
    @Test
    public static void differentOperations(){
        BSTNode root2 = new BSTNode();
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            root2.insert(root2, entry.getKey(), entry.getValue());
        }
        root2 = root2.delete(root2, 0);

        root2.delete(root2, 18);
        root2.insert(root2, 18, "New Value");
        System.out.println("(Test 4)Element with key 18: "+root2.search(root2, 18).value);

        root2.insert(root2, 11, "New Value 2");

        System.out.println("(Test 4)" + root2.search(root2, 11).value);

        System.out.println("(Test 4) Elements quant." + root2.inorder(root2));

        assertEquals(root2.inorder(root2), 20);
    }
    @Test
    public static void deleting(){
        BSTNode root3 = new BSTNode();
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            root3.insert(root3, entry.getKey(), entry.getValue());
        }
        root3 = root3.delete(root3, 0);

        root3.delete(root3, 12);
        System.out.println("Elements quant. "+root3.inorder(root3));

        BSTNode node = root3.search(root3, 12);
        System.out.println("Element with key 12: " + (node == null ? "does not exist" : node.value));
        assertEquals(root3.inorder(root3), 19);
    }

}
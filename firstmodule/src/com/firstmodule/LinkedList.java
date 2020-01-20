package com.firstmodule;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

public class LinkedList {
    static Node head = null;

    @Data
    @RequiredArgsConstructor
    static class Node {
        private final int value;
        private Node next;

    }

    public static void main(String[] args) {
        int choice = -1;
        while (true) {
            System.out.println("[1] Add to Linked list");
            System.out.println("[2] View List elements");
            System.out.println("[3] Exit");
            System.out.println("Enter your choice:");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter value:");
                    int value = new Scanner(System.in).nextInt();
                    Node node = new Node(value);
                    if (head == null) {//First element
                        head = node;
                    } else {//At as next or last element in the linkedlist
                        node.next = head;
                        head = node;
                    }
                    break;
                case 2:
                    for (Node i = head; i != null; i = i.next) {
                        System.out.println(String.format("Element value: %s", i.value));
                    }
                    break;
                case 3: System.exit(1);
                default: System.err.println("Invalid choice");
            }
        }
    }
}

package com.firstmodule;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

public class DoublyLinkedList {
    static Node head = null;
    static Node tail = null;

    @Data
    @RequiredArgsConstructor
    static class Node {
        private final int value;
        private Node next;
        private Node prev;
    }

    public static void main(String[] args) {
        int choice = -1;
        while (true) {
            System.out.println("[1] Add to start of the Linked list");
            System.out.println("[2] Add to end of the Linked list");
            System.out.println("[3] View List elements (start->end)");
            System.out.println("[4] View List elements (end->start)");
            System.out.println("[5] Exit");
            System.out.println("Enter your choice:");
            choice = new Scanner(System.in).nextInt();
            int value = -1;
            Node node = null;
            switch (choice) {
                case 1:
                    System.out.println("Enter value (will be added at the start):");
                    value = new Scanner(System.in).nextInt();
                    node = new Node(value);
                    if (head == null) {//First element
                        head = tail = node;
                    } else {//At as next or last element in the linkedlist
                        head.prev = node;
                        head.prev.next = head;
                        head = node;
                    }
                    break;
                case 2:
                    System.out.println("Enter value (will be added at the end):");
                    value = new Scanner(System.in).nextInt();
                    node = new Node(value);
                    if (head == null) {//First element
                        head = tail = node;
                    } else {//At as next or last element in the linkedlist
                        tail.next = node;
                        tail.next.prev = tail;
                        tail = node;
                    }
                    break;
                case 3:
                    System.out.println("Printing list in forward order:\n");
                    for (Node i = head; i != null; i = i.next) {
                        System.out.println(String.format("Element value: %s", i.value));
                    }
                    break;
                case 4:
                    System.out.println("Printing list in reverse order:\n");
                    for (Node i = tail; i != null; i = i.prev) {
                        System.out.println(String.format("Element value: %s", i.value));
                    }
                    break;
                case 5: System.exit(1);
                default: System.err.println("Invalid choice");
            }
        }
    }
}

package com.bridgelabz.DSAproblems;

import java.util.Scanner;

class Node1{
    int data ;
    Node1 next;

    public Node1() {
    }

    public Node1(int data) {
        this.data = data;
    }

    public Node1(Node1 next) {
        this.next = next;
    }
}

class LinkedList1 {
    Node1 head;
    Node1 tail;

    public Node1 search(int data) {
        Node1 temp = head;
        if (head == null) {
            return null ;
        }
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void append(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node1 temp = head;
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }
    }

    public Boolean delete(int data) {
        Node1 deleteNode = search(data);
        Node1 temp = head;
        Node1 node1 = new Node1();
        while (temp != null) {
            if (temp.next.equals(deleteNode)) {
                temp.next = deleteNode.next;
                deleteNode.next = null;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void add(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void sortList() {
        Node1 current = head;
        Node1 index = null;
        int temp;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}

public class OrderedList {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList1 linkedList11 = new LinkedList1();

        linkedList11.add(29);
        linkedList11.add(21);
        linkedList11.add(34);
        linkedList11.add(18);

        System.out.println("Original list: ");
        linkedList11.display();
        System.out.println();

        System.out.println("Ordered List : ");
        linkedList11.sortList();
        linkedList11.display();
        System.out.println();

        System.out.println("Enter number want to search : ");
        int number = input.nextInt();
        if(linkedList11.search(number) != null){
                linkedList11.delete(number);
                linkedList11.display();
        }
        else {
                linkedList11.add(number);
                linkedList11.sortList();
                linkedList11.display();
        }

    }
}

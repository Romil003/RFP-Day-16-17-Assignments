package com.bridgelabz.DSAproblems;

import java.util.Scanner;

class Node<E>{
        private E data ;
        private Node<E> next;
        public Node() {
        }
        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    class LinkedList<E> {
        Node<E> head;
        Node<E> tail;

        public Node search(E key) {
            Node<E> temp = head;
            if (head == null) {
                return null;
            }
            while (temp != null) {
                if (temp.getData().equals(key)) {
                    return temp;
                }
                temp = temp.getNext();
            }
            return null;
        }

        public void append(E data) {
            Node<E> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }

        public void display() {
            Node<E> temp = head;
            if (head == null) {
                System.out.println("Linked List is empty");
            }
            while (temp != null) {
                System.out.print(temp.getData() + " , ");
                temp = temp.getNext();
            }
        }

        public Boolean deletion(E deleteData) {
            Node<E> deleteNode = search(deleteData);
            Node<E> temp = head;
            Node<E> node1 = new Node<>();
            while (temp != null) {
                if (temp.getNext().equals(deleteNode)) {
                    temp.setNext(deleteNode.getNext());
                    deleteNode.setNext(null);
                    return true;
                }
                temp = temp.getNext();
            }
            return false;
        }

        public void add(E data) {
            Node<E> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
        }
    }

    public class UnorderList2 {
        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String[] array;
            LinkedList<String> linkedList = new LinkedList<>();
            String para = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
            array = para.split(" ");
            for (String str : array) {
                linkedList.add(str);
            }
            System.out.println("Enter word : ");
            String searchWord = scan.next();

            if (linkedList.search(searchWord)!=null) {
                linkedList.deletion(searchWord);
            } else {
                linkedList.append(searchWord);
            }
            linkedList.display();

        }
}

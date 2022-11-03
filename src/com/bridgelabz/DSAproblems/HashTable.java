package com.bridgelabz.DSAproblems;

import java.util.ArrayList;
import java.util.List;


interface INode<K> {
    K getKey();
    void setKey(K key);
    INode<K> getNext();
    void setNext(INode<K> next);

}

class MyNode<K> implements INode<K>{
    private K key;
    private INode<K> next;
    @Override
    public K getKey() {
        return key;
    }

    public MyNode(K key) {
        this.key = key;
    }

    public MyNode() {
    }


    @Override
    public void setKey(K key) {
        this.key=key;
    }

    @Override
    public INode<K> getNext() {
        return null;
    }

    @Override
    public void setNext(INode<K> next) {
        this.next=next;
    }

    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append(key).append(" ");
        if (next != null)
            nodeString.append(" , ").append(next);
        return nodeString.toString();
    }
}

class MyLinkedList<K> {
    INode<K> head;
    INode<K> tail;

    public MyLinkedList() {
    }
    public void add(INode<K> newNode){
        if (head==null){
            head=newNode;
            tail=newNode;
        }else {
            INode<K> tempNode = head;
            head=newNode;
            head.setNext(tempNode);
        }
    }
    INode<K> search(K searchData){
        INode<K> temp = head;
        while (temp!=null){
            if (temp.getKey().equals(searchData)){
                return temp;
            }
            temp=temp.getNext();
        }
        return null;
    }
    public INode<K> pop(){
        INode<K> tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }
    public Boolean deletion(K deleteData){
        INode<K> deleteNode=search(deleteData);
        INode<K> temp = head;
        while (temp!=null) {
            if (temp.getNext().equals(deleteNode)) {
                temp.setNext(deleteNode.getNext());
                deleteNode.setNext(null);
                return true;
            }
            temp=temp.getNext();
        }
        return false;
    }
    public void printMyNodes(){
        INode<K> temp = head;
        if(head == null){
            System.out.println("Linked List is empty");
        }
        while(temp != null){
            System.out.print(temp.getKey() + " ");
            temp = temp.getNext();
        }
    }
    @Override
    public String toString() {
        return " \n{" + head + "}";
    }

}
public class HashTable {

    List<MyLinkedList> myBucketArray;

    public HashTable() {
        myBucketArray = new ArrayList<>(11);
        for (int i=0;i<11;i++){
            myBucketArray.add(i,null);
        }
    }

    public int getIndex(int key) {
        return Math.abs(key%11);
    }

    public void add(int key){
        int indexValue = getIndex(key);
        MyLinkedList<Integer> myLinkedList1 = myBucketArray.get(indexValue);
        if (myLinkedList1==null){
            MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
            INode<Integer> newNode = new MyNode<>(key);
            myLinkedList.add(newNode);
            myBucketArray.set(indexValue,myLinkedList);
        }else {
            MyNode<Integer> searchNode = (MyNode<Integer>) myLinkedList1.search(key);
            if (searchNode!=null){
                myLinkedList1.deletion(key);
            }else {
                INode<Integer> newNode = new MyNode<>(key);
                myLinkedList1.add(newNode);
            }
        }
    }

    @Override
    public String toString() {
        return "HashTable1{" +
                "myBucketArray=" + myBucketArray +
                '}';
    }

    public static void main(String[] args) {
        HashTable hashTable1 = new HashTable();
        Integer[] array = {12,34,32,133,876,7,890,764,123,456,23,113,87,908,877,82,743,127};
        for (Integer integer:array) {
            hashTable1.add(integer);
        }
        System.out.println(hashTable1);
    }

}

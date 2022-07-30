package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringsLinkedList(){
        first.prev=null;
        first.next = last;
        first.value = null;
        last.prev = first;
        last.next = null;
        last.value = null;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node addNode = new Node();
        addNode.value = value;
        addNode.next = last;
        addNode.prev = last.prev;
        last.prev.next = addNode;
        last.prev = addNode;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}

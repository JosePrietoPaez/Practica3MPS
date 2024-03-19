package org.mps;

import org.mps.deque.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            lista.append(i);
            lista.prepend(i);
        }
        for (int i = 0; i < 5; i++) {
            lista.deleteFirst();
            lista.deleteLast();
        }
        System.out.println(lista.size() == 0);
    }
}
// Grupo: José Miguel Prieto Páez y Daniel Rodríguez Sánchez

package org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> nuevo = new LinkedNode<>(value,null,first);
        if (size == 0){ // Como será el único, es primero y último
            last = nuevo;
        } else {
            first.setPrevious(nuevo);
        }
        first = nuevo; // Estos pasos siempre ocurren
        size++;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> nuevo = new LinkedNode<>(value,last,null);
        if (size == 0){ // Como será el único, es primero y último
            first = nuevo;
        } else {
            last.setNext(nuevo);
        }
        last = nuevo; // Estos pasos siempre ocurren
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first == null) throw new DoubleLinkedQueueException("Borrado en lista vacía");
        if (first == last){
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (first == null) throw new DoubleLinkedQueueException("Borrado en lista vacía");
        if (first == last){
            first = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        if (size == 0) throw new DoubleLinkedQueueException("Lectura en lista vacía");
        return first.getItem();
    }

    @Override
    public T last() {
        if (size == 0) throw new DoubleLinkedQueueException("Lectura en lista vacía");
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}

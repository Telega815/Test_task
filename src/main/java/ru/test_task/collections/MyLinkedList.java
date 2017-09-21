package ru.test_task.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

    private int size = 0;

    private Node<E> first;
    private Node<E> last;

    public MyLinkedList(){
    }

    private void linkFirstElement(E element){
        first = new Node<E>(null, element, null);
        last = first;
        size++;
    }
    private void linkSecondElement(E element){
        Node<E> newElement = new Node<E>(first, element, null);
        first.next = newElement;
        last = newElement;
        size++;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> currentNode = first;
        while (currentNode!=null){
            if (o.equals(currentNode.element)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(this.isEmpty()) this.linkFirstElement(e);
        else if (size == 1)this.linkSecondElement(e);
        else{
            Node<E> newNode = new Node<E>(last, e, null);
            last.next = newNode;
            last = newNode;
            size++;
        }
        return last.element==e;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (index<0 || index >=size) throw new IllegalArgumentException("Argument must be between 0 and" + (size-1));
        int i = 0;
        Node<E> currentNode = first;
        while (i!=index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.element;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class MyIterator<T> implements Iterator<T>{
        private Node<T> current = null;

        @Override
        public boolean hasNext() {
            if(current == null) return MyLinkedList.this.size()>0;
            return current.next!=null;
        }

        @Override
        public T next() {
            if(current == null) {
                current = (Node<T>) MyLinkedList.this.first;
                return current.element;
            }else{
                current = current.next;
                return current.element;
            }

        }

        @Override
        public void remove() {

        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previos;

        Node(Node<E> previos, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.previos = previos;
        }
    }
}
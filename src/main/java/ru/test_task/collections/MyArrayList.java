package ru.test_task.collections;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ARRAYDATA = {};

    private Object[] arrayData;

    private int size = 0;

    public MyArrayList(int initialCapacity){
        if(initialCapacity == 0){
            this.arrayData = EMPTY_ARRAYDATA;
        }else if(initialCapacity > 0){
            this.arrayData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("Illegal capacity" + initialCapacity);
        }
    }

    public MyArrayList(){
        this.arrayData = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return arrayData == EMPTY_ARRAYDATA;
    }

    public boolean contains(Object o) {
        boolean result = false;
        for(Object obj : arrayData){
            if (o.equals(obj)){
                result = true;
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int next;
            private int current = -1;
            public boolean hasNext() {
                next = current +1;
                return next < size;
            }

            public E next() {
                current++;
                return (E)arrayData[current];
            }

            public void remove() {
                if (MyArrayList.this.inBound(current)) {
                    MyArrayList.this.remove(current);
                    current--;
                }else
                    throw new IllegalArgumentException("Index must between 0 and " + (size - 1));
            }
        };
        return iterator;
    }

    public Object[] toArray() {
        Object[] returningArray = null;
        if (size != 0) {
            returningArray = new Object[size];
            //System.out.println(returningArray.length);
            System.arraycopy(arrayData, 0, returningArray, 0, size);

        }
        return returningArray;
    }

    public <T> T[] toArray(T[] a) {
        if(a.length < size)
            return (T[]) Arrays.copyOf(arrayData, size, a.getClass());
        System.arraycopy(arrayData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;

    }

    public boolean remove(Object o) {
        boolean result;
        if (!contains(o)){
            result = false;
        }else if(size == 1){
            arrayData = EMPTY_ARRAYDATA;
            size = 0;
            result = true;
        }else{
            for (int i = indexOf(o); i < size; i++) {
                arrayData[i] = arrayData[i + 1];
            }
            size--;
            result = true;
        }
        return result;
    }

    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        for (Object obj: c) {
            if(!contains(obj)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean result = true;
        for (E obj:c) {
            if(!this.add(obj)) result = false;
        }
        return result;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        boolean result;
        try {
            size += c.size();
            while (size >= arrayData.length) {
                expandCapacity();
            }
            for (int i = size-1; i != size -1 - c.size(); i--) {
                arrayData[i] = arrayData[i-c.size()];
            }
            for (E obj:c) {
                arrayData[index] = obj;
                index++;
            }
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (Object obj:c) {
            if(!this.remove(obj)) result = false;
        }
        return result;
    }

    public boolean retainAll(Collection<?> c) {
        boolean result;
        try {
            Iterator iterator = this.iterator();
            while(iterator.hasNext()){
                if(!c.contains(iterator.next())) iterator.remove();
            }
            result = true;
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    public void clear() {
        arrayData = EMPTY_ARRAYDATA;
        size = 0;
    }

    public E get(int index) throws IllegalArgumentException{
        if(!inBound(index)){
            throw new IllegalArgumentException("Index must between 0 and " + (size - 1));
        }else
            return (E)arrayData[index];
    }

    public E set(int index, E element) {
        E ret = (E)arrayData[index];
        arrayData[index] = element;
        return ret;
    }

    public void add(int index, E element) {
        try {
            size++;
            if (size >= arrayData.length) {
                expandCapacity();
            }
            for (int i = size-1; i != index; i--) {
                arrayData[i] = arrayData[i-1];
            }
            arrayData[index] = element;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public boolean add(E newObject){
        boolean result;
        try {
            size++;
            if (size >= arrayData.length) {
                expandCapacity();
            }

            arrayData[size-1] = newObject;
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = false;
        }

        return result;
    }

    public E remove(final int index)throws IllegalArgumentException{
        E removedObj = (E)arrayData[index];

        if (!inBound(index)){
            throw new IllegalArgumentException("Index must between 0 and " + (size - 1));
        }else if(size == 1){
            arrayData = EMPTY_ARRAYDATA;
            size = 0;
        }else{
            for (int i = index; i < size-1; i++) {
                arrayData[i] = arrayData[i + 1];
            }
            size--;
        }
        return removedObj;
    }

    public int indexOf(Object o) {
        int index;
        if(contains(o)){
            for (index = 0; index < size; index++) {
                if(o.equals(arrayData[index])) break;
            }
        }else{
            throw new IllegalArgumentException("There's no such obj.");
        }
        return index;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(arrayData[i].equals(o)) index = i;
        }
        return index;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private boolean inBound(final int index){
        boolean result;
        if (index < 0 || index >= size){
            result = false;
        }else{
            result = true;
        }
        return result;
    }

    private boolean expandCapacity (){
        boolean success;
        try {
            Object[] conteiner;
            if (size!=0) conteiner = new Object[size * 2];
            else conteiner = new Object[DEFAULT_CAPACITY];
            if(arrayData.length != 0) System.arraycopy(arrayData, 0 , conteiner, 0, size);
            arrayData = conteiner;
            success = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }
}

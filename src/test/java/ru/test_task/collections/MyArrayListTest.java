package ru.test_task.collections;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void removeByIndex() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.add(3);
        testArray.add(8);
        testArray.addAll(2,list);
        for (Integer obj:testArray) {
            System.out.println(obj);
        }
        System.out.println("------------------------");
        testArray.remove(0);
        for (Integer obj:testArray) {
            System.out.println(obj);
        }
        System.out.println("------------------------");
        assertEquals((Integer) 7,testArray.get(2));
    }

    @Test
    public void remove() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        Assert.assertEquals(true,testArray.remove((Object) 4));
        Assert.assertEquals((Integer)5, testArray.get(0));
        Assert.assertEquals((Integer)6, testArray.get(1));
        Assert.assertEquals(2,testArray.size());
    }

    @Test
    public void size() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        Assert.assertEquals(3,testArray.size());
    }

    @Test
    public void isEmpty() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>(0);
        Assert.assertEquals(true, testArray.isEmpty());
        testArray.add(4);
        Assert.assertEquals((Integer) 4, testArray.get(0));
        Assert.assertEquals(false, testArray.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        assertEquals(true,testArray.contains(6));
        assertEquals(true,testArray.contains(5));
        assertEquals(true,testArray.contains(4));
        assertEquals(false,testArray.contains(7));
        assertEquals(false,testArray.contains("sdasdadas"));

        MyArrayList<String> testArray2 = new MyArrayList<String>();
        testArray2.add("a");
        testArray2.add("ABC");
        testArray2.add("");
        assertEquals(true,testArray2.contains("a"));
        assertEquals(true,testArray2.contains("ABC"));
        assertEquals(true,testArray2.contains(""));
        assertEquals(false,testArray2.contains("1111111"));
        assertEquals(false,testArray2.contains("sdasdadas"));
    }

    @Test
    public void iterator() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        Iterator<Integer> iterator = testArray.iterator();
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals((Integer) 4, iterator.next());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals((Integer) 5, iterator.next());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals((Integer) 6, iterator.next());
        Assert.assertEquals(false, iterator.hasNext());
    }

    @Test
    public void toArray() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        Assert.assertEquals(4, testArray.toArray()[0]);
        Assert.assertEquals(5, testArray.toArray()[1]);
        Assert.assertEquals(6, testArray.toArray()[2]);
    }

    @Test
    public void toArrayGen() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        String[] stringArray = new String[3];
        testArray.add("");
        testArray.add("a");
        testArray.add(" ");
        testArray.toArray(stringArray);
        Assert.assertEquals("", stringArray[0]);
        Assert.assertEquals("a", stringArray[1]);
        Assert.assertEquals(" ", stringArray[2]);
        testArray.add("563453");
        String[] stringArray2 = testArray.toArray(stringArray);
        Assert.assertEquals("", stringArray2[0]);
        Assert.assertEquals("a", stringArray2[1]);
        Assert.assertEquals(" ", stringArray2[2]);
        Assert.assertEquals("563453", stringArray2[3]);
    }

    @Test
    public void containsAll() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        testArray.add(7);
        testArray.add(8);
        Assert.assertEquals(true, testArray.containsAll(list));
    }

    @Test
    public void addAll() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(4);
        testArray.add(8);
        testArray.addAll(list);
        Assert.assertEquals((Integer)5, testArray.get(2));
        Assert.assertEquals((Integer)7, testArray.get(3));
        Assert.assertEquals((Integer)6, testArray.get(4));
    }

    @Test
    public void addAll1() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.addAll(2,list);
        Assert.assertEquals(true, testArray.containsAll(list));
        Assert.assertEquals((Integer) 7,testArray.get(3));
    }

    @Test
    public void removeAll() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.add(3);
        testArray.add(8);
        testArray.addAll(2,list);
        Assert.assertEquals(true, testArray.containsAll(list));
        testArray.removeAll(list);
        Assert.assertEquals(false, testArray.containsAll(list));
        Assert.assertEquals((Integer) 3,testArray.get(3));
    }

    @Test
    public void retainAll() throws Exception {

        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        testArray.add(8);
        testArray.add(8);
        testArray.add(8);
        testArray.add(3);
        testArray.add(8);
        testArray.addAll(2,list);
        Assert.assertEquals(true, testArray.containsAll(list));
        Assert.assertEquals(true, testArray.retainAll(list));
        Assert.assertEquals(true, testArray.containsAll(list));
        Assert.assertEquals((Integer) 6,testArray.get(2));
        Assert.assertEquals(3,testArray.size());
    }

    @Test
    public void clear() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        testArray.add("1");
        testArray.add("1");
        testArray.add("1");
        testArray.add("1");
        testArray.add("1");
        testArray.clear();
        Assert.assertEquals(0,testArray.size());
    }

    @Test
    public void set() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        testArray.add("1");
        testArray.add("2");
        testArray.add("3");
        testArray.add("4");
        String str = testArray.set(1,"A");
        String str2 = testArray.set(3,"B");
        Assert.assertEquals(str,"2");
        Assert.assertEquals(str2,"4");
        Assert.assertEquals("A",testArray.get(1));
        Assert.assertEquals("B",testArray.get(3));
    }


    @Test
    public void add() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        testArray.add("ABIR0");
        testArray.add("ABIR1");
        testArray.add("ABIR2");
        testArray.add("ABIR3");
        testArray.add("ABIR4");
        testArray.add(3,"ABIR5");
        Assert.assertEquals("ABIR5", testArray.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexOf() throws Exception {
        MyArrayList<Integer> testArray = new MyArrayList<Integer>();
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        Assert.assertEquals(0, testArray.indexOf(4));
        Assert.assertEquals(1, testArray.indexOf(5));
        Assert.assertEquals(2, testArray.indexOf(6));
        testArray.indexOf(8);
    }

    @Test
    public void lastIndexOf() throws Exception {

    }

    @Test
    public void listIterator() throws Exception {
    }

    @Test
    public void listIterator1() throws Exception {
    }

    @Test
    public void subList() throws Exception {
    }

    @Test
    public void getAndAdd() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        testArray.add("ABIR0");
        testArray.add("ABIR1");
        testArray.add("ABIR2");
        testArray.add("ABIR3");
        testArray.add("ABIR4");
        testArray.add("ABIR5");
        Assert.assertEquals("ABIR0", testArray.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getException() throws Exception {
        MyArrayList<String> testArray = new MyArrayList<String>();
        testArray.add("ABIR0");
        Assert.assertEquals("ABIR4", testArray.get(1));
    }



}
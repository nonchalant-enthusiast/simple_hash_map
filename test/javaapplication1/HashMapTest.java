/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author sasha
 */
public class HashMapTest {
    
    public HashMapTest() {
    }

    @Test
    public void testPut() {
        System.out.println("put");
        long key = 1234567890000L;
        int value = 0;
        HashMap instance = new HashMap();
        instance.put(key, value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsException() {
        System.out.println("getIndexOutOfBoundsException");
        long key = -1234567890000L;
        HashMap instance = new HashMap();
        int result = instance.get(key);
    }

    @Test
    public void testPutGet() {
        System.out.println("putGet");
        long key = -1234567890000L;
        int value = 0;
        HashMap instance = new HashMap();
        instance.put(key, value);
        int expResult = 0;
        int result = instance.get(key);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRePut() {
        System.out.println("rePut");
        long key = -1234567890000L;
        int value = 0;
        HashMap instance = new HashMap();
        instance.put(key, value);
        instance.put(key, instance.get(key) + 1);
        int expResult = 1;
        int result = instance.get(key);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFullSize() {
        System.out.println("fullSize");
        Random rand = new Random(666);
        HashMap instance = new HashMap();
        for(int i = 0; i < instance.TABLE_SIZE; i++) {
            instance.put(rand.nextLong(), rand.nextInt());
        }
    }
    
    @Test (expected = RuntimeException.class)
    public void testOverSize() {
        System.out.println("overSize");
        Random rand = new Random(666);
        HashMap instance = new HashMap();
        for(int i = 0; i < instance.TABLE_SIZE; i++) {
            instance.put(rand.nextLong(), rand.nextInt());
        }
        instance.put(rand.nextLong(), rand.nextInt());
    }
    
    @Test
    public void testSizeZero() {
        System.out.println("sizeZero");
        HashMap instance = new HashMap();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSize() {
        System.out.println("size");
        Random rand = new Random(123);
        HashMap instance = new HashMap();
        for(int i = 0; i < instance.TABLE_SIZE; i++) {
            instance.put(rand.nextLong(), rand.nextInt());
        }
        int expResult = instance.TABLE_SIZE;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSizeWithChange() {
        System.out.println("sizeWithChange");
        Random rand = new Random(123);
        HashMap instance = new HashMap();
        long rand_key = rand.nextLong();
        int rand_value = rand.nextInt();
        instance.put(rand_key, rand_value);
        instance.put(rand_key, instance.get(rand_key) + 1);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
    }
}
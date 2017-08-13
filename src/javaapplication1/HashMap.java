package javaapplication1;

public class HashMap {
    public final static int TABLE_SIZE = 128;
    HashEntry[] hashtable;
 
    HashMap() {
        hashtable = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashtable[i] = null;
        }
    }
    
    class HashEntry {
        private long key;
        private int value;

        HashEntry(long key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }
        
        @Override
        public String toString() {
            return(key + ": " + value);
        }

    } 
    
    public void put(long key, int value) {
        int probe = 0;
        int hash = 0;
        
        do {
            hash = (Math.abs(Long.hashCode(key)) + probe) % TABLE_SIZE;
            
            if (hashtable[hash] == null) {
                hashtable[hash] = new HashEntry(key, value);
                return;
            }
            else if (hashtable[hash].getKey() == key) {
                System.out.println("hello");
                hashtable[hash].setValue(value);
                return;
            }
            probe++;
        } while (probe < TABLE_SIZE);

        // hashtable is full
        throw new RuntimeException("Hash table overflow");
    }
 
    public int get(long key) {
        int probe = 0;
        
        do {
            int hash = (Math.abs(Long.hashCode(key)) + probe) % TABLE_SIZE;
            
            if (hashtable[hash] == null) {
                // hastable doesn't have such key
                throw new IndexOutOfBoundsException("There is no such entry");
            }
            else if (hashtable[hash].getKey() == key) {
                return hashtable[hash].getValue();
            }
            probe++;
        } while (probe < TABLE_SIZE);
        // hashtable doesn't have such key
        throw new IndexOutOfBoundsException("There is no such entry");
    }
    
    public int size() {
        int size = 0;
        for(int i = 0; i < TABLE_SIZE; i++) {
            if (hashtable[i] != null) {
                size++;
            }
        }
        return size;
    }
    
    @Override
    public String toString() {
        String res = "";
        
        for(int i = 0; i < TABLE_SIZE; i++) {
            if (hashtable[i] != null) {
                res += hashtable[i].toString() + "\n";
            }
        }
        return res;
    }
}
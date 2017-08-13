**HashMap** consists of a table of **HashEntries** (pairs of *key: value*).<br>
**HashEntry** is an internal class for implementing pairing *key: value*.<br>
Key type is *long* & value type is *int*. I use built-in hashing function for long (**Long.hashCode**) and **open addressing** with **linear probing**.<br>
You can:
1. put a pair *key: value* with method **put**. 
2. get a value for certain key with method **get** (be carefull about non-existing key-value pairs, there's an exception for this case). 
3. get the size of a hashmap with method **size**. 
4. print your dictionary.

TODO: 
1. dynamic hashtable size.
2. **remove** method.
3. different probing techniques.

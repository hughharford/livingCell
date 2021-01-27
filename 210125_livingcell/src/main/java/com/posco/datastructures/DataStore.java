package com.posco.datastructures;

import java.util.Iterator;

public interface DataStore<Item> {
    boolean isEmpty();
    int size();
    void addFirst(Item item);
    void addLast(Item item);
    Item removeFirst();
    Item removeLast();
    Iterator<Item> iterator();
    Item getIndexed(int index);
    
    // IMPLEMENT LATER AS WE REACH THOSE STAGES...
    
    // Item getNamed(String name);
    // Iterator<Item> iteratorLiving();
    
}

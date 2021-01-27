package com.posco.datastructures;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class DataDeque<Item> implements Iterable<Item>, DataStore<Item>
{
    // USE LINKED LIST IMPLEMENTATION TO ACHIEVE CONSTANT WORST CASE TIME OPERATION

    private Node first;
    private Node last;
    private int numberNodes = 0;
    
    public DataDeque() {
        // Deque<String> deque = new Deque<String>();
        // first = new Node();
        // last = new Node();
    }
    
    public boolean isEmpty() { 
        return numberNodes == 0;
    }
    
    public int size() {
        return numberNodes;
    }
    
    // add the item to the front
    public void addFirst(Item item) 
    {
        // this can leave a null in the last (this was created at the start of the stack)
        
        if (item == null) {
            throw new IllegalArgumentException("Nothing to add in addFirst");
        }
        Node oldFirst = first;
        first = new Node();
        first.itemInNode = item;
        first.next = oldFirst;   
        
        if (size() == 0) { // when adding first node
            first.next = null;
            last = first; 
        }
        numberNodes++;

    }
    
    // queue add - at back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Nothing to add in addLast");
        }

        Node oldLast = last;
        last = new Node();
        last.itemInNode = item;
        last.next = null;
        // special cases for empty queue
        if (size() == 0) { 
            first = last; 
        } else {
            oldLast.next = last; 
        }
        numberNodes++;

    }

    public Item removeFirst() {        
        if (numberNodes == 0) {
            throw new NoSuchElementException("Nothing to remove, removeFirst");
        }
        Item item = first.itemInNode;
        first = first.next;
        
        if (isEmpty()) last = null;
        numberNodes--;
        return item;
    }
    
    public Item removeLast()
    {
        if (numberNodes == 0) {
            throw new NoSuchElementException("Nothing to remove, removeLast");
        }
        Node leadNode = first;
        Node followNode = first;
         
        if (numberNodes > 1) {
            // ListIterator dIterator = new ListIterator();
            // while (dIterator.hasNext()) {
                
            for (int loopCount = 0; loopCount < numberNodes-1; loopCount++) {
                followNode = leadNode;
                leadNode = leadNode.next;  
                
                // dIterator.hasNext();
                // System.out.println("RemoveLast... dIterator.next() = " + dIterator.next());
                } 
        } else if (numberNodes == 1) {
            leadNode.itemInNode = first.itemInNode; 
        }
   
        // reduce number of nodes
        followNode.next = null;
        last = followNode;
        followNode = null; // tidy up
        
        numberNodes--;
        if (isEmpty()) last = null;

        // CHECK THIS THOROUGHLY
        if (size() == 0) { 
            first = last; 
        } else if (size() == 1) { 
            first.next = last;
        }
        
        return leadNode.itemInNode;
    }
    
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() 
    { 
        return new ListIterator(); 
    }
    
    
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return null != current; }
        public void remove() { /* not supported */ throw new UnsupportedOperationException("no more items to remove"); }
        public Item next()
        {
            // throw java.util.NoSuchElementException if no more items in iteration
            if (current == null) { throw new NoSuchElementException(" end of the List, no more items"); }

            Item item = current.itemInNode;
            current = current.next;
            return item;
        }
    }

    // THESE METHODS SHOULD BE MADE PRIVATE / TAKEN OUT ONCE CLASS WORKING

    public Item getLast() {
        if (last == null) { return null; }
        return last.itemInNode;
    }
    

    public Item getFirst() {
        if (first == null) { return null; }
        return first.itemInNode;
    }

    public Item getIndexed(int index) {
        if (first == null) { return null; }
        Node getNode = first;
        for (int findIndex = 0; findIndex < index; findIndex++) {
            getNode = getNode.next;
        }
        return getNode.itemInNode;
    }
 
    
    // unit testing (required)
    public static void main(String[] args) {
        if (args.length == 0) { throw new NoSuchElementException("main: no input found"); }
        
        /*  
         * THIS DEPENDENCY DOESN'T WORK:
         * 
         * 		<dependency>
					<groupId>edu.princeton.cs</groupId>
					<artifactId>algs4</artifactId>
					<version>1.0.3</version>
				</dependency>
         * 
        In in = new In(args[0]);      // input file

		*/
        DataDeque<String> dequeOne = new DataDeque<String>();

        /*
         * 
         * 
         
        while (!in.isEmpty()) {
            //String i = in.readString();
            String i = "addSomething";
            dequeOne.addFirst(i);
            // System.out.println(" >>> " + dequeOne.size());
            // String j = in.readString();
            // dequeOne.addLast(j);  //  THIS was one issue
            // System.out.println(" >>> >>> " + dequeOne.size());
            
            // StdOut.println("Deque.removeLast() gives: " + dequeOne.removeLast());
            // StdOut.println("Deque.removeLast() gives: " + dequeOne.removeLast());

        }
        System.out.println("Deque.isEmpty() gives: " + dequeOne.isEmpty() + " - After input ");
        System.out.println("Deque.size() gives: " + dequeOne.size() + " - After input ");
        

         * 
         */
        Iterator<String> dequeIterator = dequeOne.iterator();
        for (int exceedLimit = 0; exceedLimit < dequeOne.size(); exceedLimit++) {
           System.out.println("dequeIterator.next() = " + dequeIterator.next());
        }

    } 
    
    //     private inner class - (access modifiers don't matter)
    private class Node
    {
        Item itemInNode;
        Node next;
    }


}
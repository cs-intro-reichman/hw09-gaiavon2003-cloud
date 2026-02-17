/** A linked list of character data objects.
 *  (Actually, a list of Node objects, each holding a reference to a character data object.
 *  However, users of this class are not aware of the Node objects. As far as they are concerned,
 *  the class represents a list of CharData objects. Likwise, the API of the class does not
 *  mention the existence of the Node objects). */
public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;
	
    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }
    
    /** Returns the number of elements in this list. */
    public int getSize() {
 	      return size;
    }

    /** Returns the CharData of the first element in this list. */
    public CharData getFirst() {
        // Your code goes here
        return first.cp;
    }

    /** GIVE Adds a CharData object with the given character to the beginning of this list. */
    public void addFirst(char chr) {
        // Your code goes here\
       CharData newchardata = new CharData(chr);
       Node newNode = new Node(newchardata);
       newNode.next = first;
       first = newNode;
       size++;
    }
    
    /** GIVE Textual representation of this list. */
    public String toString() {
        // Your code goes here
      if( size == 0){
        return "()";
      }
      String str = "(";
      Node current = first;
      while (current != null) {
        str += current.toString() + " ";
        current = current.next;
        
      }
      return str.substring(0, str.length()-1) + ")";
    }

    /** Returns the index of the first CharData object in this list
     *  that has the same chr value as the given char,
     *  or -1 if there is no such object in this list. */
    public int indexOf(char chr) {
        // Your code goes here
        Node current = first;
        int index = 0;
        while (current != null) {
            if(current.cp.equals(chr)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /** If the given character exists in one of the CharData objects in this list,
     *  increments its counter. Otherwise, adds a new CharData object with the
     *  given chr to the beginning of this list. */
    public void update(char chr) {
        // Your code goes here
        Node current = first;
        while (current != null){
            if (current.cp.chr == chr){
                current.cp.count++;
                return;
            }
            current = current.next;
        }
        addFirst(chr);
   
    }

    /** GIVE If the given character exists in one of the CharData objects
     *  in this list, removes this CharData object from the list and returns
     *  true. Otherwise, returns false. */
    public boolean remove(char chr) {
        // Your code goes here
        Node current = first;
        Node perv = null;
        while(current != null && !(current.cp.equals(chr))){
            perv = current;
            current = current.next;
        }
        if( current == null){
            return false;
        }
        if( perv == null){
            first = first.next;
            size--;
            return true;
        }
        else{
            perv.next= current.next;
            size--;
            return true;
        }
    }

    /** Returns the CharData object at the specified index in this list. 
     *  If the index is negative or is greater than the size of this list, 
     *  throws an IndexOutOfBoundsException. */
    public CharData get(int index) {
        // Your code goes here
        if( index < 0 || index > (size -1)){
            throw new IndexOutOfBoundsException( index + " is out of bounds");
        }
        int count = 0;
        Node current = first;
        while (count != index) {
            count ++;
            current = current.next;
        }
        return current.cp;
    }

    /** Returns an array of CharData objects, containing all the CharData objects in this list. */
    public CharData[] toArray() {
	    CharData[] arr = new CharData[size];
	    Node current = first;
	    int i = 0;
        while (current != null) {
    	    arr[i++]  = current.cp;
    	    current = current.next;
        }
        return arr;
    }

    /** Returns an iterator over the elements in this list, starting at the given index. */
    public ListIterator listIterator(int index) {
	    // If the list is empty, there is nothing to iterate 
        if ( size == 0 || index > (size -1) ||index < 0 ){
            throw new IndexOutOfBoundsException( index + " is out of bounds");
        }  
	    
	    // Gets the element in position index of this list
        Node start =  first;
        int count = 0;
        while ( count != index){
            count++;
            start = start.next;
        }
        ListIterator listIterator = new  ListIterator(start);
        return listIterator;
	   
        // Returns an iterator that starts in that element
	    
    }
}
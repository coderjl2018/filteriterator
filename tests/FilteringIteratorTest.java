import java.util.ArrayList;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class FilteringIteratorTest extends TestCase {
	private ArrayList<Integer> myListInts;
	private ArrayList<String> myListString;
	
	public void setUp(){
		myListInts = new ArrayList<Integer>() {{
			add(5);
			add(-2);
			add(-100);
			add(0);
			add(1);
		}};
		
		myListString = new ArrayList<String>() {{
		    add("A");
		    add("B");
		    add("C");
		    add("Hello");
		}};
		
	}
	
	public void testStringLengthFiltering(){
		FilteringIterator<String> filterIter = 
				new FilteringIterator<>(myListString.iterator(), new StringLengthTest());
		// simple assertions
		assertTrue(filterIter.hasNext());
		assertEquals("Hello", filterIter.next());
		assertFalse(filterIter.hasNext());
		// filterIter.next(); // should trigger exception at this point
	}
	 
	public void testPositiveNumberFiltering(){
		FilteringIterator<Integer> filterIter = 
				new FilteringIterator<>(myListInts.iterator(), new PositiveNumberTest());
		// simple assertions
		assertTrue(filterIter.hasNext());
		assertTrue(5 == filterIter.next());
		assertTrue(0 == filterIter.next());
		assertTrue(1 == filterIter.next());
		assertFalse(filterIter.hasNext());
		// filterIter.next(); // should trigger exception
	}
}

import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteringIterator<E> implements Iterator<E> {
	private Iterator<E> iter;
	private IObjectTest filterFunc;
	private E cache; // cache the matching object
	private boolean hasNextMatch; // sentinel to indicate if there is any next matching obj
	
	public FilteringIterator(Iterator<E> iter, IObjectTest filterFunc) {
		this.iter = iter;
		this.filterFunc = filterFunc;
		findNextMatch(); // cache the next match
	}
	
	// find the next matching object that passes the filter criteria
	private E findNextMatch(){
		hasNextMatch = false;
		E prevCache = cache;
		while(iter.hasNext()){
			E obj = iter.next();
			if (filterFunc.test(obj)) {
				// update the cache and the flag, break the loop
				cache = obj; 
				hasNextMatch = true;
				break;
			}
		}
		return prevCache;
	}
	
	@Override
	public boolean hasNext() {
		return hasNextMatch;
	}
	
	@Override
	public E next() {
		if (!hasNextMatch){
			throw new NoSuchElementException();
		}
		return findNextMatch();
	}
	
	@Override
	public void remove(){
		throw new UnsupportedOperationException("Not implemented method");
	}
}

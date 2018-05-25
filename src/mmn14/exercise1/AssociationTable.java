package mmn14.exercise1;

import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings({"serial", "rawtypes"})
public class AssociationTable<Key extends Comparable, Value> extends TreeMap<Key, Value> {
	
	public AssociationTable() {
		super();
	}

	// constructs association table from arrays of keys and values
	public AssociationTable(Key[] keys, Value[] values) throws IllegalArgumentException {
		
		int keysLength = sizeOfArray(keys);
		
		if(keysLength != sizeOfArray(values)) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < keysLength; i++) {
			put(keys[i], values[i]);
		}
	}

	// add key and value to the table
	public void add(Key key, Value value) {
		put(key, value);
	}

	// get key from the table
	public Value get(Key key) {
		return super.get(key);
	}

	// checks if key is in the table
	public boolean contains(Key key) {
		return containsKey(key);
	}

	// removes a key from the table
	public boolean remove(Key key) {
		return super.remove(key) == null ? false : true;
	}

	// returns size of the table
	public int size() {
		return super.size();
	}

	// returns iterator of the table
	public Set<Key> keyIterator() {
		return keySet();
	}

	// returns size of array
	private <Type> int sizeOfArray(Type[] array) {
		int count = 0;
		for(int i = 0; i < array.length && array[i] != null; i++) {
			count++;
		}
		return count;
	}
}

package mmn14.exercise1;

import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings({"serial", "rawtypes"})
public class AssociationTable<Key extends Comparable, Value> extends TreeMap<Key, Value> {
	
	public AssociationTable() {
		super();
	}
	
	public AssociationTable(Key[] keys, Value[] values) throws IllegalArgumentException {
		
		int keysLength = sizeOfArray(keys);
		
		if(keysLength != sizeOfArray(values)) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < keysLength; i++) {
			put(keys[i], values[i]);
		}
	}
	
	public void add(Key key, Value value) {
		put(key, value);
	}
	
	public Value get(Key key) {
		return super.get(key);
	}
	
	public boolean contains(Key key) {
		return containsKey(key);
	}
	
	public boolean remove(Key key) {
		return super.remove(key) == null ? false : true;
	}
	
	public int size() {
		return super.size();
	}
	
	public Set<Key> keyIterator() {
		return keySet();
	}
	
	private <Type> int sizeOfArray(Type[] array) {
		int count = 0;
		for(int i = 0; i < array.length && array[i] != null; i++) {
			count++;
		}
		return count;
	}
}

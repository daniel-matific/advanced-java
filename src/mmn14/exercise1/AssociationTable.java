package mmn14.exercise1;

import java.util.TreeMap;

@SuppressWarnings({ "serial", "rawtypes"})
public class AssociationTable<Key extends Comparable, Value> extends TreeMap<Key, Value> {
	
	public AssociationTable() {
		super();
	}
	
	public AssociationTable(Key[] keys, Value[] values) throws IllegalArgumentException {
		
		int keysLength = keys.length;
		
		if(keysLength != values.length) {
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
		return get(key);
	}
}

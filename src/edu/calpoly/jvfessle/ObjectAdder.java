package edu.calpoly.jvfessle;

import java.util.Objects;

public final class ObjectAdder<E> {
	
	
	//COG=10
	//CYC=7
	public boolean add(E object) {
		long[] entries = HelperClass.entries;
		Object[] elements = HelperClass.elements;
		int hash = HelperClass.smearedHash(object);
		int tableIndex = hash & HelperClass.hashTableMask();
		int newEntryIndex = HelperClass.size; // current size, and pointer to the entry to be appended
		int next = HelperClass.table[tableIndex];
		if (next == HelperClass.UNSET) { // uninitialized bucket
			HelperClass.table[tableIndex] = newEntryIndex;
		} else {
			int last;
			long entry;
			do {
				last = next;
				entry = entries[next];
				if (HelperClass.getHash(entry) == hash && Objects.equals(object, elements[next])) {
					return false;
				}
				next = HelperClass.getNext(entry);
			} while (next != HelperClass.UNSET);
			entries[last] = HelperClass.swapNext(entry, newEntryIndex);
		}
		if (newEntryIndex == Integer.MAX_VALUE) {
			throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
		}
		int newSize = newEntryIndex + 1;
		HelperClass.resizeMeMaybe(newSize);
		HelperClass.insertEntry(newEntryIndex, object, hash);
		HelperClass.size = newSize;
		if (newEntryIndex >= HelperClass.threshold) {
			HelperClass.resizeTable(2 * HelperClass.table.length);
		}
		HelperClass.modCount++;
		return true;
	}
}

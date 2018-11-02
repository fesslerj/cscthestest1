package edu.calpoly.jvfessle;

import java.util.Objects;

public final class ObjectAdder<E> {
	
	
	//COG=10
	//CYC=7
	public boolean add(E object) {
		long[] entries = DoubleMathHelper.entries;
		Object[] elements = DoubleMathHelper.elements;
		int hash = DoubleMathHelper.smearedHash(object);
		int tableIndex = hash & DoubleMathHelper.hashTableMask();
		int newEntryIndex = DoubleMathHelper.size; // current size, and pointer to the entry to be appended
		int next = DoubleMathHelper.table[tableIndex];
		if (next == DoubleMathHelper.UNSET) { // uninitialized bucket
			DoubleMathHelper.table[tableIndex] = newEntryIndex;
		} else {
			int last;
			long entry;
			do {
				last = next;
				entry = entries[next];
				if (DoubleMathHelper.getHash(entry) == hash && Objects.equals(object, elements[next])) {
					return false;
				}
				next = DoubleMathHelper.getNext(entry);
			} while (next != DoubleMathHelper.UNSET);
			entries[last] = DoubleMathHelper.swapNext(entry, newEntryIndex);
		}
		if (newEntryIndex == Integer.MAX_VALUE) {
			throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
		}
		int newSize = newEntryIndex + 1;
		DoubleMathHelper.resizeMeMaybe(newSize);
		DoubleMathHelper.insertEntry(newEntryIndex, object, hash);
		DoubleMathHelper.size = newSize;
		if (newEntryIndex >= DoubleMathHelper.threshold) {
			DoubleMathHelper.resizeTable(2 * DoubleMathHelper.table.length);
		}
		DoubleMathHelper.modCount++;
		return true;
	}
}

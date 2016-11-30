package a3.gameObjects;

import java.util.ArrayList;

import a3.ICollection;
import a3.IIterator;

public class ObjectsCollection implements ICollection{

	private ArrayList<Objects> everything; 
	
	public ObjectsCollection() {
		everything = new ArrayList<Objects>();
	}
	
	public void add(Objects newObject) {
		everything.add(newObject);
	}
	
	public void remove(Objects newObject) {
		everything.remove(newObject);
	}
	
	public ArrayList<Objects> getEverything() {
		return everything;
	}

	public IIterator getIterator() {
		return new ObjectsArrayIterator ();		
	}
	
	public int CollectionSize() {
		return everything.size();
	}
	
	private class ObjectsArrayIterator implements IIterator {
		private int currIndex;
		
		public ObjectsArrayIterator() {
			currIndex = -1;
		}
		
		public boolean hasNext() {
			if (everything.size() <= 0) return false;
			if (currIndex == everything.size() -1)
				return false;
			return true;
		}
		
		public Objects getNext() {
			currIndex ++;
			return (everything.get(currIndex));
		}
		
		
		/*
		 * @param i, index of array to check if exists
		 * @return true if exists
		 */
		public boolean hasIndex(int i) {
			if(everything.size() <= 0) return false;
			if(i == everything.size() -1)
				return false;
			return true;
		}
		
		/*
		 * 
		 * @param i, index of array to return
		 * @return object in array to return
		 */
		public Objects getObject(int i) {
			currIndex = i;
			return everything.get(i);
		}
	}
}

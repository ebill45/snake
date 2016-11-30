package a3;

import a3.gameObjects.Objects;

public interface IIterator {
	public boolean hasNext();
	public Object getNext();
	public boolean hasIndex(int i);
	public Objects getObject(int i);
}

package a3;

import a3.gameObjects.Objects;

public interface ICollection {
	public void add(Objects newObject);
	public IIterator getIterator();
}

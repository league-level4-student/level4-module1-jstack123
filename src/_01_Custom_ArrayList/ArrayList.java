package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList<T> {
	T[] tArray;

	public ArrayList() {
		tArray = (T[]) new Object[0];
	}

	public T get(int loc) throws IndexOutOfBoundsException {
		T num = tArray[loc];
		return num;
	}

	public void add(T val) {
		T[] newArray = (T[]) new Object[tArray.length + 1];

		newArray[newArray.length - 1] = (T) val;

		for (int i = 0; i < tArray.length; i++) {
			newArray[i] = tArray[i];
		}
		tArray = newArray;
	}

	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		T[] newArray = (T[]) new Object[tArray.length + 1];

		for (int i = 0; i < newArray.length; i++) {
			if (i < loc) {
				newArray[i] = tArray[i];
			} else if (i > loc) {
				newArray[i] = tArray[i - 1];
			} else {
				newArray[i] = val;
			}

		}
		tArray = newArray;
	}

	public void set(int loc, T val) throws IndexOutOfBoundsException {
		tArray[loc] = val;
	}

	public void remove(int loc) throws IndexOutOfBoundsException {
		T[] newArray = (T[]) new Object[tArray.length - 1];
		
		for (int i = 0; i < tArray.length; i++) {
			if (i < loc) {
				newArray[i] = tArray[i];
			} else if (i > loc) {
				newArray[i-1] = tArray[i];
			} else {
				continue;
			}
		}
		tArray = newArray;
	}

	public boolean contains(T val) {
		
		for (int i = 0; i < tArray.length; i++) {
			if (tArray[i] == val) {
				return true;
			}
		}
		
		return false;
	}
	public int size() {
		return tArray.length;
	}
}
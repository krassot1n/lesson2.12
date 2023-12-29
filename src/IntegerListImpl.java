import exceptions.InvalidIndexException;
import exceptions.ItemNotFoundException;
import exceptions.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{
    private Integer[] storage;
    private int size;

    public IntegerListImpl(int initialCapacity) {
        storage = new Integer[initialCapacity];
        size = 0;
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        if (size == storage.length) {
            resizeArray();
        }
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateSize();
        validateItem(item);
        if (size == storage.length) {
            resizeArray();
        }
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        Integer replacedItem = storage[index];
        storage[index] = item;
        return replacedItem;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                Integer remoteItem = storage[i];
                shiftStorageLeft(i);
                size--;
                return remoteItem;
            }

        }
        throw new ItemNotFoundException("Item not found in storage");
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer removedItem = storage[index];
        shiftStorageLeft(index);
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size; i > 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(storage[index])){
                return storage[i];
            }
        }
        throw new ItemNotFoundException("Item not found in storage");
    }

    @Override
    public boolean equals(IntegerList otherList) {
        for (int i = 0; i < storage.length; i++) {
            validateItem(otherList.get(i));
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void resizeArray() {
        int newCapacity = storage.length * 2;
        Integer[] newArray = new Integer[newCapacity];
        System.arraycopy(storage, 0, newArray, 0, size);
        storage = newArray;
    }

    private void shiftStorageLeft(int startIndex) {
        for (int i = startIndex; i <= size; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
    }

    public void validateSize() {
        if (size == storage.length) {
            throw new InvalidIndexException("index out if bounds");
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > storage.length) {
            throw new InvalidIndexException("Index out of bounds");
        }
    }

    public void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Null item are not allowed");
        }
    }
    private static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private void sortBubbles(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
}

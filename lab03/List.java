package lab03;

import java.util.Collection;

public class List<T> {
    private Node<T> root;
    private int size;

    public List() {
        root = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        Node<T> current = root;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (root == null) return false;

        if (root.data.equals(o)) {
            root = root.nextNode;
            size--;
            return true;
        }

        Node<T> current = root;
        while (current.nextNode != null) {
            if (current.nextNode.data.equals(o)) {
                current.nextNode = current.nextNode.nextNode;
                size--;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error al acceder get");
        }

        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current.data;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            System.out.println("Error al establecer set");
        }

        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        T oldValue = current.data;
        current.data = element;
        return oldValue;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            System.out.println("Error al añadir");
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.nextNode = root;
            root = newNode;
        } else {
            Node<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }
            Node<T> newNode = new Node<>(element);
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            T removedData = root.data;
            root = root.nextNode;
            size--;
            return removedData;
        }

        Node<T> current = root;
        for (int i = 0; i < index - 1; i++) {
            current = current.nextNode;
        }
        T removedData = current.nextNode.data;
        current.nextNode = current.nextNode.nextNode;
        size--;
        return removedData;
    }

    public int indexOf(Object o) {
        Node<T> current = root;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.nextNode;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node<T> current = root;
        int index = 0;
        int lastIndex = -1;
        while (current != null) {
            if (current.data.equals(o)) {
                lastIndex = index;
            }
            current = current.nextNode;
            index++;
        }
        return lastIndex;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            while (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }
}
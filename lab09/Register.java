package lab09;

public class Register<E> implements Comparable<Register<E>> {
  private int key;
  private E value;

  public Register(int key, E value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public E getValue() {
    return value;
  }

  @Override
  public int compareTo(Register<E> o) {
    return Integer.compare(this.key, o.key);
  }

  @Override
  public String toString() {
    return key + ": " + value;
  }
}

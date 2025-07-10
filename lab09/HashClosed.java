package lab09;


public class HashClosed<E> {
    private Register<E>[] table;
    private boolean[] deleted;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        table = new Register[capacity];
        deleted = new boolean[capacity];
        size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }
    public void insert(Register<E> reg) {
        int index = hash(reg.getKey());
        int attempts = 0;
        while (attempts < table.length) {
            if (table[index] == null || deleted[index]) {
                table[index] = reg;
                deleted[index] = false;
                size++;
                System.out.println("Insertado en posición " + index + ": " + reg);
                return;
            } else if (table[index].getKey() == reg.getKey()) {
                System.out.println("Error: Clave duplicada " + reg.getKey());
                return;
            }
            index = (index + 1) % table.length;
            attempts++;
        }
        System.out.println("Tabla llena, no se pudo insertar.");
    }

    public void delete(int key) {
        int index = hash(key);
        int attempts = 0;
        while (attempts < table.length) {
            if (table[index] != null && table[index].getKey() == key && !deleted[index]) {
                deleted[index] = true;
                System.out.println("Eliminado lógicamente en posición " + index);
                size--;
                return;
            }
            index = (index + 1) % table.length;
            attempts++;
        }
        System.out.println("Clave " + key + " no encontrada para eliminar.");
    }

    public Register<E> search(int key) {
        int index = hash(key);
        int attempts = 0;
        while (attempts < table.length) {
            if (table[index] != null && table[index].getKey() == key && !deleted[index]) {
                return table[index];
            }
            index = (index + 1) % table.length;
            attempts++;
        }
        return null;
    }

    public void showTable() {
        System.out.println("\n--- Tabla Hash Cerrado ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] != null && !deleted[i]) {
                System.out.println(table[i]);
            } else {
                System.out.println("[VACÍO]");
            }
        }
    }
}

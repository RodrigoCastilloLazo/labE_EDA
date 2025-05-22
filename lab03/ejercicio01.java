package lab03;

public class ejercicio01 {
    public static void main(String[] args) {        
        List<Integer> intList = new List<>();
            
        System.out.println("vacia : " + intList.isEmpty());
        
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(1, 15); 
        
        System.out.println("lista : " + intList);
        System.out.println("tamaño: " + intList.size());
        
        System.out.println("posición 2: " + intList.get(2));
        
        intList.set(0, 5);

        System.out.println(intList);
        
        System.out.println("Contiene 20? " + intList.contains(20));
        System.out.println("indice de 15: " + intList.indexOf(15));
        
        intList.remove(2);
        System.out.println(intList);
        
        intList.remove(Integer.valueOf(15));
        System.out.println(intList);
        
        intList.clear();
        System.out.println(intList);
     
        
    }

    
}
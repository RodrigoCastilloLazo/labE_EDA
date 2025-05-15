package lab02;

public class ejercicio01 {

    public static void main(String[] args) {
        System.out.println(invertNumber(12345));
    }
    public static int invertNumber(int n) {
        if (Integer.toString(n).length() == 1) {
            return n;
        }else {
            int var = n % 10;
            int largo = Integer.toString(n).length();
            return (int) Math.pow(10, largo - 1) * var + invertNumber((n - var)/10);
        }
    }
  
}
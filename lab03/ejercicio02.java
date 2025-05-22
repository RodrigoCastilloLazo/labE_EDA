package lab03;

import java.util.Scanner;

public class ejercicio02 {

    public static <T extends Number> double suma(T valor1, T valor2) {
        return (valor1.doubleValue() + valor2.doubleValue());
    } 
    public static <T extends Number> double resta(T valor1, T valor2) {
        return (valor1.doubleValue() - valor2.doubleValue());
    }
    public static <T extends Number> double producto(T valor1, T valor2) {
        return (valor1.doubleValue() * valor2.doubleValue());
    }
    public static <T extends Number> double division(T valor1, T valor2) {
        return (valor1.doubleValue() / valor2.doubleValue());
    }
    public static <T extends Number> double potencia(T valor1, T valor2) {
        return Math.pow(valor1.doubleValue(), valor2.doubleValue());
    }
    public static <T extends Number> double raiz_cuadrada(T valor1) {
        return Math.sqrt(valor1.doubleValue());
    }
    public static <T extends Number> double raiz_cubica(T valor1) {
        return Math.pow(valor1.doubleValue(), 1/3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    }
}
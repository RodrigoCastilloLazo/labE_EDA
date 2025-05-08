package lab01;

import java.util.*;

public class ejercicio01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
    System.out.print("Ingrese el número de estudiantes: ");
    int n = scanner.nextInt();
    
    double[] calificaciones = new double[n];
    
    for (int i = 0; i < n; i++) {
        System.out.print("Ingrese la calificación del estudiante " + (i+1) + ": ");
        calificaciones[i] = scanner.nextDouble();
    }
    Arrays.sort(calificaciones);
    System.out.println("\nResultados:");
    System.out.printf("Mediana: %.2f\n", mediana(calificaciones));
    System.out.printf("Moda: %.2f\n", moda(calificaciones));
    System.out.printf("Desviación Estándar: %.2f\n", desviacion(calificaciones, media(calificaciones)));
    scanner.close();
  }
  public static double moda(double[] calificaciones){
    double moda = calificaciones[0];
    int contMax = 1;
    int contActual = 1;
    double numActual = calificaciones[0];
    
    for (int i = 1; i < calificaciones.length; i++) {
        if (calificaciones[i] == numActual) {
            contActual++;
        } else {
            if (contActual > contMax) {
                contMax = contActual;
                moda = numActual;
            }
            numActual = calificaciones[i];
            contActual = 1;
        }
    }
    if (contActual > contMax) {
        moda = numActual;
    }
    return moda;
  }
  public static double media(double[] calificaciones){
    double suma = 0;
    for (double calif : calificaciones) {
        suma += calif;
    }
    return suma / calificaciones.length;
  }
  public static double mediana(double[] calificaciones){
    int n = calificaciones.length;
    if (n % 2 == 0) {
        return (calificaciones[n/2 - 1] + calificaciones[n/2]) / 2.0;
    } 
    return calificaciones[n/2];
  }
  public static double desviacion(double[] calificaciones, double media){
    double sumaDifCuad = 0;
    for (double calif : calificaciones) {
        sumaDifCuad += Math.pow(calif - media, 2);
    }
    return Math.sqrt(sumaDifCuad / calificaciones.length);    
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import business.TecnicasSubMuestro;
import java.util.Scanner;
import model.Cuadricula;

/**
 *
 * @author Hugo
 */
public class Application {
    
    private Scanner input;

    public Application() {
        input = new Scanner(System.in);
    }
    
    
    
    public static void main(String[] args) {
        Application ap;
        int x, y, lado;
        Cuadricula cuadricula;
        
        ap = new Application();
        x = ap.pedirNumero("# filas: ");
        y = ap.pedirNumero("# columnas: ");
        lado = ap.pedirNumero("lado: ");
        
        cuadricula = new Cuadricula(x, y, true);
        cuadricula.setLado(lado);
        
        if (cuadricula.esLadoValido()) {
            System.out.println("Matriz");
            cuadricula.imprimirMatriz();
            System.out.println("\nSubmuestreo Simple");
            TecnicasSubMuestro.subMuestroSimple(cuadricula).imprimirMatriz();
        } else {
            System.out.println("Lado no válido");
        }
        
        
    }
    
    public int pedirNumero(String mensaje){
        System.out.print(mensaje);
        return input.nextInt();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Arrays;
import model.Cuadricula;

/**
 *
 * @author Hugo
 */
public class TecnicasSubMuestro {
    
    public static Cuadricula subMuestroSimple(Cuadricula cuadricula){
        int filas = cuadricula.getX()/cuadricula.getLado();
        int columnas = cuadricula.getY()/cuadricula.getLado();
        Cuadricula cSimple = new Cuadricula(filas, columnas, false);
        int flagI, flagJ;
        
        flagI = 0;
        for (int i = 0; i < cuadricula.getMatriz().length; i=i+cuadricula.getLado()) {
            flagJ = 0;
            for (int j = 0; j < cuadricula.getMatriz()[0].length; j=j+cuadricula.getLado()) {
                cSimple.getMatriz()[flagI][flagJ] = cuadricula.getMatriz()[i][j];
                flagJ++;
            }
            flagI++;
        }
        
        return cSimple;
    }
    
    public static Cuadricula subMuestroMedia(Cuadricula cuadricula){
        int filas = cuadricula.getX()/cuadricula.getLado();
        int columnas = cuadricula.getY()/cuadricula.getLado();
        Cuadricula cMedia = new Cuadricula(filas, columnas, false);
        int flagI, flagJ;
        
        flagI = 0;
        for (int i = 0; i < cuadricula.getMatriz().length; i=i+cuadricula.getLado()) {
            flagJ = 0;
            for (int j = 0; j < cuadricula.getMatriz()[0].length; j=j+cuadricula.getLado()) {
                cMedia.getMatriz()[flagI][flagJ] = promedio(
                                elementosSubMatriz(
                                            cuadricula.getMatriz(), 
                                            i, j, cuadricula.getLado())
                            );
                flagJ++;
            }
            flagI++;
        }
        
        return cMedia;
    }
    
    public static Cuadricula subMuestroMediana(Cuadricula cuadricula){
        int filas = cuadricula.getX()/cuadricula.getLado();
        int columnas = cuadricula.getY()/cuadricula.getLado();
        Cuadricula cMediana = new Cuadricula(filas, columnas, false);
        int flagI, flagJ;
        
        flagI = 0;
        for (int i = 0; i < cuadricula.getMatriz().length; i=i+cuadricula.getLado()) {
            flagJ = 0;
            for (int j = 0; j < cuadricula.getMatriz()[0].length; j=j+cuadricula.getLado()) {
                cMediana.getMatriz()[flagI][flagJ] = mediana(
                                elementosSubMatriz(
                                            cuadricula.getMatriz(), 
                                            i, j, cuadricula.getLado())
                            );
                flagJ++;
            }
            flagI++;
        }
        
        return cMediana;
    }
    
    private static int[] elementosSubMatriz(int matriz[][], int posx, int posy, int lado){
        int arr[] = new int[lado*lado];
        
        int cont = 0;
        for (int i = posx; i < posx + lado; i++) {
            for (int j = posy; j < posy + lado; j++) {
                arr[cont] = matriz[i][j];
                cont++;
            }
        }
        return arr;
    }
    
    private static int promedio(int elementos[]){
        int promedio = 0;
        
        for (int elemento : elementos) {
            promedio += elemento;
        }
        promedio = promedio/elementos.length;
        return promedio;
    }
    
    private static int mediana(int elementos[]){
        Arrays.sort(elementos);
        int mediana;
        int index = elementos.length / 2;
        if (elementos.length % 2 == 0) {
            mediana = (elementos[index] + elementos[index-1])/2;
        } else {
            mediana = elementos[index];
        }
        return mediana;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
}

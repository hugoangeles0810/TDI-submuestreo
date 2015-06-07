/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Helper;

/**
 *
 * @author Hugo
 */
public class Cuadricula {
    
    private static final int MAX_RANDOM = 200;
    private static final int MIN_RANDOM = 1;
    
    private int x;
    private int y;
    private int matriz[][];
    private int lado;

    public Cuadricula() {
    }

    public Cuadricula(int x, int y, boolean generate) {
        this.x = x;
        this.y = y;
        if (generate) {
            this.matriz = generarMatriz(x, y, MIN_RANDOM, MAX_RANDOM);
        } else {
            this.matriz = new int[x][y];
        }
    }

    public Cuadricula(int x, int y, int[][] matriz) {
        this.x = x;
        this.y = y;
        this.matriz = matriz;
    }

    public Cuadricula(int x, int y, int[][] matriz, int lado) {
        this.x = x;
        this.y = y;
        this.matriz = matriz;
        this.lado = lado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    
    public boolean esLadoValido(){
        return (this.x % this.lado == 0) && (this.y % this.lado == 0);
    }
    
    public void imprimirMatriz(){
        String marco = Helper.multiplicaCadena(matriz[0].length, "+-----+");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(marco);
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("+ %3d +", matriz[i][j]);
            }
            System.out.println("");
        }
        System.out.println(marco);
    }

    private int[][] generarMatriz(int filas, int columnas, int min, int max) {
        int m[][] = new int[filas][columnas];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = Helper.numeroAlAzar(min, max);
            }
        }
        return m;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Hugo
 */
public class Helper {
    
    public static int numeroAlAzar(int min, int max){
        return (int)(Math.random()*(max - min) + min);
    }
    
    public static String multiplicaCadena(int n, String cadena){
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            sb.append(cadena);
        }
        return sb.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author DroKaN
 */
public class Consola {
    public static void ejecutarCMD(String cmd){
        Process p;
        try {
          p = Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
          
        }
    }
}

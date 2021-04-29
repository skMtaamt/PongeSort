/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amati.mattia
 */
public class java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(4567);
            Socket client = s.accept();
            
            InputStream i = client.getInputStream();
            ObjectInputStream o = new ObjectInputStream(i);
            char[] nuovo = new char[10];
            
            char[] c = (char[]) o.readObject();
            int index = 0;
            while(true){
                boolean tf = true;
                for(char x : c) {
                    if((x != '-') || (index < 10)) tf = false;
                }
                if(tf){
                   break; 
                }
                int nnn = (int)(Math.random()*9);
                System.out.println(index);
                nuovo[index] = c[nnn];
                c[nnn] = '-';
                index++;
            }
            
            System.out.println(c);
            System.out.println(nuovo);
                       
            i.close();
            
            o.close();
            
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

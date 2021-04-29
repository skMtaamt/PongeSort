/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author amati.mattia
 */
public class java {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("localhost", 4567);
        } catch (IOException ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        }
        char[] c = new char[10];
        for(int x = 0; x < c.length; x++) c[x] = (char)(int)(65+Math.random()*23);
        try {
            
            OutputStream o = s.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(o);
            
            oo.writeObject(c);
            
            oo.flush();
            
            oo.close();
            
            o.flush();
            
            o.close();
            
        } catch (Exception ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binder;

import java.io.*;
import java.net.*;

/**
 *
 * @author M.Odeh
 */
public class Binder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        String line = null;
        BufferedReader bufr;
        BufferedWriter bufw;
       
        try{
        echoServer = new ServerSocket(5002);
        clientSocket = echoServer.accept();
         bufr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         bufw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
         
       
      while ((line = bufr.readLine()) != null){
         if (line != null)
         {
          
             bufw.write("From Server: "+line+"\r\n");
             bufw.flush();
             System.out.println(line);
         }
         
      }         
     
     clientSocket.close();
        
        }catch(Exception e){
        e.printStackTrace();
        }
        
      
    }
    
}

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
 public static String  first ,second ;
    public static void main(String[] args)throws Exception {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        
        String line = null;
        //sever
        BufferedReader bufr;
        BufferedWriter bufw;
        
      //client  
        BufferedReader bra;
        BufferedWriter bwa;
        
          InetAddress ia;
        try{
        echoServer = new ServerSocket(5002);
        while(true){
        clientSocket = echoServer.accept();
         bufr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         bufw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
         

      while ((line = bufr.readLine()) != null){
          first = bufr.readLine();
          second = bufr.readLine();
         if (line != null)
         {
          
            // bufw.write("From Server: "+line+"\r\n");
             System.out.println(line);
                if(line.equals("mul")){
                
                 //do conn with mul server
                    ia = InetAddress.getByName("127.0.0.1");   
                 Socket socAdd = new Socket(ia,2004);
                 
                 bra = new BufferedReader(new InputStreamReader(socAdd.getInputStream()));
                 bwa = new BufferedWriter(new OutputStreamWriter(socAdd.getOutputStream()));
              
                 String linea,answer;
                  
                 
                    bwa.write(first+"\r\n");
                     bwa.flush();
                    bwa.write(second+"\r\n");
                     bwa.flush();
                     
                    answer = (bra.readLine());
                    System.out.println(answer);
                    
                      bufw.write(answer+"\r\n");
                      bufw.flush();
                 
                    
                     
                 ////////////
                
                }else if(line.equals("add")){
                    
                    
                 //do conn with add server
                 
                 ia = InetAddress.getByName("127.0.0.1");   
                 Socket socAdd = new Socket(ia,2005);
                 
                 bra = new BufferedReader(new InputStreamReader(socAdd.getInputStream()));
                 bwa = new BufferedWriter(new OutputStreamWriter(socAdd.getOutputStream()));
              
                 String linea,answer;
                  
                 
                    bwa.write(first+"\r\n");
                     bwa.flush();
                    bwa.write(second+"\r\n");
                     bwa.flush();
                     
                    answer = (bra.readLine());
                    System.out.println(answer);
                    
                      bufw.write(answer+"\r\n");
                      bufw.flush();
                   
                      
               
               
                 
                 ///////////////
                }else if(line.equals("sub")){
                    System.out.println("in sub");
                 //do conn with sub server
                    ia = InetAddress.getByName("127.0.0.1");   
                 Socket socAdd = new Socket(ia,2020);
                 
                 bra = new BufferedReader(new InputStreamReader(socAdd.getInputStream()));
                 bwa = new BufferedWriter(new OutputStreamWriter(socAdd.getOutputStream()));
              
                 String linea,answer;
                  
                 
                    bwa.write(first+"\r\n");
                     bwa.flush();
                    bwa.write(second+"\r\n");
                     bwa.flush();
                     
                    answer = (bra.readLine());
                    System.out.println(answer);
                    
                      bufw.write(answer+"\r\n");
                      bufw.flush();
                     
                      
                   
                 
                }else if(line.equals("div")){
                 //do conn with div server
                
                    ia = InetAddress.getByName("127.0.0.1");   
                 Socket socAdd = new Socket(ia,2011);
                 
                 bra = new BufferedReader(new InputStreamReader(socAdd.getInputStream()));
                 bwa = new BufferedWriter(new OutputStreamWriter(socAdd.getOutputStream()));
              
                 String linea,answer;
                  
                 
                    bwa.write(first+"\r\n");
                     bwa.flush();
                    bwa.write(second+"\r\n");
                     bwa.flush();
                     
                    answer = (bra.readLine());
                    System.out.println(answer);
                    
                      bufw.write(answer+"\r\n");
                      bufw.flush();
                    
                      
                    
                 ///////
                 
                }
       
                
             bufw.flush();
          //   System.out.println(line);
             
          
       
    }
                  
      
 
        
        
        
      }
 }
    }catch(Exception e){
        e.printStackTrace();
      }
        clientSocket.close();  
  }
}

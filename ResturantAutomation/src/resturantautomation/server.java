/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantautomation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Lin
 */
public class server {
    
    public static void main(String args[]) throws Exception
    {
        server server_1=new server();

            server_1.run();
        
        
        
    }


public void run() throws Exception
{   
 
    ServerSocket socket= new ServerSocket(444);
    
    while(true){
    Socket sock=socket.accept();
    InputStreamReader IR=new InputStreamReader(sock.getInputStream());
    BufferedReader BR=new BufferedReader(IR);
    String message="";
    
    while (BR.ready()) {
    message= message+BR.readLine();
    }
    
    System.out.println(message);
    
    if (message!=null)
    {
        PrintStream ps=new PrintStream(sock.getOutputStream());
        ps.println("Message Recieved");
    }
    }
}
}
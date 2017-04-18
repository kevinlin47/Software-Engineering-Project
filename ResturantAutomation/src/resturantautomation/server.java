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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Lin
 */
public class server {
    boolean done=false;
    public static void main(String args[]) throws Exception
    {
        server server_1=new server();

            server_1.run();
        
        
        
    }
    ArrayList<String> orderList=new ArrayList<String>();


public void run() throws Exception
{   
 
    ServerSocket socket= new ServerSocket(1995);
    
    while(true){
    Socket sock=socket.accept();
    InputStreamReader IR=new InputStreamReader(sock.getInputStream());
    BufferedReader BR=new BufferedReader(IR);
    
    String message="";
    


    message=BR.readLine();
    char a_char=message.charAt(0);
    
    
    if (message.equals("chef"))
    {
        PrintStream ps=new PrintStream(sock.getOutputStream());
        ps.println("Chef Connected");
        
        for (int i=0;i<orderList.size();++i)
        {
            ps.println(orderList.get(i));
        }
    }
    else if(a_char=='!')
    {   
        message=message.substring(1);
        if (orderList.remove(message))
        {
            System.out.println("Success");
            PrintStream ps=new PrintStream(sock.getOutputStream());
            ps.println("orderComplete");
            done=true;
        }
    }
    else if(message.equals("checking"))
    {   
        PrintStream ps=new PrintStream(sock.getOutputStream());
        if (done==true)
        {   
            
            ps.println("orderComplete");
            done=false;
        }
        else
        {
            ps.println("notComplete");
        }
    }
    else
    {
        PrintStream ps=new PrintStream(sock.getOutputStream());
        ps.println("Message Recieved");
        orderList.add(message);
        System.out.println(message);
    }
    
    
    

    }
    }
}

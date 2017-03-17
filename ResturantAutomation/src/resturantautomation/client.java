/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package resturantautomation;
import java.io.*;
import java.net.*;

/**
 *
 * @author Kevin Lin
 */
public class client {
    public static void main (String args[]) throws Exception
    {
        client Client=new client();
        Client.run();
    }
    
    public void run() throws Exception
    {
        Socket sock=new Socket("10.0.0.2",444);
        PrintStream PS=new PrintStream(sock.getOutputStream());
        PS.println("Hello to SERVER from CLIENT");
        
        InputStreamReader IR = new InputStreamReader(sock.getInputStream());
        BufferedReader BR=new BufferedReader(IR);
        
        String message=BR.readLine();
        System.out.println(message);
    }
}

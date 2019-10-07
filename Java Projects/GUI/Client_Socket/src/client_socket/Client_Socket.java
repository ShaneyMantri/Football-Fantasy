
package client_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client_Socket {

    public static void main(String[] args) {
        
        try
        {
            Socket sock=new Socket("localhost",9999);
            
            PrintStream pr= new PrintStream(sock.getOutputStream());
            System.out.print("Enter Something");
            
            InputStreamReader rd=new InputStreamReader(System.in);
            BufferedReader ed=new BufferedReader(rd);   
            
            pr.println();
        }
        catch(Exception ex)
        {
            
        }
    }
    
}

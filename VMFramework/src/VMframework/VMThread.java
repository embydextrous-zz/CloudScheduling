/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VMframework;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoteclient.ClientInitiator;

/**
 *
 * @author Prashant Mishra
 */
public class VMThread implements Runnable{

    
    ServerSocket vm_sock;
    Socket conn_socket;
    String client_ip="localhost";
    int ClientPort=9632;
    private int VMport=6060;
    @Override
    public void run() {
        try {
            /*
             *  OPENNIG VM SERVERSOCKET AT VMport
             */ 
          vm_sock=new ServerSocket(VMport);
           while(true)
           {
                
                conn_socket=vm_sock.accept();
           
                System.out.println("vmthread executing Request From Server Accepted Processing......");
           
                BufferedReader inFromClient=new BufferedReader(new InputStreamReader(conn_socket.getInputStream()));
                DataOutputStream outToClient=new DataOutputStream((conn_socket.getOutputStream()));
           
           
                client_ip=inFromClient.readLine();
                ClientPort=Integer.parseInt(inFromClient.readLine());
           
                System.out.println("Client IP and Client Port recieved");
                HandleRemoteRequest obj=new HandleRemoteRequest(client_ip, ClientPort);
                Thread rem=new Thread(obj);
                rem.start();
               
           }
          // outToClient.writeBytes("Service dispatched\n");
        } catch (IOException ex) {
            Logger.getLogger(VMThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

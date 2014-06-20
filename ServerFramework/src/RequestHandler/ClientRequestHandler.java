/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Prashant Mishra
 */
public class ClientRequestHandler implements Runnable {

    int serverPort;
    public ClientRequestHandler(int serverPort)
    {
        this.serverPort=serverPort;
    } 
    @Override
    public void run() 
    {
         try
            {
                 /*
                  *  Listening on port = serverPort
                  */
               ServerSocket cli_sock=new ServerSocket(serverPort);
               while(true)
               {
                   //accept client connection
                   Socket connectionSocket=cli_sock.accept();
                
                   System.out.println("Accepted Launching thread to handle request");
                   
                   //handling client request through clientInterface
                   clientInterface obj=new clientInterface(connectionSocket);
                   Thread ct=new Thread(obj);
                   ct.start();
               }
            }
            catch(Exception e)
            {
                System.out.println("Exception in class ClientRequest handler"+e);
            }
        
        }
    }
    

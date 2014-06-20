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
public class VMRequestHandler implements Runnable {

    int VMport;
    public VMRequestHandler(int port)
    {
        this.VMport=port;
    }
    @Override
    public void run() {
    try
            {
                 /*
                  *  Listening on port = serverPort
                  */
               ServerSocket vm_sock=new ServerSocket(VMport);
               while(true)
               {
                   // Accepting VM register request.. 
                   Socket vmConnectionSocket=vm_sock.accept();
                   
                   System.out.println("Registering Virtual Machine number"+serverframework.ServerFrameWork.vm_count++);
                   
                   //registering VM..
                   registerVM reg=new registerVM(vmConnectionSocket);
                   Thread ct=new Thread(reg);
                   ct.start();
               }
            }
            catch(Exception e)
            {
                System.out.println("Exception in class ClientRequest handler"+e);
            }
    
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import serverframework.ServerFrameWork.*;

/**
 *
 * @author Prashant Mishra
 */
public class clientInterface implements Runnable{

    Socket client_Socket=null;
    int RAM_REQ=256;
    int HD_REQ=1;
    int Duration=20;
    int randomPort;
    
    // VM IP::
    String VMIP=null;
    // Standard VM Connection PORT== 6060
    int vmConnectionPort=6060;
    Socket vmsocket=null;
            
            
    public clientInterface(Socket cli_sock) {
    client_Socket=cli_sock;
    }

    
    @Override
    public void run() {
         System.out.println("handling client connection..");
         try
         {
            BufferedReader inFromClient=new BufferedReader(new InputStreamReader(client_Socket.getInputStream()));
            DataOutputStream outToClient=new DataOutputStream((client_Socket.getOutputStream()));
            
           /*
            * 
            */
            String s=inFromClient.readLine();
            System.out.println("recieved"+s);
            //String s="RequestVM";
            if(s.equals("RequestVM"))
            {
                
                 /*
                  *  Fetch required configuration
                  */
                RAM_REQ=256;
                HD_REQ=1;
                Duration=20;
                        
                /*
                 *    Look for available VMs from the DB.
                 */
                Boolean found=false;
                
                do
                {
                
                System.out.println("Searching VM");
                for(int i=0;i<serverframework.ServerFrameWork.vm_count;i++)
                {
                  System.out.println("serverframework.ServerFrameWork.VM_info[i]=="+serverframework.ServerFrameWork.VM_info[i]);
                  if(serverframework.ServerFrameWork.isAllocated[i]==0)
                  {
                      VMIP=serverframework.ServerFrameWork.VM_info[i];
                      found=true;
                      System.out.println("Found ip+"+VMIP);
                  }
                 
                }
                
                
                }
                while(found==false);
                
                vmConnectionPort=6060;
                /*
                 *   Select random port for clients remote access
                 */
                  randomPort=9632;
                
                /*
                 * Send Random Port to Client 
                 */
                outToClient.writeBytes("VM allocation in progress\n");
                outToClient.writeBytes(randomPort+"\n");
                
                /*
                 * connecting to VM
                 */
                vmsocket=new Socket(VMIP,vmConnectionPort);
                
                System.out.println(VMIP+""+vmConnectionPort+"Request sent to VM for allocation");
                BufferedReader inFromVM=new BufferedReader(new InputStreamReader(vmsocket.getInputStream()));
                DataOutputStream outToVM=new DataOutputStream(vmsocket.getOutputStream());
               
                outToVM.writeBytes(client_Socket.getInetAddress().toString().substring(1)+"\n");
                outToVM.writeBytes(randomPort+"\n");
                
                /*
                 *  Wait for AcknowledgeMent from VM  &&  Send Allocated reply to Client  
                 */
             //   if(inFromVM.readLine().equals("Service dispatched"))
               //      outToClient.writeBytes("Allocated\n");
                
                /*
                 *  Store LOG in database ( YET TO BE IMPLEMENTED )
                 */
            }
         }
         catch(Exception e){System.out.println(e);}
    }
    
    
}

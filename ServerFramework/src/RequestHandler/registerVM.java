/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandler;

import java.net.Socket;
import serverframework.ServerFrameWork.*;

/**
 *
 * @author Prashant Mishra
 */
public class registerVM implements Runnable{

    Socket vm_Socket=null;
    String vm_ip=null;
    
    public registerVM(Socket vm_sock) {
      vm_Socket=vm_sock;
      vm_ip=vm_Socket.getInetAddress().toString();
      
    }
    
    @Override
    public void run() {
     try
     {
           /*
            * Store in database. the VM information.. (NOT YET IMPLEMENTED)
           */
         System.out.println("vm ip recieved"+ vm_ip);
          serverframework.ServerFrameWork.VM_info[serverframework.ServerFrameWork.vm_count-1]=vm_ip.substring(1);
          
     }
     catch(Exception e)
     {
         System.out.print("Exception caught in Class registerVM"+e);
     }
     
    }
    
}

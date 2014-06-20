/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VMframework;

import remoteclient.ClientInitiator;

/**
 *
 * @author Prashant Mishra
 */
public class HandleRemoteRequest implements Runnable{
    
    /**
     *
     * @param ClientIP
     * @param Client
     */
    private String Clientip=null;
    private int port;
    public HandleRemoteRequest(String ClientIP,int Clientport)
    { 
      this.Clientip=ClientIP;
      this.port=Clientport;
      System.out.println("IP=="+ClientIP);
    }

    @Override
    public void run() {
         ClientInitiator init=new ClientInitiator();
                init.initialize(Clientip,port);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientframework;

import remoteserver.ServerInitiator;

/**
 *
 * @author Prashant Mishra
 */
public class remotehandler implements Runnable{

    int VMPORT;
    public remotehandler(int port) {
    VMPORT=port;
    }

    
    @Override
    public void run() {
        System.out.println("VM "+VMPORT); 
        ServerInitiator remote=new ServerInitiator();
        remote.initialize(VMPORT);
    }
    
}

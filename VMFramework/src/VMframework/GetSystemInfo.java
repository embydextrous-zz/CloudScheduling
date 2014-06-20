/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VMframework;

import java.io.File;

/**
 * @author Prashant Mishra
 */
public class GetSystemInfo {
    
  int proc_core;
  long free_mem;
  long max_mem;
  long curr_mem;
  
   public GetSystemInfo()
   {
       getSysInfo();
   }
   public int ret_proc_core()
   {
    return proc_core;   
   }
   
   public long ret_free_mem()
   {
    return free_mem;   
   }
   
   private void getSysInfo(){
     /* Total number of processors or cores available to the JVM */
      proc_core=Runtime.getRuntime().availableProcessors();
       System.out.println("Available processors (cores): " + 
            proc_core);

    /* Total amount of free memory available to the JVM */
       free_mem=Runtime.getRuntime().freeMemory();
       System.out.println("Free memory (bytes): " + 
            free_mem);

    /* This will return Long.MAX_VALUE if there is no preset limit */
       long maxMemory = Runtime.getRuntime().maxMemory();
       max_mem=maxMemory;
       /* Maximum amount of memory the JVM will attempt to use */
       System.out.println("Maximum memory (bytes): " + 
            (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

    /* Total memory currently in use by the JVM */
       curr_mem=Runtime.getRuntime().totalMemory();
       System.out.println("Total memory (bytes): " + 
            curr_mem);

    /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

    /* For each filesystem root, print some info */
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.println("Total space (bytes): " + root.getTotalSpace());
            System.out.println("Free space (bytes): " + root.getFreeSpace());
            System.out.println("Usable space (bytes): " + root.getUsableSpace());
        }
  }

}


package serverframework;

/*
 * @author Prashant Mishra
 */
public class ServerFrameWork {

    /**
     * @param args the command line arguments
     */
    public static int vm_count=0;
    public static String []VM_info;
    public static int isAllocated[];
    private static final int MAX_VM=100;
    
    
    public static void main(String[] args) {
        // Instantiating  MASTER NODE GUI....
        ServerGui serverObject=new ServerGui();
        serverObject.setVisible(true);
        
        VM_info=new String[MAX_VM];
        isAllocated=new int[MAX_VM];
        
        for(int i=0;i<MAX_VM;i++)
            isAllocated[i]=0;
                    
    }
}

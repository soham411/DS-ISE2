
import java.rmi.Naming;
import java.rmi.RemoteException;

public class DSClockSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Clock clockServer = new ClockServer();
            ClockServerRunner clockServerRunner = new ClockServerRunner(clockServer);
            clockServerRunner.run();
        } catch(RemoteException e){
            System.out.println("Remote exception " + e);
        }
    }
    
}

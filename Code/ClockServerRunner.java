
import java.rmi.Naming;


public class ClockServerRunner {

    public Clock clockServer;
    
    public ClockServerRunner(Clock clockServer) {
        this.clockServer = clockServer;
    }
    
    public void run(){
        try {
            Clock clockServer = new ClockServer();
            Naming.bind("rmi://localhost:8000/simple", this.clockServer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

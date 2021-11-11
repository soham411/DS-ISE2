import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class Client {
    public static void main(String[] args){
        System.out.println("Which Algorithm You Want to Implement");
    	Scanner sc = new Scanner(System.in);
        LocalClock i = new ImprovedLocalClock(sc.nextLine());
    }
    
}

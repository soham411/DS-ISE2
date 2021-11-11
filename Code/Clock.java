
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Clock extends Remote {
    /**
    * @ return this clock’s estimate of the time in milliseconds since January 1, 1970
    * @throws RemoteException
    */
    public long getTime() throws RemoteException;
    /**
    * @ return a pair of timed Values, when the message was received and when it was sent (time in milliseconds since January 1, 1970)
    * @throws RemoteException
    */
    public ClockMessage getTaggedTime() throws RemoteException;
   /**
    * @return the "ground truth" time in milliseconds since January 1, 1970
    * @throws RemoteException
    */
    public long getGroundTruth() throws RemoteException;
}

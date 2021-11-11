import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Timer;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.*;


public class ImprovedLocalClock extends LocalClock{
    public LocalClockEvaluator evaluator;
    public Timer timer;
    public String type;
    public long FIXED_DELAY = 150;
    public long FIXED_MESSAGE_DELAY = 10;
    public ImprovedLocalClock(String type){
        super();
        this.evaluator = new LocalClockEvaluator();
        this.type = type;
        this.timer = new Timer();
        timer.schedule(this, 0, this.getTick());
    }
    
    @Override
    public void syncClock(){
        // Simple algorithm with Propagation deplay
        try {
            long l0 = getTime();
            Clock clock = (Clock) Naming.lookup("rmi://localhost:8000/simple");
            ClockMessage clockMessage = clock.getTaggedTime();
            // Algorithm starts here
            long l1 = getTime();
            long oneSidePropagationDelay = (l1 - l0)/2;
            // System.out.println(oneSidePropagationDelay);
            long newTime;
            int count=0;
            switch(type){
                case "simple":
                    newTime = clockMessage.time + oneSidePropagationDelay;
                    break;
                case "local":
                    count+=1;
                    if(count>=1000)
                    {
                        timer.cancel();
                    }
                    long servertime = clock.getGroundTruth();
                    this.evaluator.calculateError(servertime,l0);
                    // newTime = clockMessage.time + this.FIXED_DELAY;
                    // System.out.println("");
                    break;
                case "cristian":
                count+=1;
                    if(count>=1000)
                    {
                        timer.cancel();
                    }
                    newTime = clockMessage.time + this.FIXED_MESSAGE_DELAY + oneSidePropagationDelay;
                    this.evaluator.calculateCristianError(newTime, l1);
                    setTime(newTime);
                    break;
                case "berkeley":
                count+=1;
                    if(count>=1000)
                    {
                        timer.cancel();
                    }
                     InputStream inFromServer =null;
                     Socket client;
            try {
                 client = new Socket("localhost", 1200);
                 DataOutputStream out= new DataOutputStream( client.getOutputStream());
                while(true)
                {
                    
                   
                     
                     System.out.println("Client time");
                     System.out.println( l0);
            out.writeLong(l0);
                    // System.out.println("Updater is working");
        
                    inFromServer = client.getInputStream(); // 
                DataInputStream in = new DataInputStream(inFromServer); //
                    System.out.println("Updated Time");
                   long timer1 =in.readLong();  //as there is new data in the stream it improves the hour
                    System.out.println(timer1);
                    this.evaluator.calculateBerkeleyError(timer1, l0);
                    l0 = getTime();
                    
                    // client.close();
                }
            } catch (IOException e){
                System.out.println(e);
            } finally {
                try {
                    
                    inFromServer.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
                    break;
                case "ntp":
                    // System.out.println(l0 );
                    // System.out.println(clockMessage.in);
                    // System.out.println(clockMessage.out);
                    // System.out.println(l1 );
                    count+=1;
                    if(count>=1000)
                    {
                        timer.cancel();
                    }
                    double offset = 0.5 * (clockMessage.in - l0 + clockMessage.out - l1);
                    double delay = (clockMessage.in - l0 + l1 - clockMessage.out);
                    this.evaluator.calculateNtpError(offset, delay);
                    /**
                    t1 - l0
                    t2 - .in
                    t3 - .out
                    t4 - l1
                Delay
                d = T2 - T1 + T4 - T3

         * Offset formula :
         *      o = 1/2 * (T(i-2) - T(i-3) + T(i-1) - T(i))
         * 
         * Revised formula for our notation :
         *      o = 1/2 * (T2 - T1 + T3 - T4)*/
                    break;
                // default:
                //     newTime = l1;
            }
            // this.evaluator.calculateError(newTime, l1);
            // setTime(newTime);
            // Algorithm ends here
        } catch (RemoteException e) {
            System.out.println("Remote exception " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

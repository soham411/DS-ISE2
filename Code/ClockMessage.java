import java.io.Serializable;


public class ClockMessage implements Serializable{
    public long in;
    public long time;
    public long out;
    
    public ClockMessage(long in, long time, long out){
        this.in = in;
        this.time = time;
        this.out = out;
    }
}


import java.time.Instant;
import java.util.TimerTask;
import java.util.*;

public class LocalClock extends TimerTask {
    /**
    * current time in microseconds since the epoch
    */
    private long time = Instant.now().toEpochMilli();
    // 1599411038;  // random loal clock set
    /**
    * how much the clock ticks per interrupt
    */
    private long tick = 100;
    /**
    * Create a new local clock
    */
    public LocalClock() {
        this.time = new Date().getTime() * 1000L;
    }
    /**
    * access the clock’s time
    * @ return this clock’s estimate of the time in milliseconds since January 1, 1970
    */
    public synchronized long getTime() {
        this.time = Instant.now().toEpochMilli();
        
        return this.time;
        // return Instant.now().toEpochMilli();
    }
    /**
    * set the clock’s time
    * @param timeInMS: the time in milliseconds since January 1, 1970
    */
    public synchronized void setTime(long timeInMS){
        this.time = timeInMS;
    }
    /**
    * @param t: the tick size used to increment the time
    */
    public synchronized void setTick(long t){
        this.tick = t;
    }
    /**
    * @return: the tick size used to increment the time
    */
    public synchronized long getTick(){
        return this.tick;
    }
    /**
    * Return a string representation of the clock including the local time in
    * microseconds and the tick value
    */
    public String toString(){
        return "Tick " + this.tick + " Time " + this.time;
    }
    
    public void syncClock(){}

    @Override
    public void run() {
        this.setTime(this.getTime() + this.getTick());
        this.syncClock();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
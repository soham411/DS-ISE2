import java.io.*;

public class LocalClockEvaluator {
    FileWriter cristian,berkeley,ntp,data;

    public void calculateError(long actualValue, long localValue) {
      try {
    		this.data = new FileWriter("data.txt",true);
	        BufferedWriter out = new BufferedWriter(data);
		    out.write(Math.abs(actualValue - localValue)+","+actualValue+","+localValue+"\n");
		    out.close();
	    }
	    catch (Exception e) {
	      System.err.println("Error: " + e.getMessage());
	    }
        System.out.println("Error " + Math.abs(actualValue - localValue) + " Actual " + actualValue + " Local " + localValue);
    }
    public void calculateNtpError(double offset, double delay) {
        try {
    		this.ntp = new FileWriter("ntp.txt",true);
	        BufferedWriter out = new BufferedWriter(ntp);
		    out.write(offset+","+delay+"\n");
		    out.close();
		    ntp.close();
	    }
	    catch (Exception e) {
	      System.err.println("Error: " + e.getMessage());
	    }
        System.out.println( "Offset: " + offset + " Delay: " + delay);
        // System.out.println( " Offset: " + offset + " Delay: " + delay);
    }

    public void calculateCristianError(long actualValue, long localValue) {
    	try {
    		this.cristian = new FileWriter("cristian.txt",true);
	        BufferedWriter out = new BufferedWriter(cristian);
		    out.write(Math.abs(actualValue - localValue)+","+actualValue+","+localValue+"\n");
		    out.close();
	    }
	    catch (Exception e) {
	      System.err.println("Error: " + e.getMessage());
	    }
        System.out.println("Error " + Math.abs(actualValue - localValue) + " Synchronized Value " + actualValue + " Local " + localValue);}

        public void calculateBerkeleyError(long actualValue, long localValue) {
            try {
                this.berkeley = new FileWriter("berkeley.txt",true);
                BufferedWriter out = new BufferedWriter(berkeley);
                out.write(Math.abs(actualValue - localValue)+","+actualValue+","+localValue+"\n");
                out.close();
            }
            catch (Exception e) {
              System.err.println("Error: " + e.getMessage());
            }
            System.out.println("Error " + Math.abs(actualValue - localValue) + " Synchronized Value " + actualValue + " Local " + localValue);
        }
    
}

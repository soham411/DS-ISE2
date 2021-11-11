import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler {  //a class that pairs the client and the data stream
    protected Socket client;
   
    protected DataOutputStream out;

    public ClientHandler(Socket client) {
        this.client = client;
        try {
        
            this.out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
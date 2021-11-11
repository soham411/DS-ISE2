
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;
import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ClockServer extends UnicastRemoteObject implements Clock,Runnable{

    // private HashMap<
    private ServerSocket server;
    protected HashMap<ClientHandler,Long> clients;
    static boolean flag=false;
    public ClockServer() throws RemoteException {}
    public ClockServer(int port) throws RemoteException {
          try {
            if(!flag)
            {this.server = new ServerSocket(port);
               this.server.setReuseAddress(true);
                                       System.out.println("New server initialized!");}
            clients = new HashMap<ClientHandler,Long>(); 
            Scanner sc = new Scanner(System.in);
             System.out.println("Enter how often the server should send the correct time");
            Long freq = sc.nextLong();
        
            Thread t = new Thread(this);
            t.start();             //start server
            Thread.sleep(10);
            SendMessage Send =new SendMessage(clients,freq);
                } catch (Exception e) {
                     e.printStackTrace();
                    }
    }
    
    @Override
    public long getTime() throws RemoteException {
        long now = Instant.now().toEpochMilli();
        return now;
    }

    @Override
    public ClockMessage getTaggedTime() throws RemoteException {
        long in = getTime();
        long time = getGroundTruth();
        long out = getTime();
        ClockMessage clockMessage = new ClockMessage(in, time, out);
        return clockMessage;
    }

    @Override
    public long getGroundTruth() throws RemoteException {
        long now = Instant.now().toEpochMilli();
        return now;
    }

    public void run()
    {
                InputStream inFromClient =null;
         while (true) {
            try {
                Socket client = server.accept();  //when a new client connects
                System.out.println(client.getInetAddress().getHostName()
                        + " connected");
                inFromClient = client.getInputStream(); // 
                DataInputStream in = new DataInputStream(inFromClient);
                // BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
               
                ClientHandler newClient = new ClientHandler(client);
// System.out.println(in);
                // System.out.println();
                Long s = in.readLong();
                // System.out.println("after readline");
                // System.out.println(in.readLong());
                // System.out.println(s);
                if(clients.containsKey(newClient))
                {
                    // clients.get(newClient).add(s);
                    clients.put(newClient,s);
                    // Thread.sleep(10);
                   // System.out.println("in if"); 
                   
                }
            else
            {
                // System.out.println("in else");
                Long l2 = s;
                          
                clients.put(newClient,l2);
                
                      // clients.clear();
                // Thread.sleep(10);  //this saves it to the customer list
            }
            // clients.clear();
     
            } catch (Exception e) {

                e.printStackTrace();
            }
            // finally {
            //     try {
            // inFromClient.close();
            //     } catch (IOException ex) {
            //         System.out.println(ex);
            //     }
            // }
        }

    }
    // @Override
    public static void main(String[] args) throws RemoteException {
        
           while(true)
        {
    
     try{
        // System.out.println("ClockServer Called");
       new ClockServer(1200);
        flag = true;
        Thread.sleep(5000);}
        catch (Exception e) {
                e.printStackTrace();}

        }
    }
}

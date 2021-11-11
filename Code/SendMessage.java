import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.net.*;

public class SendMessage extends Thread {
        protected HashMap<ClientHandler,Long> clients;
        protected String userInput;
        protected BufferedReader console;
        Long frequency;
        long sum,n;


        public SendMessage(HashMap<ClientHandler,Long> clients, long freq) {
            this.clients = clients; 
            this.userInput = null;
            this.start();
            this.frequency=freq;
        }

        
public void run() {
           
            
            try {
                while(clients.size() == 0){

                }  // here is waiting for some client to connect
                if (clients.size() > 0) {
                    n = clients.size();
                    while (true) {
                      Thread.sleep(frequency);  //how often to update watches
                      sum=0;
                      for (Map.Entry<ClientHandler,Long> entry : clients.entrySet())
                      {
                        Long l1 = entry.getValue();
                        
                            sum+=l1;
                            Thread.currentThread();
                        

                      }
                      for (Map.Entry<ClientHandler,Long> entry : clients.entrySet())
                      {
                        System.out.println("Server Time");
                        System.out.println(System.currentTimeMillis());
                        entry.getKey().out.writeLong((sum+System.currentTimeMillis())/(clients.size()+1));
                        System.out.println("Average Time");

                            System.out.println((sum+System.currentTimeMillis())/(clients.size()+1));
                            // entry.getKey().out.flush();//clears the outgoing data stream
                        }

            
                            // for (List client : clients.g) {

                            //     sum += client.get(1);
                            //     // client.out.writeLong(System.currentTimeMillis());
                            //      //The method returns a reference to the currently executing thread
                          
                            // }
                        // System.out.println("avg");
                        //     System.out.println(sum/l1.size());
                        
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
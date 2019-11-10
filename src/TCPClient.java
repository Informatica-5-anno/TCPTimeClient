import java.net.*;
import java.util.Scanner;
import java.io.*;
   public class TCPClient {
     public void start()throws IOException {
       //Connessione della Socket con il Server
       Socket socket = new Socket("localhost", 7777);
       //Stream di byte da passare al Socket
       DataOutputStream os = new DataOutputStream(socket.getOutputStream());
       BufferedReader ibr= new BufferedReader(new InputStreamReader(socket.getInputStream()));
       Scanner stdIn = new Scanner(System.in);
       
       System.out.print("Inserisci (Date or Time): ");
       String userInput = stdIn.nextLine();
       os.writeBytes(userInput+'\n');
       os.flush();
       String si=ibr.readLine();
       System.out.println("Il server ha risposto: "+si);
       //Chiusura dello Stream e del Socket
       os.close();
       ibr.close();
       socket.close();
     }
     public static void main (String[] args) throws Exception {
       TCPClient tcpClient = new TCPClient();
       tcpClient.start();
     }
   }
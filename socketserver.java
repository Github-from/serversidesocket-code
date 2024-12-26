import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class socketserver {
    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(30699)){
            System.out.println("server is running on port 12345");
            Socket clientsocket=serverSocket.accept();
            System.out.println("client connected: "+ clientsocket);
            BufferedReader in=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            PrintWriter out=new PrintWriter(clientsocket.getOutputStream(),true);
            String clientmessage=in.readLine();
            System.out.println("client says: "+clientmessage);
            out.println("hello from the server!");

            clientsocket.close();
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}

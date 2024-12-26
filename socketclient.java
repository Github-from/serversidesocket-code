import java.io.*;
import java.net.Socket;


public class socketclient {
    public static void main(String[] args) {
        try(Socket socket=new Socket("localhost",30699)){
            System.out.println("connected to the server!");
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("hello from the client!");
            String servermessage=in.readLine();
            System.out.println("server says: "+servermessage);
        }catch(IOException e){
            System.out.println("error: "+e.getMessage());
        }
    }
}

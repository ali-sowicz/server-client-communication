import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        ServerSocket server;
            Socket socket;
            Channel ch;
            List<Object> arr = new ArrayList<>();
            int c = 0;
        try {
            server = new ServerSocket(80);
            while (true && arr.size()<=5){
                try{
                    System.out.println("Waiting for a new connection");
                    socket = server.accept();
                    System.out.println("Connected");
                    ch = new Channel(socket);
                    arr.add(ch);
                    System.out.println("connection num:" + c++);
                    ch.run();
                }
                catch (SocketException e){
                    System.out.println("Disconnected");
                }
                catch (IOException e){
                    System.err.println(e);
                }
            }

        }
        catch (IOException e){
            System.err.println(e);
        }

    }
}

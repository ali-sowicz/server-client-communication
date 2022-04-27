import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Date;

public class Channel {

    Socket socket2;
    PrintStream streamOut;
    BufferedReader streamIn;
    InetAddress myIP;
    URL url;
    BufferedReader reader;
    String data;
    String out;

    public Channel(Socket socket2) {
        this.socket2 = socket2;
    }

    public void run() {
        try {
            streamIn = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            myIP = InetAddress.getLocalHost();
            String adres = streamIn.readLine();

            url = new URL(adres);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
                out += data + "\n";
            }
            System.out.println(out);
            reader.close();

            streamOut = new PrintStream((socket2.getOutputStream()));
            streamOut.println(out + "\n" + "URL: " + adres + "\n" + "Client's port:" + socket2.getPort() +
                    "\n" +"IP: " + myIP + "\n" +"Date: " + (new Date()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            Socket socket = server.accept();
            DataInputStream  din  = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String string1="",string2="";
            while(!string1.equals("stop")){
                string1 = din.readUTF();
                System.out.println(string1);
                string2 = reader.readLine();
                dout.writeUTF(string2);
                dout.flush();
            }
            din.close();
            socket.close();
            server.close();
        }catch (Exception ex){

        }
    }
}

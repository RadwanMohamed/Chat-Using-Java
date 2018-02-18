package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            DataInputStream din  = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string1 = "",string2 = "";
            while (!string1.equals("stop")){
                string1 = reader.readLine();
                dout.writeUTF(string1);
                dout.flush();
                string2 = din.readUTF();
                System.out.println(string2);
            }
            dout.close();
            socket.close();
        }catch(Exception Ex){

        }

    }
}

package RMITest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectTest_Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client starting");
        Socket socket = new Socket("139.199.129.174", 7744);
        //将Socket对应的输入流包装成BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println("Get message form Server: " + line);
        //关闭输入流，关闭Socket;
        br.close();
        socket.close();
    }
}
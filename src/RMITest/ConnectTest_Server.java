package RMITest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectTest_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server starting");
        //创建一个ServerSocket, 用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(7744);
        //用循环不断接收来自客户端的请求
        while (true) {
            //每当接收到一个客户端的请求，服务器也对应产生一个Socket
            Socket s = ss.accept();
            //将Socket对应的输出流包装成printStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("You have received message form server!");
            //关闭输出流，关闭socket
            ps.close();
            s.close();
        }
    }
}

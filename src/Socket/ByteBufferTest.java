package Socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) {
        readFromPut();   //put方法放入数据
        readFromChannel();   //从channel读取数据到Buffer中
    }

    public static void readFromChannel() {
        try {
            String file = Class.forName("Socket.ByteBufferTest").getResource("byte").getFile();
            RandomAccessFile aFile = new RandomAccessFile(new File(file), "rw");
            FileChannel channel = aFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(64);  //设置buffer缓冲区的大小
            int bytesRead = channel.read(buffer);   //read to buffer
            while (bytesRead != -1) {
                System.out.println("write mode position is " + buffer.position());
                System.out.println("write mode limit is " + buffer.limit());
                buffer.flip();  //切换到读模式，limit=posit，position=0，
                System.out.println("Read mode position is " + buffer.position());
                System.out.println("Read mode limit is " + buffer.limit());
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());  //1byte的读数据
                }
                System.out.println();
                buffer.clear();  //将position设置为0，limit设置成capacity值
                bytesRead = channel.read(buffer);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ee) {

        }
    }

    public static void readFromPut() {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        for (int i = 0; i < 2; i++) {
            buffer.putInt(i);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " | ");
        }
        System.out.println();
    }
}
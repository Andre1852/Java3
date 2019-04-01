package examplesNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("D:\\Java3\\123.txt", "r") ) {
            FileChannel in = raf.getChannel();
            ByteBuffer bb = ByteBuffer.allocate(1024);
            int bytesRead = in.read(bb);
            while(bytesRead != -1) {
                bb.flip();
                while(bb.hasRemaining()){
                    System.out.print((char)bb.get());
                }
                bb.clear();
                bytesRead = in.read(bb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

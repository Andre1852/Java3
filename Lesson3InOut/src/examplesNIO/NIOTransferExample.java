package examplesNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class NIOTransferExample {
    public static void main(String[] args) {
        transferFromExample();
//        try {
//            RandomAccessFile fromFile = new RandomAccessFile("src.txt", "rw");
//            FileChannel fromChannel = fromFile.getChannel();
//            RandomAccessFile toFile = new RandomAccessFile("dst.txt", "rw");
//            FileChannel toChannel = toFile.getChannel();
//            long position = 0;
//            long count = fromChannel.size();
//            fromChannel.transferTo(position, count, toChannel);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void transferFromExample() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("src.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile("dst.txt", "rw");
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public class Person implements Serializable {
        private String name;
        String lastName;
    }

    // ---------------------------------------------
    // План занятия
    // ---------------------------------------------
    // java.io
    // ---------------------------------------------
    // File, FilenameFilter, mkdir, mkdirs, createNewFile, renameTo(with flag)
    // InputStream, OutputStream
    // FileInputStream, FileOutputStream, StandardCharsets
    // BufferedInputStream, BufferedOutputStream
    // DataInputStream, DataOutputStream
    // ByteArrayInputStream, ByteArrayOutputStream
    // CharArrayReader, CharArrayWriter
    // PrintStream (to text, System.in, out)
    // PipedInputStream, PipedOutputStream, PipedReader, PipedWriter
    // Reader, Writer
    // FileReader, FileWriter
    // BufferedReader, PrintWriter
    // SequenceInputStream
    // PushBackReader
    // RandomAccessFile
    // ObjectInputStream, ObjectOutputStream (Serializable, Externalizable)
    // ---------------------------------------------
    // java.NIO
    // ---------------------------------------------
    // Paths, Path, Files

    public static class Point implements Serializable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ") ref = " + super.toString();
        }
    }

    public static class Line implements Serializable{
        private Point point1;
        private Point point2;

        public Line() { }

        Line(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }

        public void printInfo() {
            System.out.println("Object reference: " + toString());
            System.out.println("From point " + point1);
            System.out.println("To point " + point2);
        }
    }

    public static void main(String[] args) {
    }

    public static void sequenceTest() {
        try {
            SequenceInputStream sin = new SequenceInputStream(new FileInputStream("a1.txt"), new FileInputStream("a2.txt"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
            int x;
            while ((x = sin.read()) != -1) {
                out.write(x);
            }
            out.close();
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scannerVsBufferedReader() {
        try {
            long time;
            time = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader("123.txt"));
            while (br.readLine() != null) ;
            br.close();
            System.out.println(System.currentTimeMillis() - time);

            time = System.currentTimeMillis();
            Scanner sc = new Scanner(new FileReader("123.txt"));
            while (sc.hasNext()) {
                sc.nextLine();
            }
            sc.close();
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void pipeTest() {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            bw = new BufferedWriter(new FileWriter("C:\\file.txt"));
            for (int i=0; i < 100; i++) bw.write("Java");
            bw.close();
            br = new BufferedReader(new FileReader("C:\\file.txt"));
            String s = null;
            while((s = br.readLine()) != null)
                System.out.println(s);
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
            out.connect(in);
            for (int i = 0; i < 100; i++) {
                out.write(i);
            }
            int x;
            while ((x = in.read()) != -1) {
                System.out.print(x + " ");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteArrayTest() {
        byte[] b1 = {1, 2, 3, 3, 2, 1};
        ByteArrayInputStream in = new ByteArrayInputStream(b1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        byte[] x = out.toByteArray();
        System.out.println(Arrays.toString(x));
    }

    public static void dataInOutTest() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("dos.txt"))) {
            out.writeLong(700);
            out.writeLong(100000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream in = new DataInputStream(new FileInputStream("dos.txt"))) {
            System.out.println(in.readByte());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

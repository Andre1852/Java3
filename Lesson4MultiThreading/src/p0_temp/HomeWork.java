package p0_temp;

import java.io.*;
import java.util.*;
//Домашнее задание:
//        1) Прочитать небольшой файл(около 1кб) в байтовый массив;
//        2) Последовательно сшить 10.txt файлов в один.
//        Может пригодиться следующая вещь:
//        ArrayList<FileInputStream> al = new ArrayList<>();
//        ...
//        Enumeration<FileInputStream> e = Collections.enumeration(al);
//        3) Прочитать файл(взять небольшую книжку на 20-50 кб) и подсчитать кол-во уникальных слов;
//        4) Прочитать еще одну книжку(80-100 кб) на англ. и подсчитать сколько в ней встречается каждая буква алфавита;
public class HomeWork {
    public static void main(String[] args) {
        task1();
    }

    public static void task4() {
        try (BufferedReader br = new BufferedReader(new FileReader("1.txt"))) {
            HashMap<Character, Integer> hm = new HashMap<>();
            String str;
            hm.put(' ', 0);
            for (int i = 97; i <= 122; i++)
                hm.put((char) i, 0);
            while ((str = br.readLine()) != null) {
                str = str.toLowerCase();
                for (int i = 0; i < str.length(); i++)
                    hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
            }
            System.out.println(hm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("1.txt"));
            HashSet<String> hs = new HashSet<>();
            String str;
            while ((str = br.readLine()) != null) {
                str = str.toLowerCase();
                for (String o : str.split(" ")) {
                    hs.add(o);
                }
            }
            br.close();
            System.out.println("unique words count: " + hs.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void task1() {
        BufferedInputStream bis = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            bis = new BufferedInputStream(new FileInputStream("D:\\Java3\\1.txt"));//прописал адрес
            int x;
            while ((x = bis.read()) != -1) {
                out.write(x);
            }
            byte[] bytes = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void task2() {
        ArrayList<BufferedInputStream> al = new ArrayList<>();
        try {
            al.add(new BufferedInputStream(new FileInputStream("1.txt")));
            al.add(new BufferedInputStream(new FileInputStream("2.txt")));
            al.add(new BufferedInputStream(new FileInputStream("3.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Enumeration<BufferedInputStream> en = Collections.enumeration(al);
        SequenceInputStream s = new SequenceInputStream(en);
        int x;
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
            while ((x = s.read()) != -1) {
                out.write(x);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

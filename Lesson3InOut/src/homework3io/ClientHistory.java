package homework3io;
//Малыгин Андрей, домашнее задание к 3 уроку Java3.
//В данном классе использовал FileOutputStream для создания файла history.txt и записи в него текста
//пробный вариант, в чате этот класс не использовал
import java.io.FileOutputStream;
import java.io.IOException;

public class ClientHistory {
    public static void main(String[] args) {
        String write = "Hello";
        byte[] outDate = write.getBytes();
        try (FileOutputStream out = new FileOutputStream("D:\\Java3\\history.txt", true)){
            out.write(outDate);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

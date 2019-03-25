package ex2;

public class Matrix<T> {
    private T[] array;

    public Matrix(T[] array) {
        this.array = array.clone();
    }

    public static void main(String[] args) {
        //обобщения работают только с объектами и аргумент не может быть примитивом
        Matrix<Double> doubleMatrix = new Matrix<>(new Double[2]);
        Matrix<Integer> integerMatrix = new Matrix<>(new Integer[4]); //Integer аргумент типа
        Matrix<Byte> byteMatrix = new Matrix<>(new Byte[7]);
    }
}

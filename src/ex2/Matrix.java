package ex2;

public class Matrix<T> {
    private T[] array;

    public Matrix(T[] array) {
        this.array = array.clone();
    }

    public static void main(String[] args) {
        Matrix<Double> doubleMatrix = new Matrix<>(new Double[2]);
    }
}

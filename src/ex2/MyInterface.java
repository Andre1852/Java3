package ex2;

public interface MyInterface<T> {
    T someMethod(T t);
}

class MyClass<T> implements MyInterface<T> {
    @Override
    public T someMethod(T t) {
        return t;
    }

    public static void main(String[] args) {
        MyInterface<String> object = new MyClass<>();
        String str = object.someMethod("some string");
    }
}

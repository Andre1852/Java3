package ex2;

public class Average <T extends Number> {
    private T[] array;

    public Average(T[] array) {//конструктор
        this.array = array.clone();
    }

    public double average() {// можем работать с любым Number в этом методе
        double sum = 0.0;

        for (T value : array) {
            sum += value.doubleValue();
        }

        return sum / array.length;
    }

    boolean sameAvg(Average<?> ob){// ? - метосимвольный аргумент
        //(совпадает с любым достоверным значением класса Average)
        return average() == ob.average();//
    }
}



class BoundsDemo {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        Average<Integer> integerAverage = new Average<Integer>(intArray);
        double v = integerAverage.average();
        System.out.println("Integer average is " + v);

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Average<Double> doubleAverage = new Average<Double>(doubleArray);
        double w = doubleAverage.average();
        System.out.println("DoubleAverage is " + w);

//        String[] strs = {"1", "2", "3", "4", "5"};
//        //Average<Integer> strob = new Average<Integer>(strs);
//
//        //double x = strob.average();
//        System.out.println("strob average is " + v);

        //integerAverage посредством метода sameAvg сравнивают с аргументом метода
        System.out.println(integerAverage.sameAvg(doubleAverage));
    }
}

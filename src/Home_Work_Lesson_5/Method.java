package src.Home_Work_Lesson_5;

public class Method {
    static final int size = 10000000;
    static final int halfSize = size / 2;
    float[] arr = new float[size];
    float[] arr1 = new float[halfSize];
    float[] arr2 = new float[halfSize];


    public void methodOne() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, halfSize);
        System.arraycopy(arr, halfSize, arr2, 0, halfSize);

        FlowClass th1 = new FlowClass("Поток 1", arr1);
        FlowClass th2 = new FlowClass("Поток 2", arr2);


        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.arraycopy(arr1, 0, arr, 0, halfSize);
        System.arraycopy(arr2, 0, arr, halfSize, halfSize);

        System.currentTimeMillis();
        System.out.println("Время работы метода 1: " + (System.currentTimeMillis() - a));
    }

    public void methodTwo() {
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr [ i ] = ( float )( arr [ i ] * Math . sin ( 0.2f + i / 5.0 ) * Math . cos ( 0.2f + i / 5.0 ) *
                    Math . cos ( 0.4f + i / 2.0 ));
        }

        System.currentTimeMillis();
        System.out.println("Время работы метода 2: " + (System.currentTimeMillis() - a));
    }

}

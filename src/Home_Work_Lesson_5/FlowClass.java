package src.Home_Work_Lesson_5;

public class FlowClass extends Thread {
    private String name;
    private float [] arr;

    FlowClass(String threadname, float[]arr) {
        name = threadname;
        this.arr = arr;
    }

    @Override
    public void run() {
        for ( int i = 0 ; i < arr.length ; i ++) {
            arr [ i ] = ( float )( arr [ i ] * Math . sin ( 0.2f + i / 5.0 ) * Math . cos ( 0.2f + i / 5.0 ) *
                    Math . cos ( 0.4f + i / 2.0 ));
        }
    }
}

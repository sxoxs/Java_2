package logik.lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson5 {
    private static final int SIZE = 10000000;
    private  float[] arr = new float[SIZE];

    public void go() {
        System.out.println("Последовательный перерасчет");
        fillinger();
        long time = System.currentTimeMillis();
        recalculation(arr);
        System.out.println("Время перерасчета массива составило: " + (System.currentTimeMillis()-time) + " mc");
//        System.out.println(Arrays.toString(arr));


        for (int i = 2; i <= 100; i++) {
            System.out.println("Потоков " + i);
            fillinger();
            time = System.currentTimeMillis();
            recalculation(arr, i);
            System.out.println("Время перерасчета массива составило: " + (System.currentTimeMillis()-time) + " mc");
//        System.out.println(Arrays.toString(arr));

//            !!! Вопрос: почему при 5-6 потоках, в польшинстве случаях,
//             получается самое большое время работы? не беря во внимание 2 потока
//          В голову приходит только то, что время обработки массивов 1/(5) длинны
//            большого массива всё ещё большое и сопоставимо с временем разбиения большого массива на мелкие, тогда
//            когда время разбиения на 2-3 малое и этим невилирует время обработки, в то время когда при большом количестве потоков
//                    время обработки невилирует время разбиения
//
        }
    }

    private void recalculation(float[] array, int flow) {
        ArrayList<float[]> arrays = new ArrayList<float[]>();
        int countInArray = (int) SIZE/flow;
        int countInLastArray = SIZE - countInArray*(flow-1);

        for (int i = 1; i <= flow; i++) {
            if (i != flow) {
                arrays.add(new float[countInArray]);
                System.arraycopy(array, countInArray*(i-1), arrays.get(i-1), 0, countInArray);
            }
            else {
                arrays.add(new float[countInLastArray]);
                System.arraycopy(array, countInArray*(i-1), arrays.get(i-1), 0, countInLastArray);
            }
        }
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < flow; i++) {
            threads.add(new Thread(new MyThread(arrays.get(i))));
            threads.get(i).start();
        }

        for (int i = 0; i < flow; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= flow; i++) {
            if (i != flow) {
                arrays.add(new float[countInArray]);
                System.arraycopy(arrays.get(i-1), 0, arr, countInArray*(i-1), countInArray);
            }
            else {
                arrays.add(new float[countInLastArray]);
                System.arraycopy(arrays.get(i-1), 0, arr, countInArray*(i-1), arrays.get(i-1).length);
            }
        }
    }

    public void recalculation(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private void fillinger(){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    private class MyThread implements Runnable {
        private float[] arrayInThread;

        public MyThread(float[] array) {
            arrayInThread = array;
        }

        public void run() {
            recalculation();
        }

        private synchronized float[] recalculation() {
            for (int i = 0; i < arrayInThread.length; i++) {
                arrayInThread[i] = (float)(arrayInThread[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            return arrayInThread;
        }
    }

}

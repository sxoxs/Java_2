package logik;

import logik.dopTask2.DopTask1;
import logik.dopTask2.DopTask2;
import logik.lesson2.Lesson2;

//не стал делать много менюшек для выбора заданий, т.к. сейчас совсем нет времени на дз
public class Main {

    public static void main(String[] args) {
        new Lesson2().go();
        new DopTask1().go();
        new DopTask2().go();

    }
}

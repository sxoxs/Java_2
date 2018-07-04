package logik.lesson2;

public class MyArrayDataException extends Exception {
    private int num1, num2;

    public MyArrayDataException(String msg, int num1, int num2) {
        super(msg);
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}

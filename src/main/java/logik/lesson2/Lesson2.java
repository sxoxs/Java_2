package logik.lesson2;

//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива
// другого размера необходимо бросить исключение MyArraySizeException.
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException, и вывести результат расчета.


public class Lesson2 {

    public void go(){
        String[][] stringsArray = new String[4][];
        stringsArray[0] = new String[]{"l", "2", "3", "4"};
        stringsArray[1] = new String[]{"5", "6", "7", "8"};
        stringsArray[2] = new String[]{"l", "2", "3", "4"};
        stringsArray[3] = new String[]{"5", "6", "7", "8"};

        try {
            sumArray(stringsArray);
        }
        catch (MyArraySizeException mse){
            System.out.println(mse.getMessage());
        }
        catch (MyArrayDataException mde){
            System.out.print(mde.getMessage() + " {" + mde.getNum1() + "} {" + mde.getNum2() + "}");
        }
    }

    private void sumArray(String[][] strArr) throws MyArraySizeException, MyArrayDataException {
        isValidSize(strArr);
        System.out.println(Summer(strArr));
    }

    private int Summer(String[][] strArr) throws MyArrayDataException {
        int summ = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                try {
                    summ += Integer.parseInt(strArr[i][j]);
                }
                catch (Exception e){
                    throw new MyArrayDataException("Неправильные данные в ячейке", i, j);
                }
            }
        }
        return summ;
    }

    private void isValidSize(String[][] strArr) throws MyArraySizeException {
        if (strArr.length != 4) {
            throw new MyArraySizeException("Массив не размера 4*4");
        }
        for (String[] str : strArr) {
            if (str.length != 4) {
                throw new MyArraySizeException("Массив не размера 4*4");
            }
        }
    }
}

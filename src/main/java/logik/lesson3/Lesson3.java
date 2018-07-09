package logik.lesson3;

import java.util.HashMap;

public class Lesson3 {
    public void goTelBook(){
        TelephoneBook telBook = new TelephoneBook();
        telBook.setNumber("Petrov", "10000000001");
        telBook.setNumber("Ivanov", "20000000001");
        telBook.setNumber("Sidorov", "30000000001");
        telBook.setNumber("Dmitrov", "30000000001");
        telBook.setNumber("Ivanov", "20000000002");
        telBook.setNumber("Ivanov", "20000000003");
        telBook.setNumber("Petrov", "10000000002");

        telBook.getNumber("Petrov");
        telBook.getNumber("Ivanov");
        telBook.getNumber("Dmitrov");
        telBook.getNumber("Dmitrovich");
    }

    public void goWords(){
        String[] strArr = {"A", "A", "B", "A", "C", "D", "G", "S", "W", "S", "A", "F", "W", "S", "S",
                "F", "A", "W", "D", "A"};

        Integer res;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String str : strArr) {
            res = hm.get(str);
            hm.put(str, res == null ? 1 : res+1);
        }

        System.out.println(hm);
    }
}

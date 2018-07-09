package logik.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneBook {
    private HashMap<String, ArrayList<String>> telephoneBookHashMap = new HashMap<String, ArrayList<String>>();

    public void setNumber(String name, String telNumber){
        ArrayList<String> al = new ArrayList<String>();
        if (telephoneBookHashMap.containsKey(name)) {
            al = (ArrayList<String>) telephoneBookHashMap.get(name).clone();
        }
        al.add(telNumber);
        telephoneBookHashMap.put(name, al);
    }

    public void getNumber(String name) {
        if (telephoneBookHashMap.containsKey(name)){
            System.out.println("name " + name + " tel: " + telephoneBookHashMap.get(name) );
        }
        else {
            System.out.println("Запись \"" +name + "\" не найдена");
        }
    }
}

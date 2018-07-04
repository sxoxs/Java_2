package logik.dopTask2;

import java.util.Scanner;

enum enumIndexBMI {
    UNDER_WEIGHT("under"), NORMAL_WEIGHT("normal"), OVER_WEIGHT("over"), OBESITE("obese");

    private String description;

    enumIndexBMI(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class DopTask2 {

    public void go(){
        double height;
        double weight;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вес");
        weight = sc.nextDouble();
        System.out.println("Введите рост");
        height = sc.nextDouble();

        calculationBMI(weight, height);
    }

    private void calculationBMI(double weight, double height) {
        double indexBMI = weight / Math.pow(height, 2);

        if (indexBMI < 18.5) {
            System.out.println(enumIndexBMI.UNDER_WEIGHT.getDescription());
        }
        else{
            if (indexBMI < 25.0){
                System.out.println(enumIndexBMI.NORMAL_WEIGHT.getDescription());
            }
            else {
                if (indexBMI < 30.0) {
                    System.out.println(enumIndexBMI.OVER_WEIGHT.getDescription());
                }
                else {
                    System.out.println(enumIndexBMI.OBESITE.getDescription());
                }
            }
        }
    }
}

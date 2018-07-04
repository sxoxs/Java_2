package logik.dopTask2;

enum DayOfWeek {
    MONDAY(1, 8.5), TUESDAY(2, 8.5), WEDNESDAY(3, 8.5), THURSDAY(4, 8.5),
    FRIDAY(5, 7.5), SATURDAY(6, 0), SUNDAY(7, 0);

    private int index;
    private double countWorkHours;

    DayOfWeek(int index, double countWorkHours) {
        this.index = index;
        this.countWorkHours = countWorkHours;
    }

    public int getIndex() {
        return index;
    }

    public double getCountWorkHours() {
        return countWorkHours;
    }
}

public class DopTask1 {

    public void go(){
        getWorkingHours(DayOfWeek.MONDAY);
    }

    private void getWorkingHours(DayOfWeek dayOfWeek) {
        double workingHourse = 0;
        switch (dayOfWeek.getIndex()){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:{

                for (int i = dayOfWeek.getIndex(); i <= 5; i++) {
                    workingHourse += DayOfWeek.values()[i].getCountWorkHours();

                }
                System.out.println("Осталось проработать " +  workingHourse + " часов");
                break;
            }
            case 6:
            case 7: {
                System.out.println("Сегодня выходной!!!");
                break;
            }
        }


    }

}

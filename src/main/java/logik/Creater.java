package logik;

public class Creater {

    public void go(){
        Team team = new Team();
        createTeam(team);
        Course course = new Course();
        createCourse(course);
        course.doIt(team);
    }

    private void createCourse(Course course) {
        course.addObstacle(new Cross(5000));
        course.addObstacle(new Wall(3));
        course.addObstacle(new Pool(300));
    }

    private void createTeam(Team team) {
       team.addComprtitor(new Human("Боб", 10000, 1000, 2));
       team.addComprtitor(new Human("Луи", 11000, 800, 3));
       team.addComprtitor(new Human("Иван", 12000, 850, 2));
       team.addComprtitor(new Cat("Барсик", 3000, 200,10));
       team.addComprtitor(new Cat("Мурзик", 2500, 150,8));
       team.addComprtitor(new Cat("Марфа", 3500, 200,12));
       team.addComprtitor(new Dog("Чарли", 7000, 500, 5));
       team.addComprtitor(new Dog("Джек", 17000, 600, 4));
       team.addComprtitor(new Dog("Бобик", 10000, 700, 3));
    }


}

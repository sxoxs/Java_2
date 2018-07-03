package logik;

import java.util.ArrayList;

public class Course {
    private ArrayList<Obstacle> obstacleArrayList = new ArrayList<Obstacle>();

    public <E extends Obstacle> void addObstacle(E obstacle){
        obstacleArrayList.add(obstacle);
    }

    public void doIt(Team team){
        for (Comtetitor c: team.getComtetitorArrayList()) {
            for (Obstacle o: obstacleArrayList) {
                o.doIt(c);
                if (!c.isOnDistance()){
                    System.out.println("сошел!");
                    break;
                }

                c.info();
            }

        }
    }
}

package logik;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Comtetitor comtetitor) {
        comtetitor.jump(height);
    }
}

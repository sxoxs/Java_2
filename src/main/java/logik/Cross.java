package logik;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Comtetitor comtetitor) {
        comtetitor.run(length);
    }
}

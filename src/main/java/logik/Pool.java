package logik;

public class Pool extends Obstacle{
    int length;

    public Pool(int length) {
        this.length = length;
    }

    public void doIt(Comtetitor comtetitor) {
        comtetitor.swim(length);
    }
}

package Home_work_lesson1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getLenght() {
        return 0;
    }

    public void wallInfo() {
        System.out.println("Высота стены " + height + " метров");
    }

    public void trackInfo() {
    }

    public void start(Participant participant) {
        participant.jump(new Wall(height));
    }

}

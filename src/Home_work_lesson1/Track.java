package Home_work_lesson1;

public class Track implements Obstacle {
    private int lenght;

    public Track(int lenght) { this.lenght = lenght; }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() { return 0; }

    public void trackInfo() { System.out.println("Длина трассы " + lenght + " метров"); }

    public void wallInfo() {}

    public void start(Participant participant) {
        participant.run(new Track(lenght));
    }
}

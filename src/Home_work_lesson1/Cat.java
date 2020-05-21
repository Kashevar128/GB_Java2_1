package Home_work_lesson1;

public class Cat implements Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean wellDone = true;

    public Cat (String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void runInfo() {
        System.out.println("Кот может пробежать " + runLimit + " метров" );
    }

    @Override
    public void jumpInfo() {
        System.out.println("Кот может подпрыгнуть на " + jumpLimit + " метров");
    }

    @Override
    public void run (Track track){
        if (runLimit >= track.getLenght()) {
            System.out.println("Кот сумел пробежать дистанцию");
        }
        else {
            System.out.println("Кот не смог пробежать дистанцию");
            wellDone = false;
        }
    }

    @Override
    public void jump (Wall wall) {
        if (jumpLimit >= wall.getHeight()) {
            System.out.println("Кот сумел перепрыгнуть стену");
        }
        else {
            System.out.println("Кот не смог перепрыгнуть стену");
            wellDone = false;
        }
    }

    public boolean succes() {
        return wellDone;
    }
}

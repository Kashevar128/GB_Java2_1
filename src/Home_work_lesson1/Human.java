package Home_work_lesson1;

public class Human implements Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean wellDone = true;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void runInfo() {
        System.out.println("Человек может пробежать " + runLimit + " метров" );
    }

    @Override
    public void jumpInfo() {
        System.out.println("Человек может подпрыгнуть на " + jumpLimit + " метров");
    }

    @Override
    public void run (Track track){
        if (runLimit >= track.getLenght()) {
            System.out.println("Человек сумел пробежать дистанцию");
        }
        else {
            System.out.println("Человек не смог пробежать дистанцию");
            wellDone = false;
        }
    }

    @Override
    public void jump (Wall wall) {
        if (jumpLimit >= wall.getHeight()) {
            System.out.println("Человек сумел перепрыгнуть стену");
        }
        else {
            System.out.println("Человек не смог перепрыгнуть стену");
            wellDone = false;
        }
    }

    public boolean succes() {
        return wellDone;
    }
}


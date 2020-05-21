package Home_work_lesson1;

public class Robot implements Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean wellDone = true;

    public Robot(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public int getRunLimit(){
        return runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public void runInfo() {
        System.out.println("Робот может пробежать " + runLimit + " метров");
    }

    @Override
    public void jumpInfo() {
        System.out.println("Робот может подпрыгнуть на " + jumpLimit + " метров");
    }

    @Override
    public void run (Track track){
        if (runLimit >= track.getLenght()) {
            System.out.println("Робот сумел пробежать дистанцию");
        }
        else {
            System.out.println("Робот не смог пробежать дистанцию");
            wellDone = false;
        }
    }

    @Override
    public void jump (Wall wall) {
        if (jumpLimit >= wall.getHeight()) {
            System.out.println("Робот сумел перепрыгнуть стену");
        }
        else {
            System.out.println("Робот не смог перепрыгнуть стену");
            wellDone = false;
        }
    }

    public boolean succes() {
        return wellDone;
    }
}

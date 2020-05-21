package Home_work_lesson1;

public class Human implements Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void runInfo() {
        System.out.println("Человек побежал и смог пробежать " + runLimit + " метров" );
    }

    @Override
    public void jumpInfo() {
        System.out.println("Человек подпрыгнул на " + jumpLimit + " метров");
    }

    @Override
    public void run (Track track){
        if (runLimit >= track.getLenght()) {
            System.out.println("Человек сумел пробежать дистанцию");
        }
        else {
            System.out.println("Человек не смог пробежать дистанцию");
        }
    }

    @Override
    public void jump (Wall wall) {
        if (jumpLimit >= wall.getHeight()) {
            System.out.println("Человек сумел перепрыгнуть стену");
        }
        else {
            System.out.println("Человек не смог перепрыгнуть стену");
        }
    }
}


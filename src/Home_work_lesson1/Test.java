package Home_work_lesson1;

public class Test {
    public static void main(String[] args) {

        Participant[] arrayParticipiants = {
                new Human ("Voldemar", 800, 1),
                new Cat ("Пушистик", 100, 3),
                new Robot ("R2-D2", 5000, 10)
        } ;
        System.out.println("ВОЗМОЖНОСТИ УЧАСТНИКОВ: ");
        arrayParticipiants[0].runInfo();
        arrayParticipiants[0].jumpInfo();
        arrayParticipiants[1].runInfo();
        arrayParticipiants[1].jumpInfo();
        arrayParticipiants[2].runInfo();
        arrayParticipiants[2].jumpInfo();
        System.out.println("---------------------------");


        Obstacle[] arrayObstacles = {
                new Track (400),
                new Wall (2),
                new Track(1000),
                new Wall(5)
        };

        System.out.println("ОБЗОР ПОЛОСЫ ПРЕПЯТСТВИЙ:");
        arrayObstacles[0].trackInfo();
        arrayObstacles[1].wallInfo();
        arrayObstacles[2].trackInfo();
        arrayObstacles[3].wallInfo();
        System.out.println("---------------------------");
        System.out.println("СТАРТ:");


        for (int i = 0; i < arrayParticipiants.length; i++) {
            for (int j = 0; j < arrayObstacles.length; j++) {
                arrayObstacles[j].start((Participant) arrayParticipiants[i]);
                if(arrayParticipiants[i].succes() == false) {
                    break;
                }
            }
        }

    }
}

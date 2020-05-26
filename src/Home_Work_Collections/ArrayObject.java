package src.Home_Work_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayObject {

    public static void main(String[] args) {
        String[] objects = {"тарелка", "люстра", "стул", "чайник", "очки", "стол", "стул", "графин",
                "стол", "вентилятор", "монитор", "вентилятор", "стол"};
        System.out.println("Список предметов: " + Arrays.toString(objects));

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            Boolean replayWord = false;
            String word = objects[i];
            for (int j = 0; j < arrayList.size(); j++) {
                if (word.equals(arrayList.get(j)) == true) {
                    replayWord = true;
                    break;
                }
            }
            if (replayWord == false) {
                arrayList.add(word);
            }
        }
        System.out.println("Список уникальных предметов: " + arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            int counterWord = 0;
            String word = arrayList.get(i);
            for (int j = 0; j < objects.length; j++) {
                if (word.equals(objects[j]) == true) {
                    counterWord++;
                }
            }
            System.out.println(word + " встречается в списке предметов " + counterWord + " раз");
        }
    }

}

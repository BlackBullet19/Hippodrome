package ArrayListHW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        MainApp main = new MainApp();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(main.randomValue());
        }

        Collections.sort(list1);

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(main.randomValue());
        }

        Collections.sort(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.addAll(list1);
        list3.addAll(list2);

        Collections.sort(list3);

        System.out.println();
        for (Integer value : list3) {
            System.out.println(value);
        }
    }

    private int randomValue() {
        return (int) (Math.random() * 100);
    }
}

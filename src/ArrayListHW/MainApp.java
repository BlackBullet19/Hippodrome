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
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list2.add(main.randomValue());
        }
        Collections.sort(list2);
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
        main.listAddAndSort(list1, list2, list3);

        System.out.println(list3);
    }

    private int randomValue() {
        return (int) (Math.random() * 100);
    }

    private void listAddAndSort(List<Integer> list1, List<Integer> list2, List<Integer> list3) {

        int listPosIndex1 = 0;
        int listPosIndex2 = 0;
        for (int i = 0; i < (list1.size() + list2.size()); i++) {
            if (listPosIndex1 >= list1.size() && listPosIndex2 < list2.size()) {
                list3.add(list2.get(listPosIndex2++));
            } else if (listPosIndex2 >= list2.size() && listPosIndex1 < list1.size()) {
                list3.add(list1.get(listPosIndex1++));
            } else if (list1.get(listPosIndex1) <= list2.get(listPosIndex2)) {
                list3.add(list1.get(listPosIndex1++));
            } else {
                list3.add(list2.get(listPosIndex2++));
            }
        }
    }
}



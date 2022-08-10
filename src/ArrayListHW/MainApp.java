package ArrayListHW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class MainApp {
    public static void main(String[] args) {

        MainApp main = new MainApp();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            list1.add(main.randomValue());
        }

        Collections.sort(list1);
        for (Integer element : list1) {
            System.out.print(element + " ");
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            list2.add(main.randomValue());
        }

        System.out.println();
        Collections.sort(list2);
        for (Integer element : list2) {
            System.out.print(element + " ");
        }

        List<Integer> list3 = new ArrayList<>();
        main.listAddAndSort(list1, list2,list3);

        System.out.println();
        for (Integer value : list3) {
            System.out.print(value + " ");
        }
    }

    private int randomValue() {
        return (int) (Math.random() * 100);
    }

    private void listAddAndSort(List<Integer> list1, List<Integer> list2,List<Integer> list3) {
        ListIterator<Integer> listIterator1 = list1.listIterator();
        ListIterator<Integer> listIterator2 = list2.listIterator();
        int listPosIndex1 = 0;
        int listPosIndex2 = 0;
        for (int i = 0; i < (list1.size() + list2.size()); i++) {
            if (!listIterator1.hasNext() && listIterator2.hasNext()) {
                list3.add(list2.get(i - listPosIndex2));
                listIterator2.next();
            } else if (listIterator1.hasNext() && !listIterator2.hasNext()) {
                list3.add(list1.get(i - listPosIndex1));
                listIterator1.next();
            } else if (list1.get(i - listPosIndex1) <= list2.get(i - listPosIndex2) && listIterator2.hasNext()) {
                list3.add(list1.get(i - listPosIndex1));
                listPosIndex2++;
                listIterator1.next();
            } else if (list2.get(i - listPosIndex2) < list1.get(i - listPosIndex1) && listIterator1.hasNext()) {
                list3.add(list2.get(i - listPosIndex2));
                listPosIndex1++;
                listIterator2.next();
            }
        }
    }
}



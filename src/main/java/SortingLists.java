import java.util.ArrayList;
import java.util.List;

public class SortingLists {

    public List<Integer> selectionSort(List<Integer> list) {
        System.out.println("Starting SelectionSort:");
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    swapElements(list, i, j);
                }
            }
        }
        System.out.println("End of iteration: ");
        return list;
    }

    private void swapElements(List<Integer> list, int i, int j) {
        int aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);
    }

    public List<Integer> bubbleSort(List<Integer> list) {
        System.out.println("Starting BubbleSort:");
        boolean hasSwapped = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1) > list.get(j)) {
                    swapElements(list, j - 1, j);
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) {
                break;
            }
        }
        System.out.println("End of iteration: ");
        return list;
    }


    public List<Integer> insertionSort(List<Integer> list) {
        System.out.println("Starting InsertionSort:");
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    swapElements(list, j, j - 1);
                } else {
                    break;
                }
            }
        }
        System.out.println("End of iteration.");
        return list;
    }

    public List<Integer> mergeSort(List<Integer> integerList) {
        if (integerList.size() == 1) {
            return integerList;
        }
        Integer midIndex = (integerList.size() / 2) + (integerList.size() % 2);
        List<Integer> firstHalf = mergeSort(integerList.subList(0, midIndex));
        List<Integer> secondHalf = mergeSort(integerList.subList(midIndex, integerList.size()));

        return merge(firstHalf, secondHalf);
    }

    private List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf) {
        Integer firstHalfIndex = 0;
        Integer secondHalfIndex = 0;
        Integer mergeIndex = 0;
        List<Integer> listToSort = new ArrayList<Integer>();
        while(firstHalfIndex<firstHalf.size() && secondHalfIndex<secondHalf.size()){
            if(firstHalf.get(firstHalfIndex)<secondHalf.get(secondHalfIndex)){
                listToSort.add(firstHalf.get(firstHalfIndex++));
            }else if(secondHalfIndex < secondHalf.size()){
                listToSort.add(secondHalf.get(secondHalfIndex++));
            }
            mergeIndex++;
        }
        if(firstHalfIndex < firstHalf.size()){
            while (mergeIndex < firstHalf.size() + secondHalf.size()){
                listToSort.add(firstHalf.get(firstHalfIndex++));
                mergeIndex++;
            }
        }
        if(secondHalfIndex < secondHalf.size()){
            while (mergeIndex < firstHalf.size() + secondHalf.size()){
                listToSort.add(secondHalf.get(secondHalfIndex++));
                mergeIndex++;
            }
        }
        return listToSort;
    }
}

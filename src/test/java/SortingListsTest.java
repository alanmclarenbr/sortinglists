import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class SortingListsTest {

    private SortingLists sortingLists = new SortingLists();
    private static List<Integer> preShuffledList = newArrayList();
    private static List<Integer> integerList = newArrayList();
    private static List<Integer> sortedList = newArrayList();

    @BeforeClass
    public static void init(){
        for(int i=0;i<100;i++) {
            integerList.add(i+1);
            sortedList.add(i+1);
        }
        preShuffledList.addAll(integerList);
        Collections.shuffle(preShuffledList);
    }

    @Before
    public void setup(){
        integerList.clear();
        integerList.addAll(preShuffledList);
    }

    @Test
    public void testSelectionSort(){
        assertThat(sortingLists.selectionSort(integerList))
                .containsExactlyElementsOf(sortedList);
    }

    @Test
    public void testBubbleSort(){
        assertThat(sortingLists.bubbleSort(integerList))
                .containsExactlyElementsOf(sortedList);
    }

    @Test
    public void testInsertionSort(){
        assertThat(sortingLists.insertionSort(integerList))
                .containsExactlyElementsOf(sortedList);
    }

    @Test
    public void testMergeSort(){
        assertThat(sortingLists.mergeSort(integerList))
                .containsExactlyElementsOf(sortedList);
    }

}
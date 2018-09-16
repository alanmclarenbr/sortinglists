import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingListsTest {

    private SortingLists sortingLists = new SortingLists();
    private static List<Integer> preShuffledList = Lists.newArrayList();
    private static List<Integer> integerList = Lists.newArrayList();
    private static List<Integer> sortedList = Lists.newArrayList();

    @BeforeClass
    public static void init(){
        Random random = new Random();
        for(int i=0;i<100000;i++) {
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

}
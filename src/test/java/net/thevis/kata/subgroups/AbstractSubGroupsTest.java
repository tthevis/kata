package net.thevis.kata.subgroups;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public abstract class AbstractSubGroupsTest {

    private SubGroups<Integer> fixture;

    abstract SubGroups<Integer> createFixture();

    @Before
    public void setUp() throws Exception {
        this.fixture = createFixture();
    }

    @Test
    public void getSubGroupsForSingleElementList() {
        Iterator<List<Integer>> iterator = this.fixture.getSubGroups(asList(1), 1).iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(asList(1)));
        assertThat(iterator.hasNext(), is(false));
    }


    @Test
    public void getSubGroupsForTwoElementList_1() {
        Iterable<List<Integer>> subGroups = this.fixture.getSubGroups(asList(1, 2), 1);
        compareGroups(subGroups, asList(asList(1), asList(2)));
    }

    @Test
    public void getSubGroupsForThreeElementList_1() {
        Iterable<List<Integer>> subGroups = this.fixture.getSubGroups(asList(1, 2, 3), 1);
        compareGroups(subGroups, asList(asList(1), asList(2), asList(3)));
    }

    @Test
    public void getSubGroupsForThreeElementList_2() {
        Iterable<List<Integer>> subGroups = this.fixture.getSubGroups(asList(1, 2, 3), 2);
        compareGroups(subGroups, asList(asList(1, 2), asList(1, 3), asList(2, 3)));
    }

    @Test
    public void getSubGroupsForThreeElementList_3() {
        Iterable<List<Integer>> subGroups = this.fixture.getSubGroups(asList(1, 2, 3), 3);
        compareGroups(subGroups, asList(asList(1, 2, 3)));
    }

    @Test
    public void getSubGroups_checkNumberOfElements() {
        Iterable<List<Integer>> subGroups = this.fixture.getSubGroups(asList(1, 2, 3, 4, 5), 3);
        int numberOfElements = 0;
        for (List<Integer> element : subGroups) {
            numberOfElements++;
        }
        assertThat(numberOfElements, is(10));
    }

    void compareGroups(Iterable<List<Integer>> actual, List<List<Integer>> expected) {
        LinkedHashSet<List<Integer>> actualResult = new LinkedHashSet<>();
        for (List<Integer> currentList : actual) {
            actualResult.add(currentList);
        }
        LinkedHashSet<List<Integer>> expectedResult = new LinkedHashSet<>();
        expectedResult.addAll(expected);
        assertThat(actualResult, is(expectedResult));
    }
}
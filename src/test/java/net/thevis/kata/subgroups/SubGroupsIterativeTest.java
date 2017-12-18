package net.thevis.kata.subgroups;


public class SubGroupsIterativeTest extends AbstractSubGroupsTest {

    @Override
    SubGroups<Integer> createFixture() {
        return new SubGroupsIterative<>();
    }
}
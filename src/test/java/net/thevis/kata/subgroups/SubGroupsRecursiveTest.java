package net.thevis.kata.subgroups;


public class SubGroupsRecursiveTest extends AbstractSubGroupsTest {

    @Override
    SubGroups<Integer> createFixture() {
        return new SubGroupsRecursive<>();
    }
}
package net.thevis.kata.subgroups;

import java.util.Collections;
import java.util.List;

public abstract class AbstractSubGroups<T> implements SubGroups<T> {

    public Iterable<List<T>> getSubGroups(final List<T> inputData, final int groupSize) {
        if (groupSize <= 0) {
            throw new IllegalArgumentException("groupSize must be strictly positive");
        }
        if (inputData.size() < groupSize) {
            return Collections.EMPTY_LIST;
        }

        return computeSubGroups(inputData, groupSize);
    }

    abstract Iterable<List<T>> computeSubGroups(final List<T> inputData, final int groupSize);

}

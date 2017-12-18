package net.thevis.kata.subgroups;

import java.util.List;

public interface SubGroups<T> {

    Iterable<List<T>> getSubGroups(final List<T> inputData, final int groupSize);
}

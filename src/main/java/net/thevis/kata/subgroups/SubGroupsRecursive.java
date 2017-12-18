package net.thevis.kata.subgroups;

import java.util.LinkedList;
import java.util.List;

public class SubGroupsRecursive<T> extends AbstractSubGroups<T> implements SubGroups<T> {

    Iterable<List<T>> computeSubGroups(final List<T> inputData, final int groupSize) {
        List<List<T>> results = new LinkedList<>();
        collectSubGroupsRec(inputData, results, groupSize, new LinkedList<>(), 0);
        return results;
    }

    private void collectSubGroupsRec(List<T> originalData, List<List<T>> results, int groupSize,
                             List<T> subGroup, int index) {
        if (subGroup.size() == groupSize) {
            results.add(subGroup);
            return;
        }
        for (int i = index; i < originalData.size(); ++i) {
            List<T> subGroupCopy = new LinkedList<>(subGroup);
            subGroupCopy.add(originalData.get(i));
            collectSubGroupsRec(originalData, results, groupSize, subGroupCopy,i+1);
        }
    }
}

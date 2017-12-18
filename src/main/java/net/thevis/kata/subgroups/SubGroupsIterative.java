package net.thevis.kata.subgroups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SubGroupsIterative<T> extends AbstractSubGroups<T> implements SubGroups<T> {

    @Override
    Iterable<List<T>> computeSubGroups(List<T> inputData, int groupSize) {
        return new Iterable<List<T>>() {
            @Override
            public Iterator<List<T>> iterator() {
                return new GroupIterator(inputData, groupSize);
            }
        };
    }

    static class GroupIterator<T> implements Iterator<List<T>> {

        private final int[] indices;
        private final List<T> originalData;
        private boolean noMoreElements;

        GroupIterator(List<T> inputData, int groupSize) {
            this.originalData = inputData;
            this.indices = new int[groupSize];
            for (int i = 0; i < groupSize; ++i) {
                indices[i] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return !this.noMoreElements;
        }

        @Override
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<T> result = getCurrentElement();
            advance();
            return result;
        }

        private void advance() {
            for (int i = 1; i <= indices.length; ++i) {
                int idx = indices[indices.length - i];
                if (idx < originalData.size() - i) {
                    for (int j = 0; j < i; j++) {
                        indices[indices.length - i + j] = idx + 1 + j;
                    }
                    return;
                }
            }
            this.noMoreElements = true;
        }

        private List<T> getCurrentElement() {
            ArrayList<T> result = new ArrayList<>();
            for (int i = 0; i < indices.length; ++i) {
                result.add(this.originalData.get(indices[i]));
            }
            return result;
        }
    }

}

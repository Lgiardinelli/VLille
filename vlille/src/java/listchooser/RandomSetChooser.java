package listchooser;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomSetChooser<T> implements SetChooser<T> {
    private static final Random RANDOM = new Random();

    @Override
    public T choose(Set<? extends T> set) {
        Random random = new Random();
        int r = random.nextInt(set.size());
        if (set.isEmpty()) {
            return null;
        }
        for (int i=0; i<r-1; i++)
            set.iterator().next();
        return set.iterator().next();
    }
}

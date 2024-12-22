package listchooser;


import java.util.Set;

public interface SetChooser<T> {

    T choose(Set<? extends T> set);
}

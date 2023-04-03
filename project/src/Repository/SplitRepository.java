package Repository;

import Model.Split;

import java.util.*;

public class SplitRepository implements IRepository<Split>{
    List<Split> splitList = new ArrayList<Split>();

    @Override
    public void add(Split object) {
        splitList.add(object);
    }

    @Override
    public Split get(UUID id) {
        return splitList.stream().filter(e -> e.getIdSplit() == id).findAny().get();
    }

    @Override
    public List<Split> getAll() {
        return splitList;
    }

    @Override
    public void delete(UUID id) {
        splitList.removeIf(s -> s.getIdSplit() == id);
    }
}

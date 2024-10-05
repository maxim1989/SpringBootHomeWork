package pro.sky.mlfedorov.sandbox.skyshop;

import java.util.List;

public interface BasketService {
    void add(List<Integer> ids);

    List<Integer> get();
}

package pro.sky.mlfedorov.sandbox.services;

import java.util.List;

public interface BasketService {
    void add(List<Integer> ids);

    List<Integer> get();
}

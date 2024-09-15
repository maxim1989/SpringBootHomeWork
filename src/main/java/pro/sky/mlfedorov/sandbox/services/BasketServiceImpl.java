package pro.sky.mlfedorov.sandbox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.sandbox.entities.ProductBasket;

import java.util.Collections;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private ProductBasket productBasket;

    @Override
    public void add(List<Integer> ids) {
        productBasket.setProducts(ids);
    }

    @Override
    public List<Integer> get() {
        return Collections.unmodifiableList(productBasket.getProducts());
    }
}

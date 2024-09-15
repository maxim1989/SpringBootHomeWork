package pro.sky.mlfedorov.sandbox.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mlfedorov.sandbox.services.BasketService;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final BasketService basketService;

    public StoreController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/order/add")
    public void add(@RequestParam() List<Integer> ids) {
        basketService.add(ids);
    }

    @GetMapping("/order/get")
    public List<Integer> get(Model model) {
        return basketService.get();
    }
}

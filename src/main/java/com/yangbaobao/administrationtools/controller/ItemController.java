package com.yangbaobao.administrationtools.controller;

import com.yangbaobao.administrationtools.entities.Item;
import com.yangbaobao.administrationtools.javabeans.Response;
import com.yangbaobao.administrationtools.repositories.ItemRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @ResponseBody
    @GetMapping("/admin/getItems")
    public String getItems() {
        List<Item> items = itemRepository.findAll();
        return generateResponse(items);
    }

    @ResponseBody
    @GetMapping("/admin/getItemById")
    public String getItemById(@RequestParam(name = "term") Integer id) {

        List<Item> item = itemRepository.findAllById(id);
        return generateResponse(item);
    }

    @ResponseBody
    @GetMapping("/admin/getItemsByTitle")
    public String getItemsByTitle(@RequestParam(name="term") String title) {
        List<Item> items = itemRepository.findAllByTitleContains(title);
        return generateResponse(items);
    }
    @ResponseBody
    @GetMapping("/admin/getItemsByDescription")
    public String getItemsByDescription(@RequestParam(name = "term") String description) {
        List<Item> items = itemRepository.findAllByDescriptionContains(description);
        return generateResponse(items);
    }
    @ResponseBody
    @GetMapping("/admin/getItemsByTitleOrDescription")
    public String getItemsByTitleOrDescription(@RequestParam(name = "term") String searchTerm) {
        List<Item> items = itemRepository.findAllByTitleContainsOrDescriptionContains(searchTerm, searchTerm);
        return generateResponse(items);
    }

    @ResponseBody
    @GetMapping("/admin/getItemsByCategory")
    public String getItemsByCategory(@RequestParam(name = "term") String category) {
        List<Item> items = itemRepository.findAllByCategoryContains(category);
        return generateResponse(items);
    }

    private String generateResponse(List<Item> item) {
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("success");
        response.setTotal(item.size());
        response.setData(item);
        return new JSONObject(response).toString();
    }
}


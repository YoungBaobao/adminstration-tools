package com.yangbaobao.administrationtools.controller;

import com.yangbaobao.administrationtools.entities.Item;
import com.yangbaobao.administrationtools.repositories.ItemRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yangbaobao.administrationtools.utils.ResponseUtils.*;

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

    @ResponseBody
    @GetMapping("/admin/deleteItem/{id}")
    public String deleteItemById(@PathVariable(name = "id") Integer id) {
        itemRepository.deleteById(id);
        return generateNonDataSuccessResponse();
    }

    @ResponseBody
    @GetMapping("/admin/{id}/updateStatus")
    public String updateItemStatusById(@PathVariable(name = "id") Integer id, @RequestParam("status") Integer status) {
        itemRepository.updateItemStatusById(status, id);
        List<Item> items = itemRepository.findAllById(id);
        return generateResponse(items);
    }

    //TODO: current 403
    @PostMapping("/admin/save")
    public String saveItem(Item item) {
        itemRepository.saveAndFlush(item);
        return generateNonDataSuccessResponse();
    }









}


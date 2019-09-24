package com.yangbaobao.administrationtools.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.yangbaobao.administrationtools.entities.Item;
import com.yangbaobao.administrationtools.repositories.ItemRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @ResponseBody
    @GetMapping("/admin/getItems")
    public String getItems() {
        List<Item> items = itemRepository.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", items);
        return jsonObject.toString();
    }

}

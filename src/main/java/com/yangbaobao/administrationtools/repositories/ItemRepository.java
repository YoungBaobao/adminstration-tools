package com.yangbaobao.administrationtools.repositories;

import com.yangbaobao.administrationtools.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllById(Integer id);
    List<Item> findAllByTitleContains(String title);
    List<Item> findAllByDescriptionContains(String description);
    List<Item> findAllByTitleContainsOrDescriptionContains(String title, String description);
    List<Item> findAllByCategoryContains(String category);

    @Modifying@Transactional
    @Query("update Item item set item.status=:status where item.id=:id")
    void updateItemStatusById(Integer status, Integer id);
}

package com.yangbaobao.administrationtools.repositories;

import com.yangbaobao.administrationtools.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

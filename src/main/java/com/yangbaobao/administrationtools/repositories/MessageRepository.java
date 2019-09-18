package com.yangbaobao.administrationtools.repositories;

import com.yangbaobao.administrationtools.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramesh Fadatare
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

}

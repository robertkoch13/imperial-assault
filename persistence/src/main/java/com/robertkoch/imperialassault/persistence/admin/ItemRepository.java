package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/22.
 */
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findByName(String name);
}

package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.AgendaCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/22.
 */
public interface AgendaCardRepository extends JpaRepository<AgendaCard, String> {
    AgendaCard findByName(String name);
}

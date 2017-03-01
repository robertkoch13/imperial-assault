package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/17.
 */
public interface ExpansionRepository extends JpaRepository<Expansion, String> {
    Expansion findByName(String name);
}

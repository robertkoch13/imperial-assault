package com.robertkoch.imperialassault.persistence.login;

import com.robertkoch.imperialassault.domain.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/15.
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsername(String username);
}

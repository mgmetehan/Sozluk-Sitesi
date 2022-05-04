package com.Dona.SozlukSitesi.repository;

import com.Dona.SozlukSitesi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

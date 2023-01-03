package com.spring.jpa.repository;


import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spring.jpa.user.DemoUser;




@Repository
public interface DemoUserRepository extends CrudRepository<DemoUser, UUID> {

}


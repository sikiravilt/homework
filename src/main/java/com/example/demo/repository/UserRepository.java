package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
List<User> findByName(String name);

    @Modifying
    @Query("update user_data u set u.name = :name where u.id = :id")
    void updateUser(@Param(value = "id") int id, @Param(value = "name") String name, @Param(value = "lastName") String lastName,@Param(value = "mobile") String mobile);
}

package com.basics.springboot.basics.repository;

import com.basics.springboot.basics.dto.UserDTO;
import com.basics.springboot.basics.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("select u from User u Where u.email=?1")
    Optional<User> findByUserEmail(String email);
@Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

//With Query Methods
    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);

    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    @Query("SELECT new com.basics.springboot.basics.dto.UserDTO( u.name, u.birthDate)" +
            " FROM User u " +
            " WHERE u.birthDate=:dateParameter " +
            " and u.email=:emailParameter")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("dateParameter")LocalDate date, @Param("emailParameter")String email);
}

package com.projectFuture.propertyRepairWebApp.repository;

import com.projectFuture.propertyRepairWebApp.domain.User;
import com.projectFuture.propertyRepairWebApp.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByVat(String vat);

    Optional<List<User>> findAllByUserType(UserType userType);

    Optional<User> findByVatAndEmail(String vat, String email);

    Optional<User> findUserById(Long id);
}

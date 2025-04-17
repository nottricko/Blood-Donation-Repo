package com.blood_donation_backend.Repository;

import com.blood_donation_backend.Entity.UserEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
    Optional <UserEntity> findByFirebaseUid(String firebaseUid);
    boolean existsByEmail(String email);

}

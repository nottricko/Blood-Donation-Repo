package com.dioquino.demo.Repository;

import com.dioquino.demo.Entity.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonorRepository extends JpaRepository<DonorEntity, Integer> {



    DonorEntity findByUser_UserId(int userId);

}

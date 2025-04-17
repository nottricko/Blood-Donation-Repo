    package com.dioquino.demo.Repository;

    import com.dioquino.demo.Entity.RecipientEntity;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Date;
    import java.util.List;
    @Repository
    public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {
        // Change from findByRequestDate to findByDateNeededBy
        List<RecipientEntity> findByDateNeededBy(Date dateNeededBy);
    }


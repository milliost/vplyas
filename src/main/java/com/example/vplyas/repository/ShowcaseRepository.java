package com.example.vplyas.repository;

import com.example.vplyas.entity.Showcase;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRepository extends JpaRepository<Showcase, UUID> {

  Optional<Showcase> findById(UUID id);
}

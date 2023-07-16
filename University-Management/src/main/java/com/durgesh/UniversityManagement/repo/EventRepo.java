package com.durgesh.UniversityManagement.repo;

import com.durgesh.UniversityManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Integer> {
}

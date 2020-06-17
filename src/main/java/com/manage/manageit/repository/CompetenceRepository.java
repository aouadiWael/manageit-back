package com.manage.manageit.repository;

import com.manage.manageit.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:39
 */
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}

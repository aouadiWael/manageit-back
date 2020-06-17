package com.manage.manageit.repository;

import com.manage.manageit.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:39
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}

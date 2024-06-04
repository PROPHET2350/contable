package com.contable.backoffice.companies.leads.infrastructure.persistence;

import com.contable.backoffice.companies.leads.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAImplLeadsRepository extends JpaRepository<Lead, String> {
}

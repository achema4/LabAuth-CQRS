package com.lab.write.repository;

import com.lab.write.entity.StudentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<StudentEntity> {

    public StudentEntity findWithMatriculas(String id) {
        return find("""
            select distinct s
            from StudentEntity s
            left join fetch s.matriculaciones
            where s.id = ?1
            """, id)
                .firstResult();
    }

    public List<StudentEntity> findAllWithMatriculas() {
        return find("""
            select distinct s
            from StudentEntity s
            left join fetch s.matriculaciones
            """).list();
    }
}
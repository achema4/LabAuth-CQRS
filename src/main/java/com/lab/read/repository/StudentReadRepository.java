package com.lab.read.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.read.entity.StudentView;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.mapdb.DB;
import org.mapdb.HTreeMap;

import java.util.List;

@ApplicationScoped
public class StudentReadRepository {

    private HTreeMap<String, String> students;

    @Inject
    DB db;

    @Inject
    ObjectMapper mapper;

    @PostConstruct
    void init() {
        students = db
                .hashMap("students",
                        org.mapdb.Serializer.STRING,
                        org.mapdb.Serializer.STRING
                )
                .createOrOpen();
    }

    public void save(StudentView view) {
        try {
            String json = mapper.writeValueAsString(view);
            students.put(view.id(), json);
            db.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public StudentView findById(String id) {
        try {
            String json = students.get(id);
            if (json == null) return null;
            return mapper.readValue(json, StudentView.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentView> findAll() {
        return students.values()
                .stream()
                .map(json -> {
                    try {
                        return mapper.readValue(json, StudentView.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
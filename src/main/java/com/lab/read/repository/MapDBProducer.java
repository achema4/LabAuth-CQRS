package com.lab.read.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.mapdb.DB;
import org.mapdb.DBMaker;

@ApplicationScoped
public class MapDBProducer {

    @Produces
    @ApplicationScoped
    public DB mapDB() {
        return DBMaker
                .fileDB("data/read-db.db")
                .fileMmapEnableIfSupported()
                .transactionEnable()
                .make();
    }
}
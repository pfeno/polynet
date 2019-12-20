package com.polytech.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
/*
    void save(Story story) throws SQLException;
    List<Story> fetchAll();
    List<Story> fetchLimit(int skip, int limit);
*/


}

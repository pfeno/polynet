package com.polytech.data;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRepositories { //implements StoryRepository {
/*
    private DataSource dataSource;

    public JdbcRepositories(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Story story) throws SQLException {
        Connection conn = dataSource.getConnection();
        String insert = "insert into story (content) values (?)";
        PreparedStatement stmt = conn.prepareStatement(insert);
        stmt.setString(1, story.getContent());
        stmt.executeUpdate();
    }

    @Override
    public List<Story> fetchAll() {
        List<Story> database = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String select = "select horodate, content from story order by horodate desc";
            PreparedStatement stmt = conn.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                database.add(new Story(rs.getTimestamp("horodate"), rs.getString("content")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return database;
    }

    @Override
    public List<Story> fetchLimit(int skip, int limit) {
        List<Story> database = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String select = "select horodate, content from story order by horodate desc limit ? offset ?" ;
            PreparedStatement stmt = conn.prepareStatement(select);
            stmt.setInt(1, limit);
            stmt.setInt(2, skip);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                database.add(new Story(rs.getTimestamp("horodate"), rs.getString("content")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return database;
    }

 */
}

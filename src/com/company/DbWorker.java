package com.company;

import java.sql.*;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "nurmira82";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addNews(String headline, String news_text) {
        String SQL = "insert into subject(id, name) values(?, ?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = connect().prepareStatement(SQL)) {
            preparedStatement.setString(1, headline);
            preparedStatement.setString(2, news_text);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void showNews() {
        String SQL = "select n.news_text, n.published_time from news n";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteNews(int id) {
        String SQL = "delete from News  where id= ? ;";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateNews(String headline, String news_text, int id) {
        String SQL = "update News set headline = ?, news_text = ? where id=?";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setString(1, headline);
            preparedStatement.setString(2, news_text);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

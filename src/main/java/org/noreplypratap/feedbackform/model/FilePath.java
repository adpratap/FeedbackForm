package org.noreplypratap.feedbackform.model;

public class FilePath {
    private int id;
    private String filePath;
    private int userId;

    // Methods
    public FilePath() {
    }

    public FilePath(int id, String filePath, int userId) {
        this.id = id;
        this.filePath = filePath;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FilePath{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

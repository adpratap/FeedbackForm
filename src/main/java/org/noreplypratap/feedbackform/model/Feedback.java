package org.noreplypratap.feedbackform.model;

public class Feedback {
    private int id;
    private String message;
    private int userId;

   // methods
    public Feedback() {
    }

    public Feedback(int id, String feedbackData, int userId) {
        this.id = id;
        message = feedbackData;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FeedbackData{" +
                "id=" + id +
                ", FeedbackData='" + message + '\'' +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

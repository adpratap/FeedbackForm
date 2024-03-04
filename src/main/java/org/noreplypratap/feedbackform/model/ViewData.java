package org.noreplypratap.feedbackform.model;

import org.springframework.web.multipart.MultipartFile;

public class ViewData {
    private int id;
    private String fullName;
    private String email;
    private long phoneNumber;
    private String gender;
    private String state;
    private String city;
    private int pinCode;
    private String message;
    private String filePath;
    private MultipartFile file;

    public ViewData() {
    }

    public ViewData(int id, String fullName, String email, long phoneNumber, String gender, String state, String city, int pinCode, String message) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.message = message;
    }

    public ViewData(int id, String fullName, String email, long phoneNumber, String gender, String state, String city, int pinCode, String message, String filePath, MultipartFile file) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.message = message;
        this.filePath = filePath;
        this.file = file;
    }

    public ViewData(int id, String fullName, String email, long phoneNumber, String gender, String state, String city, int pinCode, String message, String filePath) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.message = message;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "ViewData{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", message='" + message + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

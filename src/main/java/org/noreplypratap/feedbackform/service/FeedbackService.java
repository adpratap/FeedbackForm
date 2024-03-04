package org.noreplypratap.feedbackform.service;

import org.noreplypratap.feedbackform.model.ViewData;
import org.noreplypratap.feedbackform.repository.FeedbackRepository;
import org.noreplypratap.feedbackform.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository repository;

    public boolean saveFeedbackData(ViewData viewData) {
        viewData.setId(getMaxId()+1);
        viewData.setFilePath(saveDocument(viewData.getFile()));

        return repository.createUserData(viewData);
    }

    public List<ViewData> readAllData() {
        return repository.readAllData();
    }

    public ViewData readDataById(int id) {
        return repository.readDataById(id);
    }
    private Integer getMaxId() {
        return repository.getMaxId()+1;
    }

    public Boolean deleteById(int id) {
        String fileName =  readDataById(id).getFilePath();
        Boolean status = deleteDocument(fileName);
        return repository.deleteById(id) == 1 && status;
    }

    public String saveDocument(MultipartFile file) {
        String randomFilename = null;
        if (!file.isEmpty()) {
            try {

                String originalFilename = file.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));
                randomFilename = generateRandomString() + fileExtension;

                // Set the destination directory
                String uploadDirectory = Constants.path;
                Files.createDirectories(Paths.get(uploadDirectory)); // Create the directory if it doesn't exist

                // Construct the destination file path
                String destinationPath = uploadDirectory + randomFilename;

                // Save the file
                byte[] bytes = file.getBytes();
                Files.write(Paths.get(destinationPath), bytes);


            } catch (IOException e) {
                e.printStackTrace(); // Handle the IOException appropriately
            }
        }
        return randomFilename;
    }

    private Boolean deleteDocument(String fileName) {
        String filePath = Constants.path+fileName;
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public ResponseEntity<InputStreamResource> downloadFile(String fileName) {

        String filePath = Constants.path+fileName; // Replace with your actual file path

        try {
            // Load the file from the file system
            File file = new File(filePath);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentLength(file.length());
            headers.setContentDispositionFormData("attachment", fileName);

            // Return the file as a response entity
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }

    public String generateRandomString() {
        int length = 18;
        final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC.length());
            char randomChar = ALPHANUMERIC.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public boolean updateFeedbackData(ViewData viewData) {
        return repository.updateUserData(viewData);
    }
}

package com.vali.admission_statistics.service;


import com.vali.admission_statistics.entity.Student;
import com.vali.admission_statistics.persist.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.vali.admission_statistics.Utils.customDoubleParser;


@Slf4j
@Service
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    private int counter = 0;
    private int fileNumber = 0;

    @Autowired
    StudentRepository studentRepository;

    public void loadStudents() {

        String folderPath = "src/main/resources/2023";
        processFolder(folderPath, 2023);

        log.info("File processed for 2023: " + fileNumber);
        log.info("Inserted students for 2023: " + counter);

        counter = 0;
        fileNumber = 0;
        folderPath = "src/main/resources/2022";
        processFolder(folderPath, 2022);
        log.info("File processed for 2022: " + fileNumber);
        log.info("Inserted for 2022: " + counter);

    }

    private void processFolder(String folderPath, int year) {
        try {
            // Convert the string path to a Path object
            Path path = Paths.get(folderPath);

            // Check if the path exists and is a directory
            if (Files.exists(path) && Files.isDirectory(path)) {
                // Use DirectoryStream to list all files in the directory
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                    for (Path file : stream) {
                        // Print the file name
                        writeToDB(file.toAbsolutePath().toString(), year);
                        fileNumber++;
                    }
                }
            } else {
                log.warn("The specified path is not a directory or does not exist.");
            }
        } catch (IOException e) {
            log.error("Error processing folder" , e);
        }
    }


    private void writeToDB(String fileName, int year) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            // Process each line
            for (String line : lines) {
                // Split the line by the delimiter (semicolon)
                String[] values = line.split(";");

                // Ensure the line has the correct number of values (13 in this case)
                if (values.length == 13) {
                    // Create a new Student object with the values
                    Student student = new Student(
                            values[0],
                            values[1],
                            customDoubleParser(values[2]),
                            customDoubleParser(values[5]),
                            customDoubleParser(values[12]),
                            year);

                    studentRepository.save(student);
                    counter ++;
                }
            }

        } catch (IOException e) {
            log.error("Error loading file:" + fileName, e);
        }

    }

}

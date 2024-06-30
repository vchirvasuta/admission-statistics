package com.vali.admission_statistics.service;

import com.vali.admission_statistics.Utils;
import com.vali.admission_statistics.entity.HighSchool;
import com.vali.admission_statistics.entity.Student;
import com.vali.admission_statistics.persist.HighSchoolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class HighSchoolService {

    private static final Logger log = LoggerFactory.getLogger(HighSchoolService.class);



    @Autowired
    HighSchoolRepository highSchoolRepository;

    public final String DATA_2024 = "src/main/resources/highschool/2024.csv.txt";
    public final String DATA_2023 = "src/main/resources/highschool/2023.csv.txt";



    public void loadHighSchool() {
        writeToDB(DATA_2023, 2022);
        writeToDB(DATA_2024, 2023);

    }

    private void writeToDB(String file, int year) {

        int counter = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            // Process each line
            for (String line : lines) {
                counter ++;
                // Split the line by the delimiter (semicolon)
                String[] values = line.split(";");

                // Ensure the line has the correct number of values (6 in this case)
                if (values.length == 6) {

                    // Create a new Highschool object with the values
                    HighSchool highSchool = new HighSchool(
                            values[0],
                            values[1],
                            Utils.customDoubleParser(values[2]),
                            Utils.customIntegerParser(values[3]),
                            Utils.customIntegerParser(values[4]),
                            Utils.customDoubleParser(values[5]),
                            year
                    );

                    highSchoolRepository.save(highSchool);

                } else {
                    log.warn("Issue at line:" + counter);
                }
            }

        } catch (IOException e) {
            log.error("Error loading file:" + file, e);
        }

        log.info("Loaded {} line for file {}", counter, file);

    }
}



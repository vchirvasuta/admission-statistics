package com.vali.admission_statistics.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HighSchoolServiceTest {


    @InjectMocks
    private HighSchoolService highSchoolService;

    @Test
    public void testLoadHighSchool() {
        highSchoolService.loadHighSchool();
    }

}
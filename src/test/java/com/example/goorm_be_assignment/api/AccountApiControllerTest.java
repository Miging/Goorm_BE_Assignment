package com.example.goorm_be_assignment.api;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.goorm_be_assignment.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@WebMvcTest(controllers = AccountApiContorller.class)
@MockBean(JpaMetamodelMappingContext.class)
public class AccountApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterService registerService;

    @Test
    @Transactional
    public void 수강신청_성공() throws Exception{

        Register registerData=new Register(1,1,1,1,"complete");

        given(registerService.register()).willReturn(registerData);

        mockMvc.perform(get("/course")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].student_id").value("Math"))
                .andExpect(jsonPath("$[0].course_").value(4))
                .andExpect(jsonPath("$[0].professor").value("John"))
                .andExpect(jsonPath("$[0].capacity").value(45))
                .andExpect(jsonPath("$[1].name").value("English"))
                .andExpect(jsonPath("$[1].time").value(5))
                .andExpect(jsonPath("$[1].professor").value("Henson"))
                .andExpect(jsonPath("$[1].capacity").value(50));
    }
}

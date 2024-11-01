package com.example.goorm_be_assignment.api;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.example.goorm_be_assignment.entity.Course;
import com.example.goorm_be_assignment.service.CourseService;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Acs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;


@WebMvcTest(controllers = CourseController.class)
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void 강의목록_조회() throws Exception {
        List<Course> courses=new ArrayList<>();
        courses.add(new Course(null,"Math",4,"John",45,null,null));
        courses.add(new Course(null,"English",5,"Henson",50,null,null));

        given(courseService.getCourses()).willReturn(courses);


        mockMvc.perform(get("/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Math")))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Math"))
                .andExpect(jsonPath("$[0].rating").value(4))
                .andExpect(jsonPath("$[0].instructor").value("John"))
                .andExpect(jsonPath("$[0].duration").value(45))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("English"))
                .andExpect(jsonPath("$[1].rating").value(5))
                .andExpect(jsonPath("$[1].instructor").value("Henson"))
                .andExpect(jsonPath("$[1].duration").value(50));
    }
    @Test
    public void 강의목록_조회_에러_사용자_권한없음() throws Exception {

        given(courseService.getCourses()).willThrow(new AccessDeniedException("권한이 없습니다"));

        mockMvc.perform(get("/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
    @Test
    public void 강의목록_조회_에러_강의가_0개인경우() throws Exception {
        List<Course> emptyCourses = new ArrayList<>();
        given(courseService.getCourses()).willReturn(emptyCourses);

        mockMvc.perform(get("/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // 빈 목록이므로 200 OK
                .andExpect(content().json("[]")); // 빈 배열 반환
    }
}

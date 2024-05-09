package Servlet;

import Service.StudentService;
import Service.TeacherService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "studentController", value = "/private/student-form")
public class StudentController extends HttpServlet {
    @Inject
    private StudentService service;
    @Inject
    private TeacherService teacherService;

}
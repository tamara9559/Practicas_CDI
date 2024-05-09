package Servlet;

import Service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.StudentDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name= "studentId", value="/student-formId")
public class StudentId extends HttpServlet {
    @Inject
    private StudentService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        Connection conn = (Connection) req.getAttribute("conn");
        ServletInputStream JsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        StudentDTO studentDto = mapper.readValue(JsonStream,StudentDTO.class);
        int id = studentDto.id();
        service.byId(id);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Students</h1>");
        out.println(service.byId(id));
        out.println("</body></html>");
    }
}

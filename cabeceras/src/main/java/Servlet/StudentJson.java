package Servlet;

import Model.Student;
import Service.StudentImpl;
import Service.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.StudentDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentJson {
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Obtener datos JSON
            ServletInputStream jsonStream = req.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(jsonStream, Student.class);

            // Configurar respuesta HTTP como HTML
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                // Generar respuesta HTML con los detalles del producto
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Detalle de producto desde json</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Detalle de producto desde json!</h1>");
                out.println("<ul>");
                out.println("<li>Id: "+ student.getId() + "</li>");
                out.println("<li>Nombre: " + student.getName() + "</li>");
                out.println("<li>Tipo: " + student.getEmail() + "</li>");
                out.println("<li>Precio: " + student.getSemester() + "</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            StudentImpl service = new StudentServiceImpl();
            // Obtener datos de estudiantes
            List<StudentDTO> students = service.listar();

            // Convertir lista de estudiantes a JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(students);

            // Configurar respuesta HTTP como JSON
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }
    }





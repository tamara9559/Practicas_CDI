package Service.impl;


import Service.Repository;
import Service.StudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapping.StudentDTO;

import java.sql.Connection;


@ApplicationScoped
public class StudentServiceImpl implements StudentService {
    @Inject
    private Repository<StudentDTO> studentRepository;
}


package mapping;

import Model.Student;

public class StudentMapper {

    public static Student mapFrom(StudentDTO dto){
        return new Student(dto.id(),dto.name(), dto.email(),dto.semester());
    }
    public static StudentDTO mapFrom(Student student){
        return new StudentDTO(student.getId(),student.getName(), student.getEmail(), student.getSemester());
    }
}

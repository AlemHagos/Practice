package edu.miu.cs544;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;

    public Student addStudent(Student student) {
        Optional<Student> studentOptional =
                studentDao.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        return studentDao.save(student);
    }

    public List<Student> getAll() {
        return studentDao.findAll();
    }

    public Student getStudentById(Integer studentId) {
        return studentDao.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with id " + studentId + " doesn't exists!"));
    }

    public void deleteStudentById(Integer studentId) {
        boolean exists = studentDao.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " doesn't exists!");
        }
        studentDao.deleteById(studentId);

    }

    @Transactional
    public void update(Integer studentId, String name, String email) {

        Student student = studentDao.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with id " + studentId + " doesn't exists!"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional =
                    studentDao.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}

package com.scasp.core.interfaces;

import com.scasp.core.Student;
import java.util.List;

public interface StudentRepositoryInterface {

    void save(Student student);

    void delete(Student student);

    List<Student> findAll();

    int count();
}
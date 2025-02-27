package com.desabisc.udemy.chad.jpa.dao;

import com.desabisc.udemy.chad.jpa.entity.Student;
import java.util.List;

public interface StudentDAO {
  void save (Student student);
  Student findById(Integer id);
  List<Student> findAll();
  List<Student> findByLastName(String theLastName);
}

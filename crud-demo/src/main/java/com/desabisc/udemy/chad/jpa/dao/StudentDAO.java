package com.desabisc.udemy.chad.jpa.dao;

import com.desabisc.udemy.chad.jpa.entity.Student;

public interface StudentDAO {
  void save (Student student);
  Student findById(Integer id);
}

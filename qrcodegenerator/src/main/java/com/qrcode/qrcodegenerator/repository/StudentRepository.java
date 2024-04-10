package com.qrcode.qrcodegenerator.repository;

import com.qrcode.qrcodegenerator.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

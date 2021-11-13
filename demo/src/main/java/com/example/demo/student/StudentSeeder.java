package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentSeeder {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student samer = new Student(
                    "Samer Sacic",
                    "samer.sacic@email.com",
                    LocalDate.of(1992, Month.AUGUST, 14)
            );
            Student elma = new Student(
                    "Elma Mujic",
                    "elma.mujic@email.com",
                    LocalDate.of(1997, Month.SEPTEMBER, 26)
            );

            Student zekerijah = new Student(
                    "Zekerijah Sehic",
                    "zekarijah.sehic@email.com",
                    LocalDate.of(1992, Month.FEBRUARY, 13)
            );

            studentRepository.saveAll(
                    List.of(samer, elma, zekerijah)
            );
        };
    }
}

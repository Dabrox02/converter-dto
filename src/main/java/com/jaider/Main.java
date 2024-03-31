package com.jaider;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student student = new Student();
        student.nombre = "John";
        student.edad = 20;
        student.fechaNacimiento = LocalDate.of(2000, 5, 15);
        System.out.println("Entidad Origen");
        System.out.println(student);

        StudentDTO studentDTO = Converter.convertTo(student, StudentDTO.class);
        System.out.println("Entidad a DTO");
        System.out.println(studentDTO);

        studentDTO.setNombre("Pedro");
        Student secondStudent = Converter.convertTo(studentDTO, Student.class);
        System.out.println("DTO a Entidad");
        System.out.println(secondStudent);
    }
}
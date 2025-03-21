package com.example.learing.students;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyFirstController {

    private  final StudentRepository studentRepository;

    public MyFirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping("/student")
    public Student posta(@RequestBody Student abood){
        return studentRepository.save(abood);
    }


}

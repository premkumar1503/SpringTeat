package com.Prem.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.Prem")
@RestController
public class FirstSpring
{
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        Student prem = new Student("Prem",20,"SNR",16);
        Student muthu = new Student("Muthu",23,"UDB",12);
        Student mani = new Student("Mani",19,"TRICHY",11);
        students.add(prem);
        students.add(muthu);
        students.add(mani);
    }
  static class Student
    {
        private String name;
        private Integer age;
        private  String address;
        private Integer standard;

       public Student(){}

        public Student(String name, Integer age, String address, Integer standard) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.standard = standard;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public Integer getStandard() {
            return standard;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setStandard(Integer standard) {
            this.standard = standard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student studnt = (Student) o;
            return Objects.equals(name, studnt.name) && Objects.equals(age, studnt.age) && Objects.equals(address, studnt.address) && Objects.equals(standard, studnt.standard);
        }

        @Override
        public String toString() {
            return "Studnt{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", standard=" + standard +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, address, standard);
        }

    }
    public static void main(String[] args)
    {
        SpringApplication.run(FirstSpring.class, args);
    }
    @GetMapping("api/v1/students")
    public List<Student>getStudents()
    {
        return students;
    }

}




package com.json.practiceproblems.parsejsonandfilteronlythoserecordswhereagemorethan25;

import java.util.List;

public class PersonData {

        private String name;
        private String email;
        private int age;
        private List<String> subjects;

        // Default constructor (needed for Jackson)
        public PersonData() {}

    // Getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    // toString() to print Student details
        @Override
        public String toString() {
            return "StudentDetail { " +
                    "Name='" + name + '\'' +
                    ", Email='" + email + '\'' +
                    ", Age=" + age +
                    ", Subjects=" + subjects +
                    " }";
        }
    }


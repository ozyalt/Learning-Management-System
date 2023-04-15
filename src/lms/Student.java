//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 4
//ID : 1940715
//Date: 4/09/2020
//********************************//
package lms;

import java.util.ArrayList;
import java.util.Date;


public class Student extends UniversityMember {
    private Date birthDate;
    private char gender;
    private String faculty;
    private String  department;
    private String program;
    private Integer level;
    private String address;
    private ArrayList<CourseSession>courses;
    private ArrayList<TrainingSession>training_Sessions;
    

    public Student(Date birthDate, char gender, String faculty, String department, String program, Integer level, String address, String name, String id) {
        super(name, id);
        this.birthDate = birthDate;
        this.gender = gender;
        this.faculty = faculty;
        this.department = department;
        this.program = program;
        this.level = level;
        this.address = address;
        
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isAvailible(OnlineSession os){
        return true;
    }
    public ArrayList<CourseSession>getCourses(){
        return courses;
    }
    public void setCourses(ArrayList<CourseSession>courses){
        this.courses=courses;
    }

    public ArrayList<TrainingSession > getTraining_Sessions() {
        return training_Sessions;
    }

    public void setTraining_Sessions(ArrayList<TrainingSession> training_Sessions) {
        this.training_Sessions = training_Sessions;
    }@Override
    public String toString() {
      return"Student{" + "birthDate=" + birthDate + ", gender="+ gender + ", faculty=" + faculty + ", department=" + department + ", program=" + program + ", level=" + level + ", address= " + address + ", courses=" + courses + ", training_Sessions="+ training_Sessions + '}';
      
    }
 public String printSchedule(){
       return "";
   }
}

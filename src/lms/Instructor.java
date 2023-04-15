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


public class Instructor extends UniversityMember {
    private Date birthData;
    private char gender;
    private String degree;
    private String specialization;
    private String address;
    private boolean availabillity;
    private ArrayList<OnlineSession>current_Courses;

    public Instructor(Date birthData, char gender, String degree, String specialization, String address, boolean availabillity, String name, String id) {
        super(name, id);
        this.birthData = birthData;
        this.gender = gender;
        this.degree = degree;
        this.specialization = specialization;
        this.address = address;
        this.availabillity = availabillity;
        
    }

   
    

    public Date getBirthData() {
        return birthData;
    }

    public void setBirthData(Date birthData) {
        this.birthData = birthData;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailabillity() {
        return availabillity;
    }

    public void setAvailabillity(boolean availabillity) {
        this.availabillity = availabillity;
    }

    public ArrayList<OnlineSession> getCurrent_Courses() {
        return current_Courses;
    }

    public void setCurrent_Courses(ArrayList<OnlineSession> current_Courses) {
        this.current_Courses = current_Courses;
    }

    @Override
    public String toString() {
        
        return "Instructor{" + "birthData=" + birthData + ", gender=" + gender + ", degree=" + degree + ", specialization=" + specialization + ", address=" + address + ", availabillity=" + availabillity + ", current_Courses=" + current_Courses + '}';
    }

    public boolean isAvailable(OnlineSession os){
      return true;  
    }
    private boolean isAvailableHelper(OnlineSession CurrentOS,OnlineSession TobeAddedOS){
        return true;
    }
    
    
}

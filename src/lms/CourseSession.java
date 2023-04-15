//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 4
//ID : 1940715
//Date: 4/09/2020
//********************************//
package lms;

import java.util.Date;


public class CourseSession extends OnlineSession {
    private String code;
    private Integer miniLevel;
    private char type;
    private Integer capacity;

    public CourseSession(String code, Integer miniLevel, char type, Integer capacity, String name, String id, Date startingDate, Date endingDate, Double startingTime, Double endingTime) {
        super(name, id, startingDate, endingDate, startingTime, endingTime);
        this.code = code;
        this.miniLevel = miniLevel;
        this.type = type;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMiniLevel() {
        return miniLevel;
    }

    public void setMiniLevel(Integer miniLevel) {
        this.miniLevel = miniLevel;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }@Override

    public String getName() {
        return name;
    }@Override

    public void setName(String name) {
        this.name = name;
    }@Override

    public String getId() {
        return id;
    }@Override

    public void setId(String id) {
        this.id = id;
    }@Override

    public Date getStartingDate() {
        return startingDate;
    }@Override

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }@Override

    public Date getEndingDate() {
        return endingDate;
    }@Override

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }@Override

    public Double getStartingTime() {
        return startingTime;
    }@Override

    public void setStartingTime(Double startingTime) {
        this.startingTime = startingTime;
    }@Override

    public Double getEndingTime() {
        return endingTime;
    }@Override

    public void setEndingTime(Double endingTime) {
        this.endingTime = endingTime;
    }@Override
    public int compareTo(OnlineSession o){
        return (this.getStartingDate()).compareTo(o.getStartingDate());
        
    }@Override
    
    public String toString(){
     return "CourseSession{" + "code=" + code + ", minLevel=" +  miniLevel + ", type=" + type + ",capacity=" + capacity + '}';
    
    }
    
}

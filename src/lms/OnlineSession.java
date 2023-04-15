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


public abstract class OnlineSession implements Comparable<OnlineSession> {
    String name;
    String id;
    Date startingDate;
    Date endingDate;
    Double startingTime;
    Double endingTime;
    Instructor instructor;

    public OnlineSession(String name, String id, Date startingDate, Date endingDate, Double startingTime, Double endingTime) {
        this.name = name;
        this.id = id;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public OnlineSession(String name, Date startingDate, Date endingDate, Double startingTime, Double endingTime) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Double getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Double startingTime) {
        this.startingTime = startingTime;
    }

    public Double getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Double endingTime) {
        this.endingTime = endingTime;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
   public static OnlineSession findMatchingSession(ArrayList<OnlineSession>sessionsList,String id){
          for(int i = 0;i<sessionsList.size();i++){                                 
            if(sessionsList.get(i).getId().equals(id)){
                return sessionsList.get(i);  
            }                           
          } 
          OnlineSession Fail = new CourseSession("error", 1, 'e', 1, "error", "error", new Date(), new Date(), 1.5,  1.5); 
          
          
        return Fail ;
        
   }
   public int compareTo(TrainingSession o){
       return (this.getStartingDate()).compareTo(o.getStartingDate());
       
   }@Override
    public String toString(){
        
         return "OnlineSession{" + "name=" + name + ", id=" + id + ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", staringTime=" + startingTime + ", endingTime=" + endingTime + ", instructor=" + instructor + '}';
    }
    
    
}

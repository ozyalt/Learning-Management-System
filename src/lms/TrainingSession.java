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


public class TrainingSession extends OnlineSession {
    private ArrayList<String> requiredSkills;
    private static int trainingCounter;

    public TrainingSession( String name, String id, Date startingDate, Date endingDate, Double startingTime, Double endingTime,ArrayList<String> requiredSkills) {
        super(name, id, startingDate, endingDate, startingTime, endingTime);
        this.requiredSkills = requiredSkills;
        
        trainingCounter++;
    }

    
    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(ArrayList<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }@Override
     public int compareTo(OnlineSession o){
         
         return (this.getStartingDate()).compareTo(o.getStartingDate());
       
     }
    public String printTraining(){
        return  getName()+"        Training       "+getStartingDate()+"   "+getEndingDate()+"   "+getStartingTime()+" - "+getEndingTime();
        
    }@Override
    public String toString(){
     return "TrainingSession{" + "requiredSkills=" + requiredSkills + '}';
    }
    }
    
    


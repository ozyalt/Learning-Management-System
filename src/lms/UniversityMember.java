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


public abstract class UniversityMember {
    String name;
    String id;

    public UniversityMember(String name, String id) {
        this.name = name;
        this.id = id;
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
    public static  UniversityMember searchUniverstyMember(ArrayList<UniversityMember> membersList, String id){
        
        for(int i=0; i<membersList.size(); i++){
            if(membersList.get(i).getId().equals(id)){
                
                return membersList.get(i);
            }
            
        }
        UniversityMember not =new Instructor(new Date(),'e',"error","error","error",false,"error","error");
    
          return not;
    }@Override
    public String toString(){
        
        return "UniversityMember{" + "name=" + name + ", id=" + id + '}';
    }
 
}

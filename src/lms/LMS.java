//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 4
//ID : 1940715
//Date: 4/09/2020
//********************************//
package lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class LMS {

    static ArrayList<UniversityMember>memberList =new ArrayList<UniversityMember>();
    static ArrayList<OnlineSession> sessionsList = new ArrayList<OnlineSession>();
    
    // Main Method Cheack of files are there and entrire switch command //
    public static void main(String[] args) throws FileNotFoundException {
        String temp;
        File file = new File("input.txt");
        if (!file.exists()) {
        System.out.println("File Not availble");
        System.exit(0);
        }

        File fileo = new File("output.txt");
        PrintWriter writer = new PrintWriter(fileo);
        Scanner SC = new Scanner(file);
        
        
         writer.println("--------------- Welcome to Learning Management System (LMS) ---------------");
        String temper=SC.next();
        // Switch Comands to print cases
        while(true){
            switch (temper){
            case "AddInstructor": 
              Instructor temperM =getInstructor(SC);                    
               if(temperM.getAddress().equals("error"))                         
                  writer.println("The instructor is registered already, the ID is found in the system.");
                    else                                                       
                    {
                      memberList.add(temperM);                                 
                      writer.println("The instructor is successfully added.");
                    }
                break;
            case "AddStudent":
                
               Student tempest =getStudent(SC);                           
                 if(tempest.getAddress().equals("error"))                           
                        writer.println("The student is registered already, the ID is found in the system.");
                    else                                                       
                    {
                        memberList.add(tempest);                                 
                        writer.println("The student is successfully added.");
                    }
                 
                    break;
           
            case "AddCourse":
                
                CourseSession temperory = getCourse(SC);                
                    if(temperory.getId().equals("error"))                          
                        writer.println("The course is already added, the ID is found in the system.");
                    else                                                       
                    {
                        sessionsList.add(temperory);                                 
                        writer.println("The course is successfully added.");
                    }
                    
                break;
            case "AddTrainingSession":
                TrainingSession temps = getTraining(SC);                
                    if(temps.getId().equals("error"))                         
                        writer.println("The training session is already added, the ID is found in the system.");
                    else                                                       
                    {
                        
                        sessionsList.add(temps);                                 
                        writer.println("The training session is successfully added.");
                    }
                    
                break;
                
            case "AssignInstructor":
                writer.println(assigninstructor(SC));
                
                 break;
                
            case "RegisterStudent":
                writer.println(assignStudent(SC));
                    
                break;
            case "PrintSchedule":
               String Schedulle = printSchedule(SC).replaceAll(",", " LN " );
               Scanner PrintSchedules =new Scanner(Schedulle);
                while(PrintSchedules.hasNext()){
                      temper =PrintSchedules.next();
                      if(temper.equals("LN"))
                       writer.println("");
                      else
                     writer.print(temper.replaceAll("/", " "));
                    }
                    writer.println("");
                    
                    break;
            case "PrintSortSessions":
                  String Sort = PrintSortSessions(SC).replaceAll(",", " LN ");
                    Scanner SortPrint =new Scanner(Sort);
                    while(SortPrint.hasNext()){
                        temper =SortPrint.next();
                        if(temper.equals("LN"))
                            writer.println("");
                        else
                            writer.println(temper.replaceAll("/", " "));
                    }
                  writer.println("");
                 
                    break;
            case "Quit":
                writer.flush();
                writer.close();
                SC.close();
                System.exit(0);
                
                
        }
            temper = SC.next();

        
        }  
    }
    // Print entire Sort Sessions by using collection sort
    private static String PrintSortSessions(Scanner SC){
        
        ArrayList<String> main = new ArrayList<String>();
        main.add("------------------------------------------- Sessions Sorted by Date -----------");
        main.add("Session Name                ID        Starting Dates  time      Instructor   ");
        main.add("-----------------------------------------------------------------------------");
        
         Collections.sort(sessionsList);
        for(int i = 0;i<sessionsList.size();i++){
            if(sessionsList.get(i) instanceof TrainingSession){
                String StartingT =(""+sessionsList.get(i).getStartingTime()).replace(".", ":");
                String FinalT =(""+sessionsList.get(i).getEndingTime()).replace(".", ":");
                String Disp = String.format("%-20s%-21s%31s%7s%s%s%15s",sessionsList.get(i).getName(),sessionsList.get(i).getId(),sessionsList.get(i).getStartingDate(),StartingT," - ",FinalT,sessionsList.get(i).getInstructor().getName());
                 main.add(Disp);
            }
       
            
        
        }
         String Final = ""+main;
         
        return Final.replaceAll(" ", "/").replace("[", "").replace("]", "");
    }
    // Print Secdule of univercity member/Students
    private static String printSchedule(Scanner SC){
        
        String Id = SC.next();
        UniversityMember ourUniversityMember = UniversityMember.searchUniverstyMember(memberList ,Id);
        if(ourUniversityMember.getId().equals(" error") || ourUniversityMember instanceof  Instructor)
            
            return "LN student/does/not/exist" ;
         
        Student temper = (Student) ourUniversityMember; 
        
         ArrayList<String> MainC = new ArrayList<String>();
        MainC.add("------------------------- Schedule Details ------------------------");
        MainC.add("Students ID: "+temper.getId());
        MainC.add("Student Name: "+temper.getName());
        MainC.add("Student Level: "+temper.getLevel());
        MainC.add("------------------------------------------------------------------");
        MainC.add("Online Session   Type   Starting Date     Ending Date       Time");
        for(int i = 0 ; i<temper.getCourses().size();i++){
            MainC.add(temper.getCourses().get(i).getCode()+"          Course        "+temper.getCourses().get(i).getStartingDate()+"    "+ temper.getCourses().get(i).getEndingDate()+"   "+temper.getCourses().get(i).getStartingTime()+" - "+temper.getCourses().get(i).getEndingTime());
        }
        
        for(int i = 0 ; i<temper.getTraining_Sessions().size();i++){
            
          
            TrainingSession dexter = (TrainingSession)temper.getTraining_Sessions().get(i);
            
            MainC.add(dexter.printTraining());
        }
       MainC.add("------------------------------------------------------------------");
       MainC.add("Number of Courses: "+temper.getCourses().size());
       MainC.add("Remaining courses: "+ (6-temper.getCourses().size()));
       MainC.add("Number of training Session: "+temper.getTraining_Sessions().size());
       MainC.add("------------------------------------------------------------------");
        
        String Final = "" +MainC;
        
     return Final.replaceAll(" ", "/").replace("[", "").replace("]", "");
     
}     // Assign student and Arange by using array list//
    private static String assignStudent(Scanner SC){
        
          String sync =SC.nextLine().replaceAll(",", " ");                    
        Scanner write = new Scanner(sync);
        String Id = write.next();
        ArrayList<String> CList = new ArrayList<String>();
        
        int Dexter =0;
        ArrayList<CourseSession> Mcourse = new ArrayList<CourseSession>();
        ArrayList<TrainingSession>training_Sessions=new ArrayList<TrainingSession>();
        
        while(write.hasNext()){
            CList.add(write.next());
            for(int i = 0; i<sessionsList.size();i++){
               if(CList.get(Dexter).equals(sessionsList.get(i).getId())){
                  if(sessionsList.get(i) instanceof CourseSession){
                      Mcourse.add((CourseSession)sessionsList.get(i));
                        
                      break;
                    }
                    else
                    {
                      
                        training_Sessions.add((TrainingSession)sessionsList.get(i));
                        break;
                    }
                }
            }
        
            Dexter++;
        }
      int SDex=99;
        for(int i = 0;i<memberList.size();i++){
           if(Id.equals(memberList.get(i).getId()))
                
                SDex= i;
        }
        
        if(SDex==99)
            
          return "The Student with 190099 "+Id+" does not exist in the system";
        
        Student temper = (Student)memberList.get(SDex);
        for(int i = 0;i<Mcourse.size();i++){  
             if(Mcourse.get(i).getMiniLevel()>temper.getLevel())
                   
             return"The student cannot take the requested course";
            }
        
        
        if(CList.size()==6)
            
            return "the student exceeded the number of courses, you cannot register in course "+CList.get(0);
        
        
        for(int i = 0; i<Mcourse.size();i++){
           if(Mcourse.get(i).getCapacity()== 0)
                
            return "No available seats in course "+Mcourse.get(i).getId();
        }
        for(int i = 0;i<Mcourse.size();i++){
            
            for(int y = 0; y<sessionsList.size();y++){
              if(Mcourse.get(i).getId().equals(sessionsList.get(y).getId())){
                 Mcourse.get(i).setCapacity(Mcourse.get(i).getCapacity()-1);
                 sessionsList.set(y, Mcourse.get(i));
                    
                    break;
                }
                
            }
        }
        
     
       temper.setTraining_Sessions(training_Sessions);
       temper.setCourses(Mcourse);
       memberList.set(SDex, temper);
       
        return "";
}// Assign instructors and placing them in stages //
    private static String assigninstructor(Scanner SC){
         
         String display = SC.nextLine().replaceAll(",", " ");                   
        Scanner Ftext = new Scanner(display);                                  
        String IID = Ftext.next();                                 
        ArrayList<String> onlineID = new ArrayList<String>();           
        while (Ftext.hasNext()){                                        
            onlineID.add(Ftext.next());                              
        }
        
        ArrayList<OnlineSession> onlineFID = new ArrayList<OnlineSession>();
        for(int i = 0;i<onlineID.size();i++){                           
            for(int j = 0 ; j<sessionsList.size();j++){                        
                if(onlineID.get(i).equals(sessionsList.get(j).getId())){
                    onlineFID.add(sessionsList.get(j));                   
                }
            }
        }
        int instrucDex =0;
                                        
        int Stage = 0; 
        
        for(int i = 0;i<memberList.size();i++){                                  
          if(memberList.get(i).getId().equals(IID)){   
              
            Stage =1;                                                         
             instrucDex= i;  
                

              break;                                                          
            }
        }
        if(Stage==0)                                                              
            return"The Instructor with "+IID+" ID does not exist in the system";
        
        Instructor MainIn = (Instructor) memberList.get(instrucDex);  
        
      for(int i = 0;i<onlineFID.size();i++){                            
         if(onlineFID.get(i) instanceof CourseSession){                
            if(MainIn.getDegree().equals("PhD"))
                
                    continue;                                           
                else
                    return "The instructor with ID cannot teach a course";      
            }
         
            if(onlineFID.get(i) instanceof TrainingSession){              
                if(MainIn.getDegree().equals("PhD")||MainIn.getDegree().equals("master’s")||MainIn.getDegree().equals("bachelor’s"))
                    continue;                                                    
                else
                    
                return "The instructor with ID cannot teach a course";      
            }
        }
       ArrayList<OnlineSession> Current_Courses = MainIn.getCurrent_Courses();
       
        for(int i = 0; i<onlineFID.size();i++){                           
          if(Current_Courses.size()==4)      
              
           return "the number of courses for this instructor is above the allowed limit, you cannot assign this instructor the course "+onlineFID.get(i).getId();
            onlineFID.get(i).setInstructor(MainIn );                       
           Current_Courses.add(onlineFID.get(i));                       
            MainIn .setCurrent_Courses(Current_Courses);                         
            memberList.set(instrucDex, MainIn );                               
             
            for(int j = 0;j <sessionsList.size();j++){  
                
                if(sessionsList.get(j).getId().equals(onlineFID.get(i).getId())){
                    sessionsList.set(j, onlineFID.get(i));  
                    
                  break;                                                      
                }
                    
            }
        }  
        
        return "";     
                 
    }//Read Input file of training and use substring in date and time //
    
    private static TrainingSession getTraining(Scanner SC){
        
        String display = SC.nextLine().replaceAll(",", " ").replaceAll(":", "."); 
        Scanner Ftext = new Scanner(display);                                  
        String FName = Ftext.next();                                    
        String SName = Ftext.next();                                  
        String MName =FName+" "+SName;                                
        long firstDate = Ftext.nextLong();                                  
        Date MDate = new Date(firstDate);                               
        long lastDate = Ftext.nextLong();                                   
        Date EDate = new Date(lastDate);                                   
        double MTime = Ftext.nextDouble();                            
        double ETime = Ftext.nextDouble();                             
        ArrayList<String> requiredSkills = new ArrayList<String>();
        
        while(Ftext.hasNext()){
            
            requiredSkills.add(Ftext.next());
        }
        
        String ID=FName.substring(0,3)+ SName.substring(0,3)+firstDate+MTime;
      
        TrainingSession Tdexter = new TrainingSession(MName,ID,MDate,EDate,MTime,ETime,requiredSkills); 
                                        
        if(isUnique(Tdexter )==false){                                             
            Tdexter .setId("error");                                             
            return Tdexter ;                                                       
        }
        
        
        return Tdexter;
    }// Read from input file and use substring //
    private static CourseSession getCourse(Scanner SC){
        String display =SC.nextLine().replaceAll(",", " ").replaceAll(":", ".");
        Scanner Ftext =new Scanner(display);                                 
        String codes =Ftext.next();                                         
        String FName =Ftext.next();                                    
        String SName =Ftext.next();                                  
        String Mname =FName+" "+SName;                                
        long firstDate =Ftext.nextLong();                                 
        Date MDate = new Date(firstDate);                               
        long EDate = Ftext.nextLong();                                    
        Date LastDate = new Date(EDate);                                   
        double MTime =Ftext.nextDouble();                            
        double ETime =Ftext.nextDouble();                            
        Integer miniLevel =Ftext.nextInt();                                 
        char type =Ftext.next().charAt(0);                                
        Integer size =Ftext.nextInt();                                 
        String ID=FName.substring(0,3)+SName.substring(0,3)+firstDate+MTime;
       
         CourseSession tempers = new CourseSession(codes,miniLevel,type,size,Mname,ID,MDate,LastDate,MTime, ETime);
                                     
        if(isUnique(tempers)==false){                                             
            tempers.setId("error");  
            
            return tempers;                                                       
        }
        return tempers;
    }// Read from input file and use arraylist to set training session //
    private static Student getStudent(Scanner SC){
         String display =SC.nextLine().replaceAll(",", " ");                   
        Scanner Ftext =new Scanner(display);                                  
        String name =Ftext.next();                                        
        name = name +" "+Ftext.next();                                      
        String ID =Ftext.next();                                          
        long Time =Ftext.nextLong();                                        
        Date BirthDate =new Date(Time);                                        
        char Gender =Ftext.next().charAt(0);                               
        String Faculty =Ftext.next();                                      
        String Department =Ftext.next();                                   
        String Program =Ftext.next();                                     
        int Level =Ftext.nextInt();                                        
        String Address =Ftext.nextLine();                                 
        
     Student Final = new Student(BirthDate,Gender,Faculty,Department,Program,Level,Address,name,ID);                             
        if(isUnique(Final)==false){
            
             Final.setAddress("error");
             
            return Final;
        }
   ArrayList<TrainingSession> training_Sessions =new ArrayList<TrainingSession>();
        ArrayList<CourseSession> courses =new ArrayList<CourseSession>();
        Final.setCourses(courses);
        Final.setTraining_Sessions(training_Sessions);
        
        return Final;                          
        
    }// Read from input file and create new intructor  //
    private static Instructor getInstructor(Scanner SC){
        
         String display =SC.nextLine().replaceAll(",", " ");                    
        Scanner Ftext =new Scanner(display);                                
        String name =Ftext.next();                                         
        name = name +" "+Ftext.next();                                      
        String ID =Ftext.next();                                          
        long Time =Ftext.nextLong();                                       
        Date BirthDate = new Date(Time);                                        
        char Gender =Ftext.next().charAt(0);                               
        String Degree =Ftext.next();                                      
        String Specialization =Ftext.next();                               
        Specialization =Specialization +" "+Ftext.next();                  
        String Address =Ftext.next();                                      
        boolean Availabilty =Ftext.nextBoolean(); 
        
        
     Instructor tempers = new Instructor(BirthDate,Gender,Degree,Specialization,Address,Availabilty,name,ID);
                               
        if(isUnique(tempers)==false){
            tempers.setAddress("error");
            return tempers;
        }
           
        ArrayList<OnlineSession> dexter = new ArrayList<OnlineSession>();        
        tempers.setCurrent_Courses(dexter); 
        
        return tempers;
        
    }
    // use  matching session to cheack and search to cheack //
    public static boolean isUnique(Object o){
        
      if(o instanceof OnlineSession){
            
          if(OnlineSession.findMatchingSession(sessionsList,((OnlineSession)o).getId()).equals("error"));
            
          return true; 
        }
        if(o instanceof UniversityMember){
            if(UniversityMember.searchUniverstyMember(memberList, ((UniversityMember) o).getId()).getId().equals("error")){
                
       return true;
        }
                
        }
      return false;
        
    }
}

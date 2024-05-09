/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalms;
import java.util.*;
/**
 *
 * @author jyash
 */
public class Hospitalms {

    public static void main(String[] args) {
//        Patient p1=new Patient("22","adkd","305843");
//        Patient p2=new Patient("23","addhs","345843");
//        
//        PatientList plist=new PatientList();
//        plist.Insert(p1);
//        plist.Insert(p2);
//       // System.out.println(plist.searchByContact("305843").getName());
//        
//        Doctor d1=new Doctor("22","sdhd","94858","eyes",500);
//        Doctor d2=new Doctor("23","dgdj","94838","orthopaedician",800);
//        
//        DoctorsList dl=new DoctorsList();
//        dl.Insert(d1);
//        dl.Insert(d2);
//        
//        //System.out.println(dl.searchByID("22").getName()+"   "+dl.searchByContact("94838").getSpeciality());
//        
//        CheckUpList cul=new CheckUpList();
//        
//        Checkup cu1=new Checkup(d1,p1,3,"A","5");
//        Checkup cu2=new Checkup(d1,p1,2,"B","5");
//        Checkup cu3=new Checkup(d1,p1,1,"C","5");
//        
//        cul.Enqueue(cu1);
//        cul.Enqueue(cu2);
//        cul.Enqueue(cu3);
//        
//        cul.Print();



    PatientList plist=new PatientList();
    DoctorsList dlist=new DoctorsList();
    Scanner sc=new Scanner(System.in);
    
    String choice;
    
    while(true){
        MainMenu();
        choice=sc.nextLine();
        if(choice.equals("1")){
            System.out.println("\n Doctor ID");
            String id=sc.nextLine();
            
            System.out.println("\n Doctor Name");
            String name=sc.nextLine();
            
            System.out.println("\n Doctor Contact");
            String contact=sc.nextLine();
            
            System.out.println("\n Doctor Speciality");
            String spec=sc.nextLine();
            
            System.out.println("\n Doctor Fee");
            int fee=sc.nextInt();
            sc.nextLine();
            
            Doctor d=new Doctor(id,name,contact,spec,fee);
            dlist.Insert(d);
        }
        
        else if(choice.equals("2")){
            System.out.println("\n Patient ID");
            String id=sc.nextLine();
            
            System.out.println("\n Patient Name");
            String name=sc.nextLine();
            
            System.out.println("\n Patient Contact");
            String contact=sc.nextLine();
            
            Patient patient =new Patient(id,name,contact);
            plist.Insert(patient);
        }
        
        else if(choice.equals("3")){
            dlist.PrintData();
        }
        
        else if(choice.equals("4")){
            plist.PrintData();
        }
        
        else if(choice.equals("5")){
            System.out.println("\n Welcome to CheckUp Menu \n");
            CheckUpList[] clist=new CheckUpList[dlist.size()];
            
            for(int i=0;i<clist.length;i++){
                clist[i]=new CheckUpList();
                Doctor doctor=dlist.getAtIndex(i);
                System.out.println("\n\n Enter Patient for Doctor ");
                System.out.println("Name       :"+doctor.getName());
                System.out.println("Speciality :"+doctor.getSpeciality());
                System.out.println("Fee        :"+doctor.getFees());
                
                System.out.println("All Patients :");
                plist.PrintData();
                
                while(true){
                    System.out.println("Enter Patient Id Or type null to Stop");
                    String id=sc.nextLine();
                    
                    if(id.equals("null")){
                        break;
                    }
                    
                    System.out.println("Priority 3 for Emergency \nPriority 2 for Intermediate \nAny other for Normal");
                    String per=sc.nextLine();
                    
                    int p=1;
                    
                    if(per.equals("3")){
                        p=3;
                    }
                    else if(per.equals("2")){
                        p=2;
                    }
                    
                    Patient patient=plist.searchByID(id);
                    if(patient==null){
                        Checkup cup=new Checkup(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                        clist[i].Enqueue(cup);
                    }
                    
                }
            }
            for(int i=0;i<clist.length;i++){
                System.out.println("\n\nPatient"+(i+1)+" In Queue for Doctor "+dlist.getAtIndex(i).getName());
                
                for(int j=0;j<clist[i].size();j++){
                    System.out.println("Enter Recommendation for Patient :"+clist[i].getPatient(j));
                    String rec=sc.nextLine();
                    clist[i].addRecommendation(j,rec);
                }
            }
        }
    }
           
        
        
    }
    
    public static void MainMenu(){
        System.out.println("\n\n || *****  Hospital Management System  ***** ||");
        System.out.println("        || Main Menu  ||");
        System.out.println("\n Enter 1 for Inserting New Doctor  ");
        System.out.println("\n Enter 2 to Insert Patient  ");
        System.out.println("\n Enter 3 for Printing all Doctor  ");
        System.out.println("\n Enter 4 for Printing all Patient ");
        
        
        System.out.println("\n Enter 5 for CheckUp Menu  ");
        System.out.println("\n Enter 0 for Exit  ");
    }
}

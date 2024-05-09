/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalms;

class DNode{
   Doctor doctor;
   DNode next,pre;
   
   public DNode(){
      
   }

    public DNode(Doctor doctor) {
        this.doctor = doctor;
        next=null;
        pre=null;
    }
   
   
}

public class DoctorsList {
    
    DNode head,tail;
    public DoctorsList(){
        head=null;
        tail=null; 
    }
    
    public void Insert(Doctor doctor){
        DNode node=new DNode(doctor);
        
        if(head==null || tail==null){
           head=node;
           tail=node;
        }
        
        else{
            head.next=node;
            node.pre=head;
            head=node;
        }
    }
    
    public Doctor searchByID(String id){
        DNode temp=head;
        while(temp!=null){
            if(temp.doctor.getId().equals(id)){
                return temp.doctor;
            }
            temp=temp.pre;
        }
        return null;
    }
    
    public Doctor searchByContact(String contact){
        DNode temp=head;
        while(temp!=null){
            if(temp.doctor.getContact().equals(contact)){
                return temp.doctor;
            }
            temp=temp.pre;
        }
        return null;
    }

   public Doctor AllDoctorInfo(String contact){
        DNode temp=head;
        while(temp!=null){
            System.out.println("Doctor ID = "+temp.doctor.getId()+"      Speciality ="+temp.doctor.getSpeciality());
     
            temp=temp.pre;
        }
        return null;
    }
   
   public int size(){
        DNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.pre;
        }
        return count;
    }
   
   public Doctor getAtIndex(int index) {
        if (index < 0 || index >= size()) {
            return null; // Index out of bounds
        }
        
        DNode current = head;
        int count = 0;
        
        // Traverse the list until reaching the desired index
        while (current != null && count < index) {
            current = current.pre;
            count++;
        }
        
        // Return the doctor at the specified index
        return current != null ? current.doctor : null;
    }
   
   public void PrintData(){
        DNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            System.out.println(count+": "+temp.doctor.toString());
            temp=temp.pre;
        }
    }
}

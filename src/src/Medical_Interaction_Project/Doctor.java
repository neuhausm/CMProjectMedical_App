package Medical_Interaction_Project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Doctor extends User {
    public ArrayList<Patient> doctorPatients;
    private int currID = 100;


    public Doctor(String userName, String userPassword) {
        super(userName, userPassword);
        doctorPatients= new ArrayList<Patient>();
        /*
        doctorPatients.add(new Patient (111,"Max Williams"));
        doctorPatients.add(new Patient (222,"Sarah Miller"));
        doctorPatients.add(new Patient (333,"Rachel Weiss"));
        doctorPatients.add(new Patient (444,"Charlie Green"));
         */
    }

    public void addDoctorPatient(Patient patient){

        doctorPatients.add(patient);
    }
    public void removeDoctorPatient(Patient patient){
        doctorPatients.remove(patient);
    }

    public void displayPatient(){
        for(int i=0;i<doctorPatients.size();i++){
            System.out.println("Patient Number "+(i+1)+"\n" +
                    "Patient name: "+doctorPatients.get(i).getPatientName()+"\nPatient ID: "+doctorPatients.get(i).getPatientID()+"\n");
        }
        Scanner scanner =new Scanner(System.in);
        System.out.print("To view patient information select a patient ID: ");
        int idChoice=scanner.nextInt();
        for(int i=0;i<doctorPatients.size();i++) {
            if (idChoice == doctorPatients.get(i).getPatientID()) {
                doctorPatientMenu(doctorPatients.get(i));
            }
        }}
    public void doctorPatientMenu(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Add Medications (1)\n2. Set last check-in (2)\n3. Set Blood Pressure (3)" +
                    "\n4.Back to All Patients (4)\n5.Exit (5)");
            choice = scanner.nextInt();

            if (choice == 1) { //Add medications
                String addChoice= "n";

                do{
                    System.out.print("Enter medication name: ");
                    String medication= scanner.next();
                    System.out.print("Enter medication description: ");
                    scanner.nextLine();
                    String desc = scanner.nextLine();
                    System.out.println(desc);
                    patient.setMedications(medication, desc);
                    System.out.print( "add another? (y or n) ");
                    addChoice= scanner.next();
                }
                while(addChoice=="y");

            } else if (choice == 2) { //get Check In
                System.out.println("Enter time of last Check In: ");
                String checkIn = scanner.next();
                patient.setLastCheckIn(checkIn);
            } else if (choice == 3) {
                System.out.println("Enter Blood Pressure: ");
                String BP = scanner.next();
                patient.setBP(BP);
            } else if (choice == 4) {
                displayPatient();
            }
        }
    }

    public ArrayList<Patient> getDoctorPatients(){
        return doctorPatients;
    }

    public void doctorMenu () {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. See All Patients (1)\n2. Add Patient(2)\n3. Remove Patient (3)\n4. Exit (4)");
            choice = scanner.nextInt();
            if (choice == 1) {
                while(doctorPatients.isEmpty() && choice == 1){
                    System.out.println("ERROR no patients in system \nPress 2 to continue");
                    choice = scanner.nextInt();
                }
                if(!doctorPatients.isEmpty()){
                    displayPatient();
                }
            } else if (choice == 2) {
                System.out.print("Enter Patient Name: ");
                String name = scanner.next();
                int Id = currID;
                System.out.print("Patient ID: " + Id + "\n");
                Patient patient = new Patient(Id, name);
                addDoctorPatient(patient);
                currID++;
            } else if (choice == 3) {
                System.out.print("Enter Patient ID: ");
                int Id = scanner.nextInt();
                for (int j = 0; j < doctorPatients.size(); j++) {
                    if (doctorPatients.get(j).getPatientID() == Id) {
                        removeDoctorPatient(doctorPatients.get(j));
                    }
                }
            }

        }
    }
}


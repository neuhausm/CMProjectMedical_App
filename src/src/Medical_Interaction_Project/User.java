package Medical_Interaction_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String userName;
    private String userPassword;
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private Doctor currentDoctor;


    public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, Doctor currentDoctor){
        this.userName = userName;
        this.userPassword = userPassword;
        this.currentDoctor = currentDoctor;
    }

    public void addPatient(Patient patient) {

        patients.add(patient);
    }

    public void displayPatient(){
        for(int i=0;i<patients.size();i++){
            System.out.println("Patient Number "+(i+1)+"\n" +
                    "Patient name: "+patients.get(i).getPatientName()+"\nPatient ID: "+patients.get(i).getPatientID()+"\n");
        }
        Scanner scanner =new Scanner(System.in);
        System.out.print("To view patient information select a patient ID: ");
        int idChoice=scanner.nextInt();
        for(int i=0;i<patients.size();i++){
            if(idChoice==patients.get(i).getPatientID()){
                patientMenu(patients.get(i));
            }

        }}
    public void patientMenu(Patient patient){
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        while(choice!=6) {
            System.out.println("1. Current Medications (1)\n2. Last Check-In (2)\n3. Blood Pressure (3)" +
                    "\n4. Set Up Zoom Meeting With Your Doctor(4)\n5. Back to All Patients (5)\n6. Exit (6)");
            choice = scanner.nextInt();
            if (choice==1){
                patient.getMedications();
            }
            else if (choice==2){
                patient.getLastCheckIn();
            }
            else if (choice==3){
                patient.getBP();
            } else if (choice == 4){
                patient.setZoom();
            }else if (choice==5){
                displayPatient();
            }
        }}


    public String getUserName(){
        return userName;
    }

    public String getUserPassword(){
        return userPassword;
    }
    public void UserMenu(){
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        while(choice!=3) {
            System.out.println("1. See All Patients (1)\n2. Add Patient(2)\n3. Exit (3)");
            choice = scanner.nextInt();
            if (choice == 1) {
                if(!patients.isEmpty()){
                    displayPatient();
                }
                else{
                    System.out.println("ERROR no patients in system \nPress 2 to continue");
                    choice = scanner.nextInt();
                }
            } else if (choice == 2) {
                System.out.print("Enter Patient ID: ");
                int Id = scanner.nextInt();

                ArrayList<Patient> doctorPatients = currentDoctor.getDoctorPatients();
                int count = 0;
                for(int i =0; i<doctorPatients.size(); i++){
                    if(doctorPatients.get(i).getPatientID() == Id){
                        addPatient(doctorPatients.get(i));
                        count++;
                    }
                }
              if (count == 0){
                  System.out.println("Patient Not Found in System");
              }else{
                  System.out.println("Patient Added");
              }

            }
        }

    }

}

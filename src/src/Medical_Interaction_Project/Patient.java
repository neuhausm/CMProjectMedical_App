package Medical_Interaction_Project;

import java.util.ArrayList;

public class Patient {
    private int patientID;
    private String patientName;
    private ArrayList<String> medications;
    private String lastCheckIn;
    private String BP;
    private BP_Enum BPdesc;


    public Patient(int patientID, String patientName){
        this.patientID = patientID;
        this.patientName = patientName;
        medications=new ArrayList<>();


    }
    public String getPatientName(){
        return patientName;
    }
    public int getPatientID(){
        return patientID;
    }


    public void setMedications(String medication, String desc){

        medications.add(medication);
        medications.add(desc);
    }

    public void setLastCheckIn(String lastCheckIn){this.lastCheckIn =lastCheckIn;}
    public void getLastCheckIn(){
        System.out.println("Last Check-In: " + lastCheckIn);
    }

    public void setBP(String BP, BP_Enum BPdesc){
        this.BP =BP;
        this.BPdesc = BPdesc;
    }
    public void getBP(){
        System.out.println("BP: " + BP + " mm Hg");
        System.out.println("BP Status: " + BPdesc);
    }

    public void getMedications(){
       System.out.println(medicationsToString());
    }

    public String medicationsToString(){
        StringBuilder str = new StringBuilder();
        str.append("Medications:\n");
        for (int i =0; i<medications.size(); i++){
           if (i%2 == 0 ) {
               str.append(medications.get(i) + " - " + medications.get(i + 1));
           }
        }
        return str.toString();
    }

    public void setZoom(){
        System.out.println("To request Zoom email Dr. Green at green@MediAssist.com");

    }



}

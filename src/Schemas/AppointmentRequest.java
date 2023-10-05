package Schemas;

import java.util.ArrayList;

public class AppointmentRequest {

    int requestId;
    int personId;
    ArrayList<String> preferredDays;
    ArrayList<Integer> preferredDocs;
    boolean isNew;


    public AppointmentRequest(int requestId, int personId, ArrayList<String> preferredDays, ArrayList<Integer> preferredDocs, boolean isNew) {
        this.requestId = requestId;
        this.personId = personId;
        this.preferredDays = preferredDays;
        this.preferredDocs = preferredDocs;
        this.isNew = isNew;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public ArrayList<String> getPreferredDays() {
        return preferredDays;
    }

    public void setPreferredDays(ArrayList<String> preferredDays) {
        this.preferredDays = preferredDays;
    }

    public ArrayList<Integer> getPreferredDocs() {
        return preferredDocs;
    }

    public void setPreferedDocs(ArrayList<Integer> preferredDocs) {
        this.preferredDocs = preferredDocs;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

}

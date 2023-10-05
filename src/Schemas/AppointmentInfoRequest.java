package Schemas;

public class AppointmentInfoRequest {

    int doctorId;
    int personId;
    String appointmentTime;
    boolean isNewPatientAppointment;
    int requestId;

    public AppointmentInfoRequest(int doctorId, int personId, String appointmentTime, boolean isNewPatientAppointment, int requestId) {
        this.doctorId = doctorId;
        this.personId = personId;
        this.appointmentTime = appointmentTime;
        this.isNewPatientAppointment = isNewPatientAppointment;
        this.requestId = requestId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isNewPatientAppointment() {
        return isNewPatientAppointment;
    }

    public void setNewPatientAppointment(boolean newPatientAppointment) {
        isNewPatientAppointment = newPatientAppointment;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}

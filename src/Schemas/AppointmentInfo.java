package Schemas;

public class AppointmentInfo {

    int doctorId;
    int personId;
    String appointmentTime;
    boolean isNewPatientAppointment;

    public AppointmentInfo(int doctorId, int personId, String appointmentTime, boolean isNewPatientAppointment) {
        this.doctorId = doctorId;
        this.personId = personId;
        this.appointmentTime = appointmentTime;
        this.isNewPatientAppointment = isNewPatientAppointment;
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

    @Override
    public String toString() {
        return "AppointmentInfo{" +
                "doctorId=" + doctorId +
                ", personId=" + personId +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", isNewPatientAppointment=" + isNewPatientAppointment +
                '}';
    }
}

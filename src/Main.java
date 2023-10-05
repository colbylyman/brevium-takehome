import java.io.IOException;

import Schemas.AppointmentInfo;
import Schemas.AppointmentInfoRequest;
import Schemas.AppointmentRequest;
import Web.RequestHandler;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        String startUrl = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Start?token=fe4f5ce4-a032-434a-a069-00c473d80ef9";
        String stopUrl = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Stop?token=fe4f5ce4-a032-434a-a069-00c473d80ef9";
        String updateScheduleUrl = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Schedule?token=fe4f5ce4-a032-434a-a069-00c473d80ef9";
        String appointmentRequestUrl = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/AppointmentRequest?token=fe4f5ce4-a032-434a-a069-00c473d80ef9";
        String getScheduleUrl = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Schedule?token=fe4f5ce4-a032-434a-a069-00c473d80ef9";
        AppointmentInfoRequest testInfoReq = new AppointmentInfoRequest(1, 1, "2023-10-04T19:30:11.200Z", false, 0);


        RequestHandler handler = new RequestHandler();

        // Start the API
        handler.startRequest(startUrl);

        // Get the current schedule
        ArrayList<AppointmentInfo> allAppointments = handler.getScheduleRequest(getScheduleUrl);

        // Get the next appointment
        AppointmentRequest newAppointment = handler.getAppointmentRequest(appointmentRequestUrl);

        // Keep getting appointments until they are all scheduled
        while (newAppointment != null) {
            // Find an open appointment slot
            AppointmentInfo newAppInfo = AppointmentCreator.FitAppointment(newAppointment, allAppointments); // TODO Fit the appointment into the current schedule

            allAppointments.add(newAppInfo);

            // Create the request obj and save the new appointment to the web
            AppointmentInfoRequest newAppInfoRequest = new AppointmentInfoRequest(newAppInfo.getDoctorId(), newAppInfo.getPersonId(),
                    newAppInfo.getAppointmentTime(), newAppInfo.isNewPatientAppointment(), 0);

            handler.updateScheduleRequest(updateScheduleUrl, newAppInfoRequest);

            // Get next appointment
            newAppointment = handler.getAppointmentRequest(appointmentRequestUrl);
        }


        // Stop the API
        ArrayList<AppointmentInfo> appInfo = handler.stopRequest(stopUrl);

        // Print the Final List
        for (AppointmentInfo appointment : appInfo) {
            System.out.println(appointment.toString());
        }

    }
}

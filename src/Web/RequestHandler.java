package Web;

import Schemas.AppointmentInfo;
import Schemas.AppointmentInfoRequest;
import Schemas.AppointmentRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.javatuples.Pair;


import java.io.IOException;
import java.util.ArrayList;

public class RequestHandler {
    // Start the API
    public void startRequest(String url) throws IOException, InterruptedException {

        // Connect to the api and get the body and response code
        HttpConnectionClient client = new HttpConnectionClient();

        // Make the request
        Pair<Integer, String> codeBodyPair = client.makePostRequest(url, "");

        // Save the response code and body
        int respCode = codeBodyPair.getValue0();
        String body = codeBodyPair.getValue1();

        // Print a string based on the response
        ResponseCodeChecker.checkResponseCode("Start", respCode);

    }

    // Stop the API
    public ArrayList<AppointmentInfo> stopRequest(String url) throws IOException, InterruptedException {

        // Connect to the api and get the body and response code
        HttpConnectionClient client = new HttpConnectionClient();

        Pair<Integer, String> codeBodyPair = client.makePostRequest(url, "");

        int respCode = codeBodyPair.getValue0();
        String body = codeBodyPair.getValue1();

        Gson gson = new Gson();
        ArrayList<AppointmentInfo> appointments = gson.fromJson(body, new TypeToken<ArrayList<AppointmentInfo>>(){}.getType());

        ResponseCodeChecker.checkResponseCode("Stop", respCode);

        return appointments;
    }

    // Update the schedule with a new appointment
    public String updateScheduleRequest(String url, AppointmentInfoRequest appointmentInfoRequest) throws IOException, InterruptedException {

        // Convert the request object into json to be sent
        Gson gson = new Gson();
        String jsonBody = gson.toJson(appointmentInfoRequest);

        // Connect to the api and get the body and response code
        HttpConnectionClient client = new HttpConnectionClient();

        Pair<Integer, String> codeBodyPair = client.makePostRequest(url, jsonBody);

        int respCode = codeBodyPair.getValue0();
        String body = codeBodyPair.getValue1();

        String responseString = body;

        ResponseCodeChecker.checkResponseCode("Updated Schedule", respCode);

        System.out.println("Schedule: " + responseString);

        return responseString;
    }

    // Get a new appointment to add to the schedule
    public AppointmentRequest getAppointmentRequest(String url) throws IOException, InterruptedException {

        Gson gson = new Gson();

        // Connect to the api and get the body and response code
        HttpConnectionClient client = new HttpConnectionClient();

        Pair<Integer, String> codeBodyPair = client.makeGetRequest(url);

        int respCode = codeBodyPair.getValue0();
        String body = codeBodyPair.getValue1();

        AppointmentRequest responseAppointment = gson.fromJson(body, AppointmentRequest.class);

        ResponseCodeChecker.checkResponseCode("Get Next Appointment", respCode);


        if (respCode == 200) {
            return responseAppointment;
        }

        else {
            return null;
        }
    }

    // Get the initial schedule
    public  ArrayList<AppointmentInfo> getScheduleRequest(String url) throws IOException, InterruptedException {

        Gson gson = new Gson();

        // Connect to the api and get the body and response code
        HttpConnectionClient client = new HttpConnectionClient();

        Pair<Integer, String> codeBodyPair = client.makeGetRequest(url);

        int respCode = codeBodyPair.getValue0();
        String body = codeBodyPair.getValue1();

        ArrayList<AppointmentInfo> appointments = gson.fromJson(body, new TypeToken<ArrayList<AppointmentInfo>>(){}.getType());

        ResponseCodeChecker.checkResponseCode("Get Schedule", respCode);

        return appointments;
    }
}

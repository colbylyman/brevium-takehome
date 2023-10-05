package Web;

public class ResponseCodeChecker {
    static void checkResponseCode(String endPointName, int code) {

        String printText;

        if (code == 200) {
            printText = "Success 200";
        }
        else if (code == 204) {
            printText = "There are no more requests to handle 204";
        }
        else if (code == 401) {
            printText = "Invalid token 401";
        }
        else if (code == 405) {
            printText = "Endpoint Stopped 405";
        }
        else if (code == 500) {
            printText = "Schedule unable to accommodate requested appointment 500";
        }
        else {
            printText = "Response code not found ????";
        }

        printText = endPointName + " | " + printText;

        System.out.println(printText);

    }
}

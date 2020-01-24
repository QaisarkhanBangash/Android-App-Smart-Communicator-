package com.android.wondercom;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPumpHELP {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetailhelp = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("User gets authentication SMS response whenever user tries to login to SmartPhone.If user successfully" +
                "loggedin  to SmartPhone user will receive message of successful login.Fail attempt or wrong password will " +
                "also notify user.                                            ");

        List<String> football = new ArrayList<String>();
        football.add("Your information is fully secured,application developer can not even access it.Whoever knows your password " +
                "can only access and control your SmartPhone via SMS commands.                 ");

        List<String> basketball = new ArrayList<String>();
        basketball.add("If you get irritated by any of our ad take screenshot of that ad and sent it our email qhbangash2@gmail.com.We will " +
                "appreciate your" +
                " feedback and suggestions related to our application performance.                               ");



        expandableListDetailhelp.put("Authentication", cricket);
        expandableListDetailhelp.put("Privacy and Security Help", football);
        expandableListDetailhelp.put("Report a Problem", basketball);
        return expandableListDetailhelp;
    }
}

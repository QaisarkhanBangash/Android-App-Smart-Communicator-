package com.android.wondercom;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("First of all you need to give all permissions by going to Settings/Apps/SmartComm/Permissions.There are also" +
                "Toggle buttons which should be turned on in Smart Control and Smart Access after which functionalities will work." +
                "For accessing or controlling your SmartPhone you should set password in your settings.For knowing the purpose of " +
                "particular Feature or functionality tab the left information icon where information of that Feature will be displayed." +
                "You can access and control your SmartPhone from simple mobile by sending SMS as commands.User can also login/logout" +
                "from settings as well as via SMS (Short Message Service) commands.               ");

        List<String> football = new ArrayList<String>();
        football.add("Application collect the information you provide and process it.Information is then used in for performing" +
                " functionalities. There is'nt any Database or Server involved where users data is uploaded therefore your information" +
                "can not be misused or leaked.                 ");

        List<String> basketball = new ArrayList<String>();
        basketball.add("We're working to make sure that ads stay true to the spirit of the SmartComm communi-ty.You can hide an ad" +
                "you don't like by tapping the close button on top right corner of that ad.               ");



        expandableListDetail.put("Guideline", cricket);
        expandableListDetail.put("Data Policy", football);
        expandableListDetail.put("About Ads", basketball);
        return expandableListDetail;
    }
}

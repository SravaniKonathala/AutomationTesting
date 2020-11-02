package com.motorola.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadUserJsonFile {
    /**
     * @method readUserJSON(String userName)
     * @description read the json file and retrieve the data and assign to the bean class
     * @param userName name of the user to register
     * @return userDetailsBean
     * @throws IOException
     * @throws ParseException
     */
    public UserDetailsBean readUserJSON(String userName) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        UserDetailsBean userDetailsBean = new UserDetailsBean();
        JSONObject userDetails;
        FileReader fileReader = new FileReader("src/test/java/com/motorola/resources/userDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JSONArray userlist = (JSONArray)obj;
      //  System.out.println("List: "+userlist);
        for (Object o : userlist) {
            userDetails = (JSONObject) o;
            // System.out.println("userLoginJSON : "+ userDetails.get(userName));
            JSONObject userRegistrationDetails = (JSONObject) userDetails.get(userName);

            userDetailsBean.setTitle(userRegistrationDetails.get("title").toString());
            // System.out.println("Title: "+userRegistrationDetails.get("title").toString());
            userDetailsBean.setFirstName(userRegistrationDetails.get("firstName").toString());
            userDetailsBean.setLastName(userRegistrationDetails.get("lastName").toString());
            userDetailsBean.setEmail(userRegistrationDetails.get("email").toString());
            userDetailsBean.setPassword(userRegistrationDetails.get("password").toString());
            userDetailsBean.setCompanyName(userRegistrationDetails.get("companyName").toString());
            userDetailsBean.setAddress(userRegistrationDetails.get("address").toString());
            userDetailsBean.setCity(userRegistrationDetails.get("city").toString());
            userDetailsBean.setState(userRegistrationDetails.get("state").toString());
            userDetailsBean.setPostcode(userRegistrationDetails.get("postCode").toString());
            userDetailsBean.setCountry(userRegistrationDetails.get("country").toString());
            userDetailsBean.setMobile(userRegistrationDetails.get("mobile").toString());
            userDetailsBean.setAliasAddress(userRegistrationDetails.get("aliasAddress").toString());
        }
            return userDetailsBean;
    }

}

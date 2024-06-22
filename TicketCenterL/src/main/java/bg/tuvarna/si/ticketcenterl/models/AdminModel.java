package bg.tuvarna.si.ticketcenterl.models;

import bg.tuvarna.si.ticketcenterl.entities.User;

public class AdminModel {
    private String fName;
    private String lName;
    private String password;


    public AdminModel(User user){
        fName = user.getFirstName();
        lName = user.getLastName();
        password = user.getPassword();
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPassword() {
        return password;
    }
}

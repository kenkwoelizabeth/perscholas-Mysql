package emailapp;

import java.util.Scanner;
/* IT support charged with the task of creating new email accounts */
public class EmailApp {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String email;
    private String companySuffix = "aeycompany.com";
    public String showInfo;


    // constructor to receive the first and last name

    public EmailApp(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
     //   System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
      //  System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
       // System.out.println("Your password is: " + this.password);

        // combine element to find the email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    //Ask for the department(method)
    private String setDepartment() {
        System.out.println("New Worker: " + firstName + "\nDepartment Codes: \n1 for Sales \n2 for " +
                "Developement\n3 for Account\n0 for none\nEnter department codes: ");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random Password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {

            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
        //Change the password
    }

    public void changePassword(String password) {
        this.password = password;

    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
       return "DISPLAY NAME:" + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
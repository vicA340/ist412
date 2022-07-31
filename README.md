# ATZ-Finance
## IST 412 Group 1: Victor Altadonna, Christian Chernock, Craig Freiwald

### Refactoring 
(all refactoring was completed by Christian Chernock)
1.	Fixed 500 caused by registering with a username that already exists

    •	This was accomplished by adding an error check method into the RegistrationController class. It simply checks the attached database for the proposed name and       returns an error message if it already exists.

2.	Fixed password encryption process so that the web security configuration and user registration agree on the password encryption method for user passwords.

    •	The fix was implanted by creating an OurPasswordEncoder class to contain the password encoder used by the web security config and the registration.

3.	The dashboard controller was separated from the MainController class and put into its own dedicated controller class

    •	This was accomplished by creating a DashboardController class to handle dashboard functions.

4.	Fixed redirect issue for users attempting to view loans when not logged in (via typing the url).

    •	This was fixed by creating a method in the MainController class using the Spring Boot session variables to check if a user is logged in and ensuring that the redirect did not bring them to the dashboard again.  

5.	HTML Template organization.

    •	This was fixed by adding appropriate folders for the various types of HTML template we are using. 

6.	Cleaned up the Loan use case implementations

    •	Got rid of the LoanStatus class and added a check method to the Loan class.
    •	Combined the LoanService and LoanServiceImpl classes into one class

7.	Cleaned up the WebSecurityConfiguration class. 

    •	Removed the antMatchers method


### New Use Case:


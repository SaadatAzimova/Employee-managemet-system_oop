Employee Management System
Description
This Employee Management System allows the management of employee records for different types of employees, including Full-time, Part-time, and Contractor employees. The system calculates the salary for each employee type based on specific criteria:

Full-time employees: Their salary is calculated by multiplying their annual salary by 12 to get the monthly salary.
Part-time employees: Their salary is calculated based on an hourly wage and hours worked per week, then multiplied by 12 months.
Contractor employees: Their salary is calculated based on an hourly rate and a maximum number of hours worked per month, multiplied by 12 months.
This project is built using JavaFX for the user interface and implements basic object-oriented principles, including inheritance and polymorphism.

Features:
Add, remove, and display employee records in a table.
Input and calculate salaries for different types of employees.
Switch between tabs for different employee types using a ChoiceBox.
Instructions on How to Run the Program
Prerequisites
Ensure that you have the following installed on your computer:

Java 8 or higher
JavaFX library
Steps to Run the Program:
Clone the repository or download the project files to your local machine.
Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
Add JavaFX to your IDE:
If using IntelliJ IDEA, add JavaFX to the project dependencies via Project Structure > Libraries.
If using Eclipse, add the JavaFX jar files to the build path.
Build and run the application:
In your IDE, run the HelloController class as a JavaFX Application.
Once the program is running, the GUI will allow you to add employees and calculate their salaries based on the provided inputs.

Screenshots of  GUI with different types of employees.
1.initial look of ui

![oop1](https://github.com/user-attachments/assets/4f7a8b49-e41d-43f1-88e6-61d284a840a2)

2.filling employee data

![oop2](https://github.com/user-attachments/assets/28c999e0-ceb5-4d83-b2c4-721c67ae3473)

3. selecting type(switches to type's tab),filling salary details in type'tab
 
![oop3](https://github.com/user-attachments/assets/2def0822-3b34-4bfa-8731-dd939774ee2c)

4. clicking on "calculate salary" button
(calculateSalary() method works, text fields clear, switches to main tab, annual salary appears)

![oop4](https://github.com/user-attachments/assets/10730438-d199-47eb-ab3e-9c4038692d86)

5. clicking on add button, employee appears in table view, text fields clear

![oop5](https://github.com/user-attachments/assets/fde7176e-05de-492d-839a-6b7fa25a8217)
   
6.filling employee data

![oop6](https://github.com/user-attachments/assets/17a42307-8a72-4a4e-904c-bf7440d5e1a0)

7. selecting type(switches to type's tab),filling salary details in type'tab
   
![oop7](https://github.com/user-attachments/assets/aa52b41c-873e-434b-a9ef-8e4e88be29fd)

8.clicking on "calculate salary" button
(calculateSalary() method works, text fields clear, switches to main tab, annual salary appears)

![oop8](https://github.com/user-attachments/assets/cf0b060a-ba33-406d-8e8c-877e106dd2f2)

9.filling employee data

![oop9](https://github.com/user-attachments/assets/392d8edf-6b79-4e43-9489-81f2d8c13f70)

10.selecting type(switches to type's tab),filling salary details in type'tab

![oop10](https://github.com/user-attachments/assets/bc78a8d4-b8c3-4227-8803-9f4ada2b2f0a)

11.clicking on "calculate salary" button
(calculateSalary() method works, text fields clear, switches to main tab, annual salary appears)

![oop11](https://github.com/user-attachments/assets/63357129-1030-47ef-b4bf-49b5f7ccff13)

12. tried to remove item without selecting
    
![oop12](https://github.com/user-attachments/assets/7cfd4eba-036d-4607-b029-2ea39e7a4764)

13. item removed successfuly
    
![oop13](https://github.com/user-attachments/assets/84968548-0358-4942-b54e-c93503ef6924)

14. tried to input string in integer text field(message appears)
![oop14](https://github.com/user-attachments/assets/32efa187-1cb1-4030-bcf6-24df39d44bab)


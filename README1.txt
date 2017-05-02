To run our software you can use an IDE that supports Java, we used NetBeans. From the IDE open the project folder called ResturantAutomation. Once the project is loaded into the IDE running the server.java file
will start the program from the login screen. 
Another option is to go into the "dist" folder within the "ResturantAutomation" folder you should find a .jar file called "ResturantAutomation.jar". This is a compiled jar file that contains all the classes into one runnable program.

Note:
running the .jar runnable file will cause some features to not work, mainly all features that requuired socket connections. This is because in the source doe the Host machine ip is set to my laptop. In order for these features to work 
you would need to go into the orders.java and orderMenu.java file, there you will see some code with a comment "Host Machine IP" next to it. There you would need to change the IP to whatever computer you are using. On windows to find the
IP you can go into command prompt and type "ipconfig" you will need to enter the "IPv6" given to you. After the IP is changed in both files orders.java and orderMenu.java. You can run the server.java file and it should work now. 
 

1. Chef login
For username = chef, password = chef


From the chef page, you can select the order window, the edit menu window, or the edit inventory window.


• On the order window, if you’re connected to the server and there’s a pending order, it should appear in the left list box. Select it and click done to remove it from the list and server, updating the time and inventory databases.

• On the edit menu window, a dish can be edited by typing its name as it appears in the drop-down menus (case sensitive), and entering new values for price, ingredients, and quantities. The price should be a float number, the ingredients should be a string list separated with commas, and quantities should be an integer list separated with commas. Clicking submit will edit the database entry. Adding is done in the same way, except any string can be added as the item’s name. The category should be “appetizer”, “entree”, “dessert”, or “drink”, without quotes and case sensitive. To remove items, select them in the drop-down menu and click remove. 


In the popularity window, the dishes with the most ordering instances of all time will appear on the list. In order to see the popularity rankings from a certain time period, the dates should be selected in the drop down menu. The all-time stats and least popular checkboxes will also adjust the data display. Occasionally, the dropdown menus will not appear (which is a known bug), but the date can be selected with the arrow keys.


• On the edit inventory window, an inventory item can be selected on the list, and its information can be displayed with view selected info. By directly editing the text in the boxes and clicking edit selected, the database information for that item will be updated. In the add new window, a new item can be added with a string name, a float quantity, and a float unit cost. Remove selected will remove the selected item from the database. 








2. KITCHEN
README for Kitchen subsystem (the code contained in folder Kitchen_code)

Running the Demo Program:
To run this demo with an IDE:
Include files kitchen.cpp, kitchenFunctions.cpp, and kitchen.h in your IDE’s project build, then run the project.


To run this demo on a Mac or Linux OS terminal:
(1)Open the terminal of a Mac or Linux OS in the folder containing these files.
(2)Run the command "make". This compiles the .cpp and .h files into the program "SWP".
(2)Run the program "SWP". (On a Linux system, this would be achieved by entering ./SWP)


Using the Demo Program:
Once running, follow the directions on screen to start the demo.
Select no when asked to with unit testing.
To use the waiterClient program, type "./WC <port number> a <dish name>"


Known Bugs:
Entering commands other than requested will cause the program to crash.


Files Included:
waiterClient.c
kitchenServer.h
kitchen.cpp
kitchenFunctions.cpp
kitchen.h
makefile






















3. Manager login
For username=manager, password=manager


On the manager's interface, there are seven options: “View Statistics”, “Budget”, “Employee Payroll”, “Employee List”, “Time Clock”, “Schedule”, and “Log Out”.
 
View Statistics: For this window, it brings up a windows with four tabs marked “Daily”, “Weekly”, “Monthly”, and “Annual”. From these tabs, the user can select which time period he/she wants to view the general statistics of the restaurant. These statistics include the most and least popular food dish for the respective time period as well as the amount spent and earned in that time and the number of tables served. This will be useful in deciding the importance of certain menu items.
 
Budget: On the budget window, a table is displayed with four columns and five rows labeled accordingly. The bottom half of the window also displays three labels along with two editable text fields to edit the budget values and a text pane to display the expense being edited. When the user selects any row from the table, the text fields and pane are automatically filled in with the selected row’s expense name, amount budgeted, and amount spent. Changing the values of amount budgeted and amount spent and then clicking “Confirm Edit” changes their values on the table as well as the amount remaining automatically. The bottom right button brings up a pop-up window with possible spending for each expense with choices changing based on the chosen expense in the dropdown menu.
 
Employee Payroll: On the employee payroll window, a list of all current employees sorted by their addition to the system is displayed along with their ID, names, job title, pay rate, hours worked in past week, and calculated pay based on the hours worked and pay rate. The bonus and final pay column are not utilized in this current version of the system. The button on the bottom right allows the manager to send the payroll which will reset the values in the table to zero to reflect the start of a new payroll.

Employee List: On this window, a list of current employees is displayed with their ID, name, job title, pay rate, last punch-in or punch-out recorded, and the date and time of the punch. To remove an employee, select the employee from the table and click “Remove Employee” and click “Yes” when prompted. To add an employee, click “Add Employee” and a pop-up window will show up and allow the manager to add a new employee with their name, ID, job title, and hourly rate. The hourly rate is automatically filled with the default hourly rate of the chosen job title from the dropdown menu.

Time Clock: This is the clock-in, clock-out window. The user will input their ID number and pick whether they are clocking in or clocking out from the dropdown menu and submit. When it is registered, a dialog box will appear to notify the change and the user can press return to close out the window.

Schedule: This window brings up a monthly calendar that will display the current month. Future work is planned on further implementing shift scheduling.
 
Log Out: The manager can choose to logout of the system which brings him/her back to the login window.


4. Waiter login
For username=waiter, password=waiter


On the waiter page after logging in, there a four buttons “New Order”, "Clock in", "Back", and “View Tables”. 
The “New Order” button will bring the user to a screen that shows different food categories, dessert, drinks, appetizers, etc. On the screen when the user clicks the menu button the whole menu is displayed to user in its correct category. The user can then add items to the current order one at a time, or multiple at a time (by selecting more than one item). 
The user clicks the add button, this causes all the selected menu items to be placed in the current order list. The user can remove specific items from the current order if they made a mistake or the customer changes their mind. 
The user is also given the option to clear the whole list completely (saves time, over having to remove each item individually). Finally once the order is complete, the user hits the submit button. 
This causes the order to be sent to the computer that the chef is logged into. The waiter then should return to his main menu, so once the chef is done with the sent order,the waiter is notified on his screen, that one of their sent orders has been completed.


The “View Tables” button brings the user to a new window that will currently display four tables. From the drop down menu for each table a status can be selected. Once desired table status' are selected clicking submit will process it
and let the user know the update went through or not. Changes will be shown with a slight delay because table's are updated every 15 seconds. 

Clock in/out button , brings the waiter to the clocking in and clocking out window.

The back button brings the user back to the login screen.
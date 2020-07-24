Necessary:

* Java version 11 (minimum)
* MySQL 8.0.20 (minimum)

Steps:

* Download and install Xampp for MySQL DB

* Run the MySQL server (port 3306)

* Enter http: // localhost / phpmyadmin /

* Click on the "User Accounts" tab

* Click on "Add User account"

* Fill in the following information:
	username: marketplace
	hostname: select local
	password: marketplace
	and activate in the section "Database for the user account" 
	the checkbox "Create database with the same name and grant all privileges."

* Click continue

* On the left side is the database list click on "marketplace"

* Click on the "SQL" tab

* Run the file "marketplace-schema.sql" 
  on the path "../condorlabs/src/main/resources/marketplace-schema.sql"

* Import the project into the IDE and click on it "clean and bluid"

* And finally right click run

** The project URL is "http://localhost:8080/"
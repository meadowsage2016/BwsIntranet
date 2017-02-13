#Susan Hundt Individual Project
###Problem Statement
Badger Welding Supplies, Inc. has a main location in Madison and a store in Mineral Point.  We have 35 employees.  We need an internal website to store and provide access to some basic information:
*	-Who is out of the office/plant that day.
*	-Employee Directory of cell phone numbers, phone extentions.*
*	-Quick access to driver routes (delivery days) by city*
*	-Subdealer locations by city/county
*	-Cylinder lease and purchase prices
*	-Commonly used office forms
*	-Policy sheets such as delivery restrictions/helium sales
*	-Simple Tax information by customer type
 Also I would like to add a variety of different items that would change frequently and add interest and value to the website.  Such as the current weather, road conditions, breaking news from major news sites, and perhaps an blog for employees to post whatever.
Some of the items above will be available to all viewing the web-site, a few will require the user to sign in to access the data.

###Project Technologies/Techniques
*	Security/Authentication
*	Admin role: create/read/update/delete (crud) of all data
*	User role: access some of the documents
*	All: anyone can view main page: search employee directory/delivery routes (no login)
*	Database (MySQL)
*	Store users and roles
*	BWS Data Base – several tables – Employee Directory-DeliveryRoutes-SubDealers-Employeeblog-LeasesPurchases

##	Web Services or APIs
*	Breaking news from major news sites
*	Weather for Madison and Mineral Point

*	Bootstrap
*	Logging
*	Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
*	Site and database hosted on AWS
*	Unit Testing
*	JUnit tests to achieve 80% code coverage
*	Independent Research Topic
*	Bootstrap Validator

# SonataR1_Server  
This is the server side of the project.  
We used JAX-RS framework for RESTFUL API.  

Our implementation handles http requests that being sent from the Client Side for:  
1)Address Validation  
2)Serviceability   
3)Creating new Order  

#Server:  
We deployed our project on the Apache Tomcat 8.5.15.
To run the server, download the JAR/WAR and from the bin directory in the apache-tomcat-8.5.15 folder, do the following:  
1)set CATALINA_BASE=path-to-JAR/WAR.  
2)run catalina/bat start.

#Database:  
We used mysql schemas and databases for fake informations.
for example, when validating an address we checked in the GeoCode table.
In the ConnectToDB() method in ServiceQualifation class, you can change the information of the connection as you wish.

We added the *.sql files under the tables.rar file so you can see the model of our tables.  




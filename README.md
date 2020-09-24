
Prerequisites
-------------
```
System Requiriment: Java8 and eclipse should be installed.
Eclipse Requiriment:TestNG plugin must be installed from eclipse Marketplace.
```

How to Run Scenarios
--------------------------------
```
1. Go to the "src/test/java/testCases"
2. Now Select the scenario file.
3. Right click on it and click on Run As.
4. Now, choose TestNG Test.
```
Project Structure
--------------------------------
```
1. All the Scenarios are in "src/test/java/testCases"
2. I've created a CommonFunctions.java file which contains commonly used function throughout the project.
3. I've created a Selectors.java file according to POM model, it is single for both the scenarios. We can create it different for Flipkart and Amazon, I've added in improvements.
```

Improvements can be done
----------------------
```
Because of limited time, some of things I'm mentioning in Improvement -
1. We can run this by Maven Build command also.
2. We Can generate report. 
3. We can run test the scenarios in different browsers and Environments.
4. We can create seperate POM file for Flipkart and Amazon. 
```
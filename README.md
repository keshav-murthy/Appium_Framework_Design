# System Requirement

Before running the test make sure that you have the following system requirements :-
 
 1. Appium Server. 
 2. Android SDK.
 3. USB Debugging option enabled in the real device(Mobile).
 4. Real device connected with the system via USB cable.
 5. Java (Version 1.8 or more).
 6. Nodejs and npm 
 
 
# Running test on host

First make sure that the real device is connected via USB cable to the system and the USB Debugging is enabled in it.

Later collect the following specifications from the device :-
1. Version of the operating system of the device.
2. Operating system type either Andriod or IOS.

Once collected the above specs make sure that the same is updated in the config.properties file :-

1. Version of the operating system of the device in the version section.
2. Name of the device beign used in the device_name section.
3. Operating system type either Andriod or IOS in the platform_name section.     

Next to run your tests simply you need to execute the following command from inside the project directory.

mvn test   

# Reports for Tests Pass/Fail

Once one/all the test scripts are finished execution, refresh the project directory and then you can view the report related to them in test-ouput folder in the project directory.

You can view 3 types of test reports :-
1. Index.html ---> which is normal testNG report.
2. Emailable report ---> another type which can shared through emails.
3. Extent report ---> this is the advanced type of report which has all the pie charts,     tables,and diffrent annimations for better understanding of the test pass/fail.  

For Extent Report : You can find this in the following location inside project directory.

 /target/surefire-report/Extent.html

For General Report: You can find this in the following location inside project directory.

/target/surefire-report/Index.html 

You can also view the screenshots of the failed test cases along with thier method name in the screenshots folder of project directory.
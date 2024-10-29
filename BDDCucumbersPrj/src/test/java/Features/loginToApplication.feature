Feature:Login To Vtiger Application

@smokeTest
Scenario:login into vtiger application with valid credential
Given enter the url
When enter the username "admin" and password "admin"
Then click on login button
Then Home page should be displayed 

@RegressionTest
Scenario:login into vtiger application with invalid credential
Given enter the url
When enter the username "admin" and password "manager"
Then click on login button
Then error message should be dispalyed

#Parameterization
@SanityTest
Scenario Outline: Login to vtiger
Given enter the url
When enter the username <userName> and PassWord <passWord> and click on login btn.
Then Home page should be displayed
Examples:
|userName |passWord |
|admin    |admin    |
|manager  |admin    |

#Datatable
@RegTest
Scenario: login into vtiger application with valid credential
Given enter the url
When enter the username and password click on login btn
|admin|admin|
Then Home page should be displayed

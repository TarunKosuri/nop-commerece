Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User Launch Firefox browser
	When User opens URL "https://demo.guru99.com/test/newtours/register.php"
	And user clicks on register
	And user enters contact information
	And user enters Mailing information
	And user enters User information
	And user clicks on submit
	And close browser
	
	
Scenario: Login with account created

	Given User Launch Firefox browser
	When User opens URL "https://demo.guru99.com/test/newtours/register.php"
	And User enters username and password
	And user Clicks on login
Feature: Create a salesforce account

Scenario: Create a salesforce account with Positive Credentials

Given Launch the Browser and Load the SF url
When Enter the SF username as 'vidyar@testleaf.com'
And Enter the SF password as 'Sales@123'
And Click on SF Login Button
And SF Homepage is displayed
And Click on toggle menu button from the left corner
And Click on view All link
And click on Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter account name as <name>
And Select Ownership as Public
And Click on Save button
Then Verify account name

Examples:
|name|
|Bhavani|



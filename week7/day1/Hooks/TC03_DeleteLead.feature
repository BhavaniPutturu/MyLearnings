Feature: deletelead functionality

Scenario Outline: deletelead with multiple data
When Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
And Click on Login Button
Then Homepage is displayed
When Click on crmsfa link
And Click on the leads link
And Click on Find Leads link
And Click on the phone tab
And Enter the phone number to delete <phonenumber>
And Click on Find Leads button
And Click on Delete
And Click on Find Leads link
Then verify the deleted lead

Examples:
|phonenumber|
|99|
|88|
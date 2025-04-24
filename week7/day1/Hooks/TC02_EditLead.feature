Feature: editlead functionality

Scenario Outline: Editlead with multiple data
When Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
And Click on Login Button
Then Homepage is displayed
When Click on crmsfa link
And Click on the leads link
And Click on Find Leads link
And Click on the phone tab
And Enter the phone number to edit <phonenumber>
And Click on Find Leads button
And Click on Edit
And Enter the company name to edit the lead <companyname>
Then Click on the submit button

Examples:
|phonenumber|companyname|
|99|xxx|
|88|yyy|
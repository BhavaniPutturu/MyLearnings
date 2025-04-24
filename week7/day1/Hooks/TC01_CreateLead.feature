Feature: createlead functionality

Scenario Outline: Createlead with multiple data
When Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
And Click on Login Button
Then Homepage is displayed
When Click on crmsfa link
And Click on the leads link
And Click on the createlead link
And Enter the company name to create lead <company name>
And Enter the firstname as <firstname>
And Enter the lastname as <lastname>
And Enter the phone number as <phonenumber>
Then Click on the leads submit button

Examples:
|company name|firstname|lastname|phonenumber|
|Testleaf|Bhavani|P|99|
|Testleaf|Bhavani|Putturu|88|
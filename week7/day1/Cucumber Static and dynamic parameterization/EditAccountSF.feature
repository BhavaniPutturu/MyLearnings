Feature: Edit the salesforce account

Scenario: Edit the salesforce account with Positive Credentials

Given Launch the Browser and Load the SF url 
When Enter the SF username as 'vidyar@testleaf.com'
And Enter the SF password as 'Sales@123'
And Click on SF Login Button
And SF Homepage is displayed
And Click on toggle menu button from the left corner
And Click on view All link
And Click on Accounts link
And Search for the account using 'Bhavani'
And Click the dropdown icon next to the account and select Edit
And Set Type to Technology Partner
And Set Industry to Healthcare
And Enter the Billing Street 'Street1'
And Enter the Billing City 'City1'
And Enter the Billing Postal Code 'zip1'
And Enter the Billing state 'State1'
And Enter the Billing country 'Country1'
And Enter the Shipping Street 'Street2'
And Enter the Shipping City 'City2'
And Enter the Shipping Postal Code 'zip2'
And Enter the Shipping state 'State2'
And Enter the Shipping country 'Country2'
And Set Customer Priority to Low
And Set SLA to Silver
And Set Active to NO
And Enter a unique number in the Phone field '777'
And Set Upsell Opportunity to No
And Click on Save button
Then Verify the phone number
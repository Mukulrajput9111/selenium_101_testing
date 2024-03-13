# Selenium 101
#### This Selenium with Java project is created for automating three pages of Selenium Playground by Lamda.
#### 1. Simple Form Demo
#### 2. Drag & Drop slider
#### 3. Input Form Submission

## Approach
#### The Approach that I'm using is Page Object Model framework with a little bit of data driven approach to it. I read all the input parameters from an excel file with data stored in there respective sheets with same name as the method name.

## Scenarios

### Scenario 1
#### 1. Open LambdaTest’s Selenium Playground from https://www.lambdatest.com/selenium-playground
#### 2. Click “Simple Form Demo” under Input Forms.
#### 3. Validate that the URL contains “simple-form-demo”.
#### 4. Create a variable for a string value E.g: “Welcome to LambdaTest”.
#### 5. Use this variable to enter values in the “Enter Message” text box.
#### 6. Click “Get Checked Value”.
#### 7. Validate whether the same text message is displayed in the right-hand panel under the “Your Message:” section.

### Scenario 2
#### 1. Open the https://www.lambdatest.com/selenium-playground page and click “Drag & Drop Sliders” under “Progress Bars & Sliders”.
#### 2. Select the slider “Default value 15” and drag the bar to make it 95 by validating whether the range value shows 95

### Scenario 3
#### 1. Open the https://www.lambdatest.com/selenium-playground page and click “Input Form Submit” under “Input Forms”.
#### 2. Click “Submit” without filling in any information in the form.
#### 3. Assert “Please fill in the fields” error message.
#### 4. Fill in Name, Email, and other fields.
#### 5. From the Country drop-down, select “United States” using the text property.
#### 6. Fill all fields and click “Submit”.
#### 7. Once submitted, validate the success message “Thanks for contacting us, we will get back to you shortly.” on the screen.


## Framework
#### The framework that I'm using is TestNG. All the execution done using "testng.xml" file. All the tests are performed in Parallel on Chrome and Firefox.

## Logs
#### I have implimented "Log4j" api for creating logs and generating a log file with time stamp after each test run.


## For refrance
#### This is a personal project, given a short one, to showcase my understanding of Selenium webdriver and the understanding of frameworks.

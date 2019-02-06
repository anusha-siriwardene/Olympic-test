# Olympic-test


Documentation
---------------------------
How To Run
Pre-requisites
1. Install Java and 
2. Install Maven

Steps
1. Clone git repository from https://github.com/anusha-siriwardene/Olympic-test.git 
2. Import project to an IDE (Intellij or Eclipse)
3. Evaluator can either of two methods to run the project,
    3.a. Right click on pom.xml --> Run As --> Maven test or
    3.b. Right click on the TestRunner.java -->Run As --> JUnit Test
--------------------------

Assumptions
1. POM (Page Object Model) Implementation
I automated the end-to-end (system) scenario which used a limited set of GUIs' (Graphical User Interfaces') objects (approximately limited around 15 objects across 5 pages). Therefore, all the page objects were implemented within the “AddToCartSteps.java” class without creating a separate set of classes for each page.
However, to achieve an extensive test coverage of using this automation framework, we can extend this with POM concept without any issue.
2. Test Implementation
I have implemented only the requested scenario in the mail. We can extend the test coverage (alternative flows) by adding additional ‘Then’ steps in to the AddToCart.feature file.
---------------------------

Problem Came-across
These two major defects can be seen in the client application I used for this exercise.
1. Once the user added more than 3 items to the “Shop from a list”, user can only see 2 items at a time, in the list conatainer (for example, if the list items are, Milk, Rice and Chocolates, once the user press on ENTER after adding 3rd item – Chocolates, in the list user can only see the Rice and Chocolates visually). To see the 1st item, user had to use up arrow key.
2. Though the user searched a set of multiple product items (for example, Milk, Rice and Chocolates, the search results has been only shown the product items that are related to the 1st search criterion; Milk.
---------------------------

Additional Information
In order to give a comprehensive idea of test analysis and designing process, I will share a separate MS-Word document (Test Apprach.doc) attached along with the reply to the mail sent by Naya.
---------------------------
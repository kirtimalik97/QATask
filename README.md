

**QA Task**

**RESTFul API Framework**

**Framework Overview:**

A hybrid maven based framework is build using the RestAssured, TestNG and

Cucumber(Gherkin).

Created 3 main java files for Pet, Store, User which consists of API's from

Swagger.

There is one Constant file created with the name of Endpoints.

Added another package where all the POJOs are stored.

In the test/java Feature file is been created, along with it there is a Step

defination file.

Test Runner file is also created which basically helps in communication between

Feature file and Step Defination file.

**Explanation:**

Functional Tests focuses on funtional test of API for expected implementation

usage, designed with Scenario

**Prerequisite:**

IntelliJ version : Version 2021.2.3

Chrome Version : Version 95.0.4638.54 (Official Build) (arm64)

**How to Run:**

Navigate to IntelliJ and Import it as a maven project

To run feature file , Right click > Run as > Cucumber feature

To run through testng file, Right click > Run as > Testng Suite

**Reports:**

Swagger\_PetReports.html

Swagger\_StoreReports.html

**Observations:**

In one of the test case related to Update the existing pet, it takes time to

update the details, I verified it with Postman as well.

Another test case for Store has a different time zone which some times creates

a problem while executing, whereas It works perfectly with Postman.

**Author:**

KIRTI MALIK 11/Nov/2021


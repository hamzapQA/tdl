# TDL - To Do List

This is a simple web application which interacts with an API developed in SpringBoot to create, read, update and delete items on a to-do list.

The backend to this software runs on port 8080 and API information can be obtained at http://localhost:8080/swagger-ui/index.html

The website can be loaded at http://localhost:8080

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

In order to succesfully execute this program, there are a number of dependencies which will need to be installed. These are:

```
1. JDK 11 or over

2. Maven

3. Spring Boot

4. Spring IDE

```
The .war file at the root of this diretory already contains the dependencies.

### Installing

This is a step by step guide on how to get the project up and running on your local machine for development and testing. 

1. Visit the following link and click "Code" and then "Download". Alternatively you can use clone the respository using command "git clone https://github.com/hamzapQA/tdl "
```
https://github.com/hamzapQA/tdl
```
3. Import the project into your IDE. Using File -> Import Project. The project structure is now editable.
4. To run the project, in the boot dashboard at the bottom left, click "Restart Server"

### Project Functionality
 
This section provides a brief description on the functionality of the application.

Within the IDE, once the application is running, API endpoints can be viewed at http://localhost:8080/swagger-ui/index.html

The To-Do-List web interface can be accessed at http://localhost:8080

The application can also be run from the command line using the WAR file generated in the root of this directory. Download the file and save it. Open command line, navigate to the directory where the .war file is stored and type the following to run:

```
java -jar HP-TDL-0.0.1-SNAPSHOT.war
```
The "homepage" at https://localhost8080 will allow you to perform CRUD functionality on the To-Do-List. It contains instructions on how to proceed. 

## Running the tests

The project comes with automated tests which make use of JUnit and Mockito. Tests are organised into classes to test functionality. Test files are stored in src/test/java instead of an individual test class.

### Unit Tests 

Unit tests are used to ensure code works correctly and to protect against bugs. This makes use of JUnit and tests the functionality of the TDL class. 

Here is an example of a Unit Test:

	@Test
	public void setFirstNameTest() {
		Tdl tdl = new Tdl("Example",);
		customer.setFirstName("Example");
		assertTrue(customer.getFirstName().equals("Example"));
	}


### Integration Tests 
Integration Tests make use of Mockito and aure used to test functionality of classes and controllers, domain. Here is an example of a integration test to test the functionality of the create() method:
```	
		@Test
	public void setterGetterTest() {
		toDo = new TDLDomain(1L, "Test Entry", null);
		
		Assertions.assertThat(toDo).isNotNull();
		toDo.setId(1L);
		toDo.setName("Something");
		toDo.setTaskList(null);
		
		Assertions.assertThat(toDo.getId()).isNotNull();
		Assertions.assertThat(toDo.getName()).isNotNull();
		Assertions.assertThat(toDo.getTaskList()).isNull();
```

## Deployment

To deploy this project on a live system, you can use the included war file "HP-TDL-0.0.1-SNAPSHOT.war"

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Validation](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

## Authors

* **Hamza Pervez** - *Project Completion* - [hamzapQA](https://github.com/hamzapQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* QA Training team 
* QA-Community
* Team Trap
* Baeldung
* W3 Schools
* GitHub

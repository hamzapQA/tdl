# TDL - To Do List

description

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

In order to succesfully execute this program, there are a number of dependencies which will need to be installed. These are:

```
1. 
```

### Installing

This is a step by step guide on how to get the project up and running on your local machine for development and testing. 

1. Navigate to the folder in which you would like to set up the project.

```
https://github.com/hamzapQA/tdl-back
```

3. Import the project into your IDE. For Eclipse, 
```
 a) Select File, then Import
 ```
 ## Project Functionality
 
This section provides a brief description on the functionality of the application.

```
-
```
After the credentials have been entered, the menu will appear:

```
Welcome 
```
## Running the tests

The project comes with automated tests which make use of JUnit and Mockito. Tests are organised into classes to test functionality. Test files are stored in src/test/java instead of an individual test class.

### Unit Tests 

Unit tests are used to ensure code works correctly and to protect against bugs. This makes use of JUnit and tests the functionality of the  Customer, Item and Order classes as well as functionality of some of the DAO classes. 

Here is an example of a Unit Test:

	@Test
	public void setFirstNameTest() {
		Customer customer = new Customer("John", "Jones");
		customer.setFirstName("John");
		assertTrue(customer.getFirstName().equals("John"));
	}

To run the tests, right click on the project folder - "Run As JUnit Test"


### Integration Tests 
Integration Tests make use of Mockito and aure used to test functionality of classes and controllers, domain and actions. Here is an example of a integration test to test the functionality of the create() method in CustomerController:
```	
	@Test
	public void testCreate() {
		final String F_NAME = "john", L_NAME = "jones";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```

## Deployment

To deploy this project on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Hamza Pervez** - *Project Completion* - [hamzapQA](https://github.com/hamzapQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* QA Training team for amazing Java concepts, help and support.
* QA-Community
* Team Trap
* GitHub

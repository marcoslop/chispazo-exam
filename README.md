# Exercise

This is an exercise to evaluate some developer skills in order to apply to a backend position inside TuLotero.
 
The exercise consists on several steps that are explained later.
    
Once you have the exercise finished, create a `git patch` and send it to us, so that we can evaluate your solution.

The final objective of this exercise is to see if the developer has some needed skills that are used in TuLotero.
If the developer doesn't have the knowledge yet about these technologies, he should be able to investigate them
by his own and acquire them to solve some parts of this exercise.

We want to see how you develop. I must warn you that, if we have to choose between:

- Code that is super fast and optimum but it's very difficult to understand.
- Code that is not the best solution (in performance) but it's legible and easy to understand.
 
We prefer the second option.

There is no need to finish all the exercise, you can stop whenever you want. Later we will discuss it in an interview.

# Prerequisites in computer

We will need to clone this project, so you need to have Git installed.

This is a Maven project, so you will need to have maven installed in your computer.

This project also uses Lombok. You IDE will need to have a plugin that supports it. Otherwise it won't compile.

For one of the exercises you will need to have Docker installed.

# Chispazo Exercises

Chispazo is a game from Mexico, which consists on playing 5 numbers from 1 to 28. It's very similar to Primitiva in Spain
 but it does not have a Refund number (reintegro)

This project has some business logic classes based on this game. You will need to create some implementations, so that 
all the tests pass.

## Exercise 1 - ChispazoBet

If you execute `mvn clean test` you will see that there are some failed tests in ChispazoBetTests.

ChispazoBet is a class that simulates the numbers that the user is playing. Must be 5 numbers from 1 to 28.

Please, implement the required changes in ChispazoBet, so that ChispazoBetTests passes.

## Exercise 2 - ChispazoPrizeCalculator

If you execute `mvn clean test` you will see that there are some failed tests in ChispazoPrizeCalculatorTest.

ChispazoDrawService is a class that receives a bet from the user, the results of the draw with the winningNumbers
and has to return an inmutable object with the prize and the amount of numbers that he has achieved.

Please, implement the required changes in ChispazoDrawService, so that ChispazoDrawServiceTests passes. 

## Exercise 3 - ChispazoResource

If you execute `mvn clean test` you will see that there are some failed tests in ChispazoResourceTest.

ChispazoResource is the REST entry for Chispazo Logic. Now you can get the information of a draw by invoking: 
`/chispazo/rest/chispazo/draws/1`. This method is already implemented and tested.

But method 'calculatePrizeInfo' is not implemented. Please implement it so that ChispazoResourceTest tests pass.

## mvn clean test SUCCESS

If you have performed the previous exercises correctly you will see a BUILD SUCCESS if you execute `mvn clean test`.

## Exercise 4 - ChispazoResourceIT

This is an integration Test. This test won't be launched until you have achieved a success in previous steps. 

When you execute `mvn clean verify`, a docker image including a wildfly with this war
deployed will be created and started. Once the container is started, ChispazoResourceIT will test our REST API by
performing some real HTTP requests. You will need to perform the required changes in the project so that this test
passes.

In this case we want you to implement a new REST service that returns the next Opened Draw. To know which is the next
one you must use the date of the Draw.

You will need to have docker installed in your machine in order to pass this test.

Once you have achieved this exercise, you will receive a BUILD SUCCESS when you execute `mvn clean verify`.

## Git patch

Please send us a git patch with the solution, so that we can evaluate your solution and talk about it with you.

Don´t send us a pull request because it would be public and other people would see your solution.


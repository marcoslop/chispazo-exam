# Exercise

This is an exercise to evaluate some developer skills in order to apply to a backend position inside TuLotero.
 
The exercise consists on several steps that are explained later.
    
Once you have the exercise finished, create a `git patch` and send it to us, so that we can evaluate your solution.

The final objective of this exercise is to see if the developer has some needed skills that are used in TuLotero.
If the developer doesn't have the knowledge yet about these technologies, he should be able to investigate them
by his own and acquire them to solve some parts of this exercise.

Try to implement the simplest solution posible. If you find a solution for an exercise that has been implemented in three lines... 
don't think you have done it wrong. May be you've found the best approach.

Be aware that we have to understand your solution. Make a special effort to implement it as legible as posible.

For this solution we prefer legibility over performance.

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

Please, implement the required changes in ChispazoBet, so that ChispazoBetTest passes.

## Exercise 2 - ChispazoPrizeCalculator

If you execute `mvn clean test` you will see that there are some failed tests in ChispazoPrizeCalculatorTest.

ChispazoPrizeCalculator is a class that receives a bet from the user, the results of the draw with the winningNumbers
and has to return an inmutable object with the prize and the amount of numbers that he has achieved.

Please, implement the required changes in ChispazoPrizeCalculator, so that ChispazoPrizeCalculatorTests passes. 

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

Try to solve it as simple as possible. Do not suppose that we want an endpoint that can filter
between some status, like next, finished, etc... We only want you to implement an endpoint that returns the next
opened draw for Chispazo. Do not over prepare this method for doing more things that maybe wont be asked never in the future.

## BUILD SUCCESS

Once you have achieved this exercise, you will receive a BUILD SUCCESS when you execute `mvn clean verify`.

## Exercise 5 - Tests

If you use TDD this exercise will not be necessary for you because you already have all the tests done ;-).

Please, make sure that all the implementations you have programmed for exercise 4 come with its corresponding unit tests.

## Git patch

Please send us a git patch with the solution, so that we can evaluate your solution and talk about it with you.

Don´t send us a pull request because it would be public and other people would see your solution.

To review your solution we will create a new local branch and execute `git apply <your_solution.patch>`. Make sure the patch works. 

## Bonus for the interview

Take a look at `ChispazoPrizeService`. It is an empty method with some comments of what has to be done here. We don't want you to implement anything. 
Instead, we want you to think about this logic and the proposed implementation, so that we can talk about it in the technical interview. 

This implementation can be useful if we only have few bets, maybe in a magnitude of hundreds. But imagine that the number of bets start to grow little by little and we are NOT going suddenly from 1.000 bets to 100.000.000. The growing is linear in time and we have time to take the best approach for each time.  

- ¿What problems can you find when the number of bets start to grow? The problems with 100.000 bets may not be the same as with 100.000.000
- ¿What solutions would you propose for each problem? We want you to propose us the best pragmatic solution for each moment. If we have 100.000 bets maybe it's not the time to over-engineer for 100.000.000 bets.

We want you to take a look at this logic and think about it. We will discuss the technical decisions you would take in the technical interview.

## Good Luck

If you have any doubt, don't hesitate to ask to the person of Tulotero who is responsible for this process.

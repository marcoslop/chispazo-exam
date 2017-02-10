# Exercise

This is an exercise to evaluate some developer skills in order to apply to a backend position inside TuLotero.
 
The exercise consists several steps that are explained later.
    
Once you have the exercise finished, create a git patch and send it to us, so that we can evaluate your solution.

The final objective of this exercise is to see if the developer has some needed skills that are used in TuLotero.
If the developer doesn´t have the knowledge yet about these technologies, he should be able to investigate them
by his own and acquire them to solve some parts of this exercise.

There is no need to finish all the exercise, you can stop whenever you want. Later we will discuss it in an interview.

# Prerequisites

This is a Maven project, so you will need to have maven installed in your computer.
This project also uses Lombok. You IDE will need to have a plugin that supports it.
For the second step (verify phase) you will need Docker installed in your computer.

# Chispazo

Chispazo is a mexican game which consists on playing 5 numbers from 1 to 27.

This exercise has some classes that simulate some logic for this game.

# Exercise

This is an exercise to evaluate some developer skills in order to apply to a backend position inside TuLotero.
 
The exercise consists on 2 steps:
    - Achieve build success on Test phase.
    - Achieve build success on Verify phase.
    
Once you have the exercise finished, create a git patch and send it to us, so that we can evaluate your solution.

The final objective of this exercise is to see if the developer has some needed skills that are used in TuLotero.
If the developer doesn´t have the knowledge yet about these technologies, he should be able to investigate them
by his own and acquire them to solve some parts of this exercise.

There is no need to finish all the exercise, you can stop whenever you want. Later we will discuss it in an interview.

# Test phase

First you have to execute 'mvn clean test' and fix all failed tests until you can achieve a 'BUILD SUCCESS'.

# Verify phase

Once you have SUCCESS on the previous step, you will have to execute 'mvn clean verify'. 
This will start a docker container with the project deployed. 
There is a test ChispazoResourceIT, which will fail. You will have to perform the required changes 
to fix this failed test.

Once you have achieved a build success in verify phase you will have finished this exercise.

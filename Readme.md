Devoxx France 2025 Data Oriented Programming and Amber Lab
==========================================================

You can find the slides for this lab here: https://speakerdeck.com/josepaumard/devoxxfr25-dop-lab

## Introduction

This lab covers four elements of the Amber project:

1. Text blocks
2. Records
3. Sealed types and pattern matching
4. Data oriented programming

Each part is implemented in its own module, so that you can follow one or the other, independently.

## Prerequisites

The features showcased in this lab work on JDK 22+, but for compatibility reasons with the `pom.xml` setup within each part, we recommend installing the latest JDK version, JDK 24.

If you do not have JDK 24 locally, you may choose to install it through your IDE or from https://jdk.java.net/24/.

## Working on the Lab

Each module contains its own Readme.md file, with the instructions and hints on how to work on the different parts of the lab. They are all independent, so you can choose the one you want to work on.

## The Amber Features Part

This part is about the basic Amber features: Text blocks, Records, and Pattern Matching. You can start with this module if you are not comfortable with these features. 

You can access it here: [Amber features](A_Amber-features/Readme.md)

### Text Blocks

The Text Block part is about text block and is independent of the rest.

### Records

The Records part shows you how you can work with records. If you are not familiar with records, or have some knowledge, but would like to deep dive in this feature, this part will take you through all you can do with records, and how they work under the hood. The last part of the lab are challenges, you do not need to do them if all you need is a quick introduction.

### Pattern Matching

The Pattern Matching part takes you through a simple example of a sealed hierarchy of types, and how you can use the exhaustive switch on this sealed type to implement some business logic, outside of your object model. This technique is used in the Data oriented programming part of the lab. So if you are not familiar with it, you may want to spend some time understanding it.

## Refactoring to Data Oriented Programming

You can jump to this part directly [here](B_Refactoring-to-DOP/Readme.md). 

The Refactoring to Data Oriented Programming part is about refactoring a small application made of several modules. This part of the lab takes you through an  example where you can refactor a small application using sealed types, records, and pattern matching. The application you will have to refactor is currently written using an object-oriented approach. And it is not quite right: the core business module depends on its implementation details, namely the database, the graphical user interface, and an external service. The first step of this part consists in refactoring the dependencies so that you core business module doesn't depend on anything. Then the second step takes you through the refactoring using a sealed object model, pattern matching, and switch on types. Then the third step is about adding a new type to your model, and see how you can refactor your application to support this new type.

If you are not familiar with sealed types, pattern matching, and switch on types, you should consider starting with [Part 3 of the Amber features part](A_Amber-features/C_Pattern-matching/Readme.md).


## References

- JEP 378 Text Blocks: https://openjdk.org/jeps/378
- JEP 361 Switch Expressions: https://openjdk.org/jeps/361
- JEP 395 Records: https://openjdk.org/jeps/395
- JEP 395 Pattern Matching for instanceof: https://openjdk.org/jeps/394
- JEP 440 Record Patterns: https://openjdk.org/jeps/440
- JEP 441 Pattern Matching for switch: https://openjdk.org/jeps/441
- JEP 456 Unnamed Variables & Patterns: https://openjdk.org/jeps/456
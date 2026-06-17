# Flashcard Study App

A simple app to help you learn a language with flashcards. Add your words and revise!

## Features:

* Adding as many languages (decks) as you want
* Diverse types of challenges - try yourself in open questions, and easier, multiple choice questions.
* You can either choose a type of question or get a random one.
* Selecting a flashcard using weighted random sampling in O(log n) with binary search and prefix sums - user chooses a weight (1-5) of a flashcard.
* Saving user's cards and progress after each study session in library.json file.
* Tracking user's progress - asnwering correctly boosts your level in the deck.

## Requirements:

* Java JDK (version 17 or newer)

## Dependencies:

* Google Gson (v2.11.0): (included in the `lib/` directory).

## How to run:

* Write in terminal:
```javac -cp "lib/gson-2.11.0.jar" src/app/*.java src/model/*.java src/questions/*.java -d bin```
* and then 
  - Linux:
```java -cp "bin;lib/gson-2.11.0.jar" app.Main```
  -  Windows: 
```java -cp "bin;lib/gson-2.11.0.jar" app.Main```

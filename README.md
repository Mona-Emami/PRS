# paper-rock-scissors

Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display a symbol:
- Fist equals rock
- Open hand equals paper
- Showing the index and middle finger equals scissors.

The winner is determined by the following schema:
- Paper beats (wraps) rock
- Rock beats (blunts) scissors
- Scissors beats (cuts) paper.


## Design

All the classes inside this program are created to be testable, readable and maintainable and the program itself is easy to deploy.
Also this program has been designed in a way that:
- Can be extended easily to SPOCK/LIZARD version.
- The user can play the game N times before the program exits.
 
I am tried to follow `KISS` and `Clean Architecture` principles.

Followings are the packages of the program:

- The game package is the main package for the game domain.
- The business package, contains `GameManager` class which includes the main business of the project and we can run the game by invoking the playGame() method of this class.
- The enums package contains `GameResult` enum which has modelled the different statuses of the game and `PlayerSelection` enum which has modelled the (ROCK PAPER SCISSORS) selections and also the game can be extended easily to SPOCK/LIZARD version just by adding SPOCK and LIZARD selections to this enum.
- The players package contains `Player` interface with two different implementations for computer and human player.
- The strategies package contains `GameStrategy` interface in order to be extended easily and allows us to implement different strategies for deciding about computer selection. In this program I have implemented random strategy in order to decide about computer selection.


## Getting Started

Below instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
 
You need followings to build the program:
- Latest version of maven
- JDK 1.8+

### Installing

First of all run following commands to build the project:
```
unzip paper-rock-scissors.zip
cd paper-rock-scissors
mvn install
```

Now you have the final build inside the following directory:
```
target/paper-rock-scissors-1.0-SNAPSHOT.jar
```

Now you can run the project using following command:
```
cd target
java -jar paper-rock-scissors-1.0-SNAPSHOT.jar
```

## Deployment

Copy the `paper-rock-scissors-1.0-SNAPSHOT.jar` from `target` to where ever you want to deploy the build. This directory is the final runnable version of project.
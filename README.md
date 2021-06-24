# Flight-Control-App
An android application that coresponds to a Flight Gear Simulator app.</br>
This app impliment joystick and more for real-time flight in Flight Gear Simultor :shipit:.</br> *This app was written in Kotlin*


## Getting Started
Open Flight Gear Simulator and add the line "--telnet=socket,in,10,[ip],[port],tcp" in the Additional Setting frame. When the ip is the ipv4 of the computer who runs FlightGear.
After downloading the project and the prerequisites, run the application and insert IP and Port in order to connect to the server and then press "Connect".
Engoy!

### General Prerequisites

* [Download](https://www.flightgear.org) FlightGear Simulator.
* Kotlin
* Andriod
### Prerequisites for Developers
* Kotlin
* Android Ide (android studio, Intellij, etc.)


### Dependencies

To use all the features the Android device should have an API level 21 or higher

### Installing
Download the zip for this repository or use git on the termianl. The terminal command is:
```
git clone https://github.com/YehonatanGo/flight_control_app.git
```
Build the project, and run.

### Running The Flight-Control-App
<br /><br /><br /><br />
//TODO : photo and explanation

<br /><br /><br />
#### Features

<br /><br /><br /><br /><br /> TODO : לחרטט משהו <br /><br /><br /><br />

### Project Structure

* MVVM
* Dependency Injection with Strategy Pattern
* (Threadpool)

<br /><br /><br /><br /><br />TODO : UML <br /><br /><br /><br />


<p align="center">
<img src="https://github.com/YehonatanGo/flight_control_app/blob/main/UML/class%20diagram.png">
</p>


- Following the MVVM architectural pattern, there's one main View-Model and sub View-Models, one for each user story.
  As shown in the UML diagram above, the main View-Model (called `FGVM`) implements the IViewModel interface, and the sub View-Models (such as `ControlBarVM`, `JoyStickVM`,...) are inheriting from him (as required in our project instructions).
- The Model is created in the MainWindow, and then passed as an argument to the main View-Model's constructor. Later on, the Model is passed to the rest of the sub View-Models.
- Our MainWindow initializes the main View-Model, and the Simulator screen initializes each sub View-Model in his constructor.
- For more UML diagrams and .cd files (supported by Visual Studio) [Click Here](https://github.com/yanirbuznah/Flight-Inspection-App/tree/master/UML%20photos)
### [Explanation video](https://youtu.be/uIXyFRmBc6w)


### Final Result
<img width="950" alt="Untitled" src="https://github.com/YehonatanGo/flight_control_app/blob/main/preview.jpg">


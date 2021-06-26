# Flight-Control-App
An android application that corresponds to a Flight Gear Simulator app.</br>
This app implements joystick and more for real-time flight in Flight Gear Simultor :shipit:.</br> *This app was written in Kotlin*


## Getting Started
Open Flight Gear Simulator and add the line "--telnet=socket,in,10,[ip],[port],tcp" in the Additional Setting frame. When the ip is the ipv4 of the computer who runs FlightGear.
After downloading the project and the prerequisites, run the application and insert IP and Port in order to connect to the server and then press "Connect".
Enjoy!

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
After activating the simulator and connecting to the IP and PORT.
Click on the aircraft name and then, press auto start:
![image](https://user-images.githubusercontent.com/65356872/123399054-d932ac00-d5ac-11eb-84fc-ed2990454c04.png)
<br/>

<h5  align="center"> Now you can control the plane and fly!! </h5>


### Features

The joystick has 4 features:
1. Elevator control. 
2. Ailerotn control.
3. Rudder control.
4. Throttle control.
<br/>

![image](https://user-images.githubusercontent.com/65356872/123405552-9d9ae080-d5b2-11eb-8931-9c6c0587ce77.png)

### Project Structure

* MVVM
* Dependency Injection with Strategy Pattern
* (Threadpool)



<p align="center">
<img src="https://github.com/YehonatanGo/flight_control_app/blob/main/UML/class%20diagram.png">
</p>

Following the MVVM architectural pattern, there's one main Model, View-Model and View, As shown in the UML diagram above.
<li>
The View as the MainActivity which contains three main parts:  
</li>
<ol>
  <ul>
  <li> 
    "on_button_click" function - Which takes input from the user (ip and port) and connects to Flight-Gear.
  </li>
  </ul>
  <ul>
  <li>
  "Joystick" class - The joystick contains the shape of the joystick and its functionality.    
  </li>
  </ul>
  <ul>
  <li>
  onCreate function - The function is responsible for connecting all parts of the application, joystick and seekbars and inserting their functionality.    
  </li>
  </ul>
</ol>
<li>
The ViewModel connect the view and the model parts.  
 </li>
<li>
  The Model open new thread and socket using Executor and send data to the flight gear app.
</li>

### [Explanation video](https://youtu.be/uIXyFRmBc6w)


### Final Result
<img width="950" alt="Untitled" src="https://github.com/YehonatanGo/flight_control_app/blob/main/preview.jpg">


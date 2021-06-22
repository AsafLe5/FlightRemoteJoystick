# Android App Remote Control Joystick
Our application is a simple joystick control application. The application connect to the flightGear using the device ip, and the flightGear port. After the connection, the user can flight an airplane by himself, using the joystick and the seekBars on the screen.

**App features:**
* **Enter your IP and PORT (6400).**
* **Press on connect button in order to connect flightGear and use our application.**
* **Use the joystick if you want to change the value of "aileron" or "elevator".**
* **Use the seekBars if you want to change the value of "rudder" or "throttle"**
* **Press on disconnect button if you want to disconnect from the flightGear.**

**App content:**

We organized our code in the design pattern of MVVM. These are the folders we created:

* **viewModel - responsible to connect between the view and the model.**
* **model - responsible for connect to flightGear and send requests to it.**
* **view - responsible for showing the joystick and the seekBars to the screen.**
**viewModel**

ViewModel.java - this class connect between the view and the model.

**model**

Model.java - responsible for all logic. Connect and disconnect to flightGear and send requests.

**view**

Joystick.java - responsible for joystick's view.

MainActivity.java - this class get all data from the view and send it to viewModel, and ViewModel.java send it to Model.java.

**Instructions for using the application:**

* Download 'FlightGear' 2020.3.6 application here.
* Open this application.
* Go to settings in the FlightGear application you opened and write under Additional Settings this line: --telnet=socket,in,10,127.0.0.1,6400,tcp
* Press the button Fly in FlightGear. You can press on 'v' in your keyboard to get another angle of the airplane.
* Download android studio version 4.2.1 (latest version). Download here
* Create an Android virtual device (emulator). Click here for set up guild
* Download the repo as zip.
* Extract the folder.
* Enter ‘Android Studio’.
* File -> open.
* Go to the extracted folder.
* Double click on the ‘Android-App-Remote-Control-Joystick’ with the android icon next to it, and then press ‘ok’.
* Now, enter your computer IP and PORT 6400 and click "connect". If the connection failed, check your flightGear. If the connection success, you can control the airplane by the joystick and by the seekBars. Enjoy :)
Android App Remote Control Joystick - Explenation Video

Watch here **WE NEED TO ADD VIDEO**

**Authors:**

* **Ilan Bitan**

* **Asaf Levy**

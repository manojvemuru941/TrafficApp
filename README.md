# Traffic App

A simple android Traffic app demo that demonstrates traffic camera images in city of Calgary.

<img src="https://github.com/manojvemuru941/TrafficApp/blob/main/raw/traffic.png" width="300" height="600">

### How to run project

1. Open Android Studio and click on "Open an existing Android Studio project" or "Import project" on the welcome screen.
2. Browse to the location of your app project on your computer and select it.
3. Android Studio will start importing the project and may take some time to finish. Make sure that you have the necessary Android SDK installed and configured in Android Studio.
4. Once the project is imported, you can run it by clicking on the "Run" button in the toolbar or by selecting "Run" from the "Run" menu.
5. If you have an Android device connected to your computer, you can select it as the deployment target and the app will be installed and run on the device.
6. If you don't have an Android device, you can use an emulator to run the app. Android Studio provides an emulator that you can use to test your app on a variety of virtual devices with different configurations.
7. To launch the emulator, click on the "AVD Manager" button in the toolbar or select "AVD Manager" from the "Tools" menu. Then select the virtual device you want to use and click on the "Play" button to start the emulator.
8. Once the emulator is running, you can select it as the deployment target and run the app.



### Trades offs
* Have n't setup navigation/navigation graph, reason being as its single page application.
* Written only basic unit tests and setup.


### Libraries Used

* Retrofit for network calls.
* Flows/Coroutines for asynchronous/synchronous tasks.
* Hilt dependency injection.
* Glide library to load image (traffic camera images)
* Junit & Mockito for unit test.


###  Architecture pattern

* MVVM + Clean architecture

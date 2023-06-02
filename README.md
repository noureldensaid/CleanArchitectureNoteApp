<h1 align="center">iNotes</h1>

<p align="center">  
🗡️ iNotes demonstrates modern Android development with Jetpack compose, Hilt, Coroutines, Flow, Jetpack (Room, ViewModel), and Material Design based on clean architecture.
</p>
</br>
 

<p align="center">
<img src="https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/f05317cf-407a-43c4-a2e1-e6003bb516b4"  />
 </p>
 
## Tech stack & Open-source libraries
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Jetpack
- Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
- ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
- Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
- [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Clean Architecture
- MVVM Architecture 
- Repository Pattern

## Architecture
**iNotes** is based on the Clean architecture and the MVVM  

![clean architecture](https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/86a75754-4b32-44c6-9031-2d0de23e4e70)

**iNotes** was built following [Android Clean Architecture](https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011), so it would be a great sample to show how the architecture works in real-world projects.

 # Clean Architecture with Android Architecture components
Android simple example shows how to use the clean architecture pattern with android architecture components. 

It retrieves remote data and persists it locally for offline mode. 
It contains only two Activities:- 
1- CustomersActivity: shows list of customers data.
2- ReservationActivity: shows resutarant table map for customer reservation

Clean Architecture
-
![clean_architecture](https://user-images.githubusercontent.com/16631131/44717299-53711800-aac5-11e8-86b5-d3bda1035abc.png)

Architectural approach
-
![clean_architecture_layers](https://user-images.githubusercontent.com/16631131/44717362-73084080-aac5-11e8-9029-10b3da073804.png)

# Android Architecture components Approach
![final-architecture](https://user-images.githubusercontent.com/16631131/44723199-fb8fdc80-aad7-11e8-88b4-dbd93d7441a9.png)


Android Architecture components with clean Architectural reactive approach
-
![clean_architecture_layers_details2](https://user-images.githubusercontent.com/16631131/44722878-2594cf00-aad7-11e8-8820-feedf17b0ba1.png)

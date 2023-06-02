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

![architecture](https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/780224d3-5f62-41ea-9d12-7af02c57cbe1)
## Clean Architecture
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_architecture_reloaded_main.png)

### ----------------------------------------------------------------------------------------------

## Android 3 Layers Architecture
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_architecture_reloaded_layers.png)

### ----------------------------------------------------------------------------------------------

## UI Layer: MVVM 
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_architecture_reloaded_mvvm_app.png)

### ----------------------------------------------------------------------------------------------

## Data Layer: Repository 
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_archictecture_reloaded_repository.png)



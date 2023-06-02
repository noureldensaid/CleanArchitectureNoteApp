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

The overall architecture of **iNotes** is composed of three layers; the UI layer, the domain layer and the data layer. Each layer has dedicated components and they have each different responsibilities, as defined below:

**iNotes** was built with [Guide to app architecture](https://developer.android.com/topic/architecture), so it would be a great sample to show how the architecture works in real-world projects.


### Architecture Overview

![architecture](https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/6523dd8f-6aa0-4d83-8050-afb85f5ed1de)

- Each layer follows [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf); the UI layer emits user events to the data layer, and the data layer exposes data as a stream to other layers.
- The data layer is designed to work independently from other layers and must be pure, which means it doesn't have any dependencies on the other layers.

With this loosely coupled architecture, you can increase the reusability of components and scalability of your app.

### UI Layer

![architecture](https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/53cb3bc4-f151-4114-a698-272348c1ebaa)

The UI layer consists of UI elements to configure screens that could interact with users and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.
- UI elements observe the data flow via [DataBinding](https://developer.android.com/topic/libraries/data-binding), which is the most essential part of the MVVM architecture. 
- With [Bindables](https://github.com/skydoves/bindables), which is an Android DataBinding kit for notifying data changes, you can implement two-way binding, and data observation in XML very clean.

### Data Layer

![architecture](https://github.com/noureldensaid/CleanArchitectureNoteApp/assets/93207605/e6bb598a-d8e8-4dc1-be5b-1438a60b1a89)

The data Layer consists of repositories, which include business logic, such as querying data from the local database and requesting remote data from the network. It is implemented as an offline-first source of business logic and follows the [single source of truth](https://en.wikipedia.org/wiki/Single_source_of_truth) principle.<br>

## Domain Layer
As we know the domain layer consists of models, use cases, repositories create separate directories for each of them



```

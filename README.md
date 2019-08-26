# android-viewmodel
ViewModel is an Android architecture component. It is used as a data manager in the application.

### Problems:-
Rotating a device, configuration changes cause the Activity to be torn down and recreated and data loss.
Another problem is that UI controllers frequently need to make asynchronous calls that may take some time to return. The UI controller needs to manage these calls and ensure the system cleans them up after it's destroyed to avoid potential memory leaks. This management requires a lot of maintenance, and in the case where the object is re-created for a configuration change, it's a waste of resources since the object may have to reissue calls it has already made.

### Solution:-
Android architecture components are a collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence. ViewModel is an Android architecture component. It is used as a data manager in the application. Architecture Components provides ViewModel helper class for the UI controller that is responsible for preparing data for the UI. ViewModel objects are automatically retained during configuration changes so that data they hold is immediately available to the next activity or fragment instance. 
At Google I/O 2017, the Android Framework Team introduced a new set of Architecture Components, one of which deals with this exact rotation issue. That is ViewModel. ViewModel class is designed to hold and manage UI-related data in a life-cycle conscious way. This allows data to survive configuration changes such as screen rotations. Data gets stored somewhere else, outside of the Activity. This is the purpose of the ViewModel class. ViewModels are very nifty for separating out your UI controller code from the data which fills your UI. A ViewModel provides a way to create and retrieve objects. It typically stores the state of a view’s data and communicates with other components.
Architecture components are part of Android Jetpack that persist data, manage lifecycle, make your app modular, help you avoid memory leaks, and prevent you from having to write boring boilerplate code.

Simple Rule: Don’t let your android classes handle everything. Especially not data.


### Implementation:-
* The ViewModel exists from when you first request a ViewModel (usually in the onCreate the Activity) until the Activity is finished and destroyed. onCreate() may be called several times during the life of an Activity, such as when the app is rotated, but the ViewModel survives throughout.
* In general, you’ll make a ViewModel class for each screen in your app.
* ViewModels should not, though, hold a reference to Activities, Fragments, or Contexts. Furthermore, ViewModels should not contain elements that contain references to UI controllers, such as Views, since this will create an indirect reference to a Context.
* ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)
* The first time the ViewModelProviders.of method is called by Activity, it creates a new ViewModel instance. When this method is called again, which happens whenever onCreate is called, it will return the pre-existing ViewModel associated with the specific Activity. This is what preserves the data.
* Sometimes you might need an Application context (as opposed to an Activity context) for use with things like system services. In fact, if you need an Application context, you should extend AndroidViewModel which is simply a ViewModel that includes an Application reference.
* The ViewModel class does keep track of the associations between ViewModel and UI controller instance behind the scenes, using the UI controller you pass in as the first argument.
* If the activity is re-created, it receives the same MyViewModel instance that was created by the first activity. When the owner activity is finished, the framework calls the ViewModel objects's onCleared() method so that it can clean up resources.
* If the 2 fragments in same activity wants to communicate themselves, they can share the same ViewModel object to easily communicate. Example given below link https://developer.android.com/topic/libraries/architecture/viewmodel
* ViewModel can replace Loaders like cursorloader to sync the UI with data with the help of ViewModel, LiveData and Room.
* HolderFragment is a regular Android Headless Fragment. It is the scope where all ViewModels inside the ViewModelStore will live.
* ViewModel vs onSaveInstanceState() :- ViewModel does not replace onSaveInstanceState(). In onSaveInstanceState() we can store only the small amount of data and data needs to be Parcelable, so it’s not so easy to set and restore values. use onSaveInstanceState() to store data necessary for getting data for activity after it’s killed by the system (e.g. id of the current user)

### Dependencies:-
dependencies {
    def lifecycle_version = "2.0.0"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    
    // alternatively - just ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version" 
    
    // alternatively - just LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"

     implementation "android.arch.lifecycle:extensions:1.0.0"
     annotationProcessor "android.arch.lifecycle:compiler:1.0.0"
 }

### Reference Links:-
https://medium.com/androiddevelopers/viewmodels-a-simple-example-ed5ac416317e
https://www.journaldev.com/21081/android-viewmodel
https://developer.android.com/topic/libraries/architecture/viewmodel
https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
https://github.com/inzimam/architecture-components
https://android.jlelse.eu/dive-deep-into-androids-viewmodel-android-architecture-components-e0a7ded26f70
https://android.jlelse.eu/android-architecture-components-viewmodel-e74faddf5b94
https://github.com/googlesamples/android-architecture-components
https://developer.android.com/jetpack/docs/guide#fetching_data
https://github.com/googlesamples/android-architecture-components/tree/master/BasicSample

### FAQs:-
https://www.tutorialspoint.com/mvvm/mvvm_interview_questions.htm
https://www.mytectra.com/interview-question/mvvm-interview-questions-and-answers
https://www.wisdomjobs.com/e-university/mvvm-interview-questions.html

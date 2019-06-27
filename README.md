# YAWA

Yet Another Wallpaper App is just a simple Android App that provides wallpapers from [Unsplash](https://unsplash.com/).

> I created this app as a fun side project just to try architectures and popular technologies. 

> Please refer to the [Built With](#built-with) section for the full description of technologies used.

## Development setup

In order to run this project in your local machine you need an Access Key and a Secret Key from Unsplash. You can get it from [here](https://unsplash.com/join):

Then you need to create a file `koin.properties` like this: 
```properties
ACCESS_KEY=YoUr_AcCeSs_KeY_hErE
SECRET_KEY=YoUr_SeCrEt_KeY_hErE
```

and put it in the path `app/src/main/assets/`


## Built With

* [Kotlin](https://kotlinlang.org/) - Codebase language
* [Architecture Components](https://developer.android.com/topic/libraries/architecture) - Handle ViewModels layer
* [Koin](https://insert-koin.io/) - Dependency Injection
* [Navigation](https://developer.android.com/guide/navigation) - Handle navigation between features
* [RxJava](https://github.com/ReactiveX/RxJava) - Asynchronous and event-based programming

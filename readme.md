# FanDuel Game

![](/images/game.png)



This is a simple game where you have to guess who has the most points! 

On blue the user choice, and green the correct answer.


## Architecture

This game uses `MVP`. 
* implements `Interactor`s to execute work in background threads
* handles data through `Repository pattern`
* updates the user interface by observing the database with a `reactive programming library`
* handles configuration changes with `Fragment.setRetainInstance(true)`
* uses `Dependency Injection`

Data is downloaded everytime the app starts and it is then saved in the local database. 


## Libraries

* [Dagger 2.16](https://github.com/google/dagger)
* [Room 1.1.1](https://developer.android.com/training/data-storage/room/)
* [LiveData 1.1.1](https://developer.android.com/topic/libraries/architecture/livedata)
* [Retrofit 2.4.0](https://github.com/square/retrofit)
* Gson 2.3.0
* [ButterKnife 8.8.1](https://github.com/JakeWharton/butterknife)
* [Glide 4.8.0](https://github.com/bumptech/glide)


## Images

![](/images/main.png)


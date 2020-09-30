package ci.slyest.the.marvel.verse.presentation

import android.app.Application
import ci.slyest.the.marvel.verse.data.di.dataModule
import ci.slyest.the.marvel.verse.presentation.di.presentationModule
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // module list
            modules(dataModule, presentationModule)
        }
    }
}
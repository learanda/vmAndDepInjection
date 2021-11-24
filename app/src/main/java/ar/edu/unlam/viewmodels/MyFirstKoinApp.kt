package ar.edu.unlam.viewmodels

import android.app.Application
import android.content.Context
import androidx.room.Room
import ar.edu.unlam.viewmodels.data.NumeroRepository
import ar.edu.unlam.viewmodels.data.impl.NumeroRepositoryImpl
import ar.edu.unlam.viewmodels.data.room.ViewModelDatabase
import ar.edu.unlam.viewmodels.ui.viewmodels.MainViewModel
import ar.edu.unlam.viewmodels.utils.SeedNumber
import ar.edu.unlam.viewmodels.utils.SeedRandomNumber
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MyFirstKoinApp : Application() {
    val appModule = module {
        single { getDatabase(get()).personaDao() }
        single<SeedNumber> (named("RandomSeed")){ SeedRandomNumber() }
        single<SeedNumber> { SeedNumber() }
        single<NumeroRepository>(named("Random")) { NumeroRepositoryImpl(get(named("RandomSeed")), get()) }
        single<NumeroRepository>() { NumeroRepositoryImpl(get(), get()) }
        viewModel { MainViewModel(get(named("Random"))) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyFirstKoinApp)
            modules(appModule)
        }
    }

    private fun getDatabase(context: Context) =
        Room.databaseBuilder(context, ViewModelDatabase::class.java, "midb").build()
}
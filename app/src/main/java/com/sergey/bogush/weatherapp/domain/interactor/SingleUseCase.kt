package com.sergey.bogush.weatherapp.domain.interactor

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.sergey.bogush.weatherapp.domain.executor.PostExecutionThread
import com.sergey.bogush.weatherapp.domain.executor.ThreadExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by Sergey on 5/25/2018.
 */

abstract class SingleUseCase<T, in Params> constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null) {
        val single = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                as Single<T>
        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}
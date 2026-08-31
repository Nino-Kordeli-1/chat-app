package com.chatapp.data.di.usecase

import com.chatapp.domain.usecase.RegisterUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterUserUseCase(userRepository = get()) }
}
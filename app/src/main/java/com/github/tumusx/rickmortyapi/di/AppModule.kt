package com.github.tumusx.rickmortyapi.di

import com.github.tumusx.rickmortyapi.common.CommonUtil
import com.github.tumusx.rickmortyapi.data.api.CharacterService
import com.github.tumusx.rickmortyapi.data.repository.CharacterRepositoryImp
import com.github.tumusx.rickmortyapi.domain.repsitory.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton

    fun getProvideAPI() : CharacterService{
        return Retrofit.Builder().baseUrl(CommonUtil.BASE_URL_ENDPOINT).
        addConverterFactory(GsonConverterFactory.create()).build().create(CharacterService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetRepository(characterService: CharacterService) : CharacterRepository{
        return CharacterRepositoryImp(characterService)
    }

}
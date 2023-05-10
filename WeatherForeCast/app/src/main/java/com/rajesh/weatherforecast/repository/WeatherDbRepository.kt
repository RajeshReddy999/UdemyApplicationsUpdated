package com.rajesh.weatherforecast.repository

import com.rajesh.weatherforecast.data.WeatherDao
import com.rajesh.weatherforecast.model.Favorite
import com.rajesh.weatherforecast.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {

    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)
    suspend fun deleteAllFavorites() = weatherDao.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)
    suspend fun getFavById(city: String): Favorite = weatherDao.getFavById(city)

    fun getUnits():Flow<List<Unit>> = weatherDao.getUnits()
    suspend fun insertUnit (unit: Unit) = weatherDao.insertUnit(unit)
    suspend fun updateUnit (unit: Unit) = weatherDao.updateUnit(unit)
    suspend fun deleteUnit (unit: Unit) = weatherDao.deleteUnit(unit)
    suspend fun deleteAllUnits () = weatherDao.deleteAllUnits()

}
package com.dev.topefirstapplication.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


/**
 * Copyright (c) 2020 Eniola Ipoola
 * All rights reserved
 * Created on 18-Feb-2020
 */
@Dao
public interface FacilityDao {

   /* @Query("select * from facility")
    LiveData<List<FacilityEntity>> fetchAllFacility();

    @Query("delete from facility")
    void deleteAllFacility();

    @Insert
    void insertAllFacility(List<FacilityEntity> facilityEntity);

    @Query("SELECT COUNT(*) FROM facility")
    int countAllFacilities();*/

}

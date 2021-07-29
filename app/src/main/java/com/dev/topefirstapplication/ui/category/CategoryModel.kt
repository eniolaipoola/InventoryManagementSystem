package com.dev.topefirstapplication.ui.category

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 17-Jul-2021
 */

@Entity
data class CategoryModel(
    @PrimaryKey(autoGenerate = true)
    var id: String,
    var name: String,
    var created_at: String,
    var updated_at: String,
    var updated_by: Int,
)
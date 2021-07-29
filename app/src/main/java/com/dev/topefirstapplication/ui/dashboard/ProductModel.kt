package com.dev.topefirstapplication.ui.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 17-Jul-2021
 */

@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    var id: String,
    var name: String,
    var category_id: Int,
    var barcode: String,
    var amount: Double,
    var created_at: String,
    var updated_at: String,
    var updated_by: Int,
)
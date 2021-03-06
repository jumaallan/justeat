/*
 * Copyright 2021 JustEat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.justeat.presentation.data

data class Restaurant(
    val restaurantId: Long,
    val restaurantName: String,
    val restaurantStatus: String,
    val restaurantBestMatch: Double,
    val restaurantNewest: Double,
    val restaurantRating: Double,
    val restaurantDistance: Double,
    val restaurantPopularity: Double,
    val restaurantAverageProductPrice: Int,
    val restaurantDeliveryCost: Int,
    val restaurantMinCost: Int,
    val isFavourite: Boolean
)
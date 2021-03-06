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
package com.justeat.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justeat.presentation.data.Restaurant
import com.justeat.presentation.databinding.RowRestaurantBinding

typealias OnFavouriteClickListener = (Restaurant) -> Unit

object RestaurantDiffer : DiffUtil.ItemCallback<Restaurant>() {

    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
        oldItem.restaurantName == newItem.restaurantName

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) = oldItem == newItem
}

internal class RestaurantRecyclerViewAdapter(
    private val onFavouriteClickListener: OnFavouriteClickListener
) :
    ListAdapter<Restaurant, RestaurantRecyclerViewAdapter.ViewHolder>(RestaurantDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RowRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onFavouriteClickListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: RowRestaurantBinding,
        private val onFavouriteClickListener: OnFavouriteClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.restaurant = restaurant
            binding.btnFavourite.setOnClickListener {
                onFavouriteClickListener(restaurant)
            }
            binding.executePendingBindings()
        }
    }
}
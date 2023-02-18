package com.example.git_followers.app.data.datasource

import com.example.git_followers.app.data.datasource.Items
import com.google.gson.annotations.SerializedName


data class UserResultSearchName (

  @SerializedName("total_count"        ) var totalCount        : Int?             = null,
  @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
  @SerializedName("items"              ) var items             : ArrayList<Items> = arrayListOf()

)
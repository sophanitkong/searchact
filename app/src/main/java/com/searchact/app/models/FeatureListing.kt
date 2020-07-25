package com.searchact.app.models

data class FeatureListing(
    var image: Int,
    var title: String,
    var date: String,
    var location: String,
    var address: String,
    var phoneNumber: String,
    var dateTime: String,
    var website: String,
    var vote: Int,
    var rate: Int
)
package yiyo.com.dashboard.data.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("color") val color: String,
    @SerializedName("description") val description: String,
    @SerializedName("urls") val urls: Urls,
    @SerializedName("links") val links: Links
)
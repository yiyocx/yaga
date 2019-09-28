package yiyo.com.dashboard.ui

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import yiyo.com.dashboard.data.models.UnsplashPhoto
import yiyo.com.dashboard.ui.views.AspectRatioImageView

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

@BindingAdapter("photo")
fun AspectRatioImageView.setPhoto(photo: UnsplashPhoto) {
    aspectRatio = photo.height.toDouble() / photo.width.toDouble()
    setBackgroundColor(Color.parseColor(photo.color))
    setImageUrl(photo.urls.regular)
}
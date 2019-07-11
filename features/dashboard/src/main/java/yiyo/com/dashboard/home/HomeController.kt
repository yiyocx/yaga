package yiyo.com.dashboard.home

import com.airbnb.epoxy.TypedEpoxyController
import yiyo.com.dashboard.data.models.Photo
import yiyo.com.dashboard.itemPhoto

class HomeController : TypedEpoxyController<List<Photo>>() {

    override fun buildModels(photos: List<Photo>) {
        photos.forEach { photo ->
            itemPhoto {
                id(photo.id)
                url(photo.urls.regular)
            }
        }
    }
}
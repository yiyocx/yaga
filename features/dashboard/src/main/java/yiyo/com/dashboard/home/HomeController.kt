package yiyo.com.dashboard.home

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import yiyo.com.dashboard.ItemPhotoBindingModel_
import yiyo.com.dashboard.data.models.UnsplashPhoto

class HomeController : PagedListEpoxyController<UnsplashPhoto>() {
    override fun buildItemModel(currentPosition: Int, item: UnsplashPhoto?): EpoxyModel<*> {
        return if (item != null) {
            ItemPhotoBindingModel_()
                .id(item.id)
                .photo(item)
        } else {
            ItemPhotoBindingModel_()
                .id(-currentPosition)
                .photo(item)
        }
    }
}
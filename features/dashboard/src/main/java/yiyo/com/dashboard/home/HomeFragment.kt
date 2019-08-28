package yiyo.com.dashboard.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import yiyo.com.dashboard.R
import yiyo.com.dashboard.ui.ItemOffsetDecoration

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private val controller = HomeController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()

        viewModel.observePhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                controller.setData(it)
            }, {
                println(it)
            })
    }

    private fun setupRecyclerView() {
        recyclerView.addItemDecoration(ItemOffsetDecoration(resources.getDimensionPixelSize(R.dimen.photo_item_margin)))
        recyclerView.adapter = controller.adapter
    }
}

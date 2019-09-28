package yiyo.com.dashboard.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import kotlinx.android.synthetic.main.fragment_home.*
import yiyo.com.dashboard.R
import yiyo.com.dashboard.ui.ItemOffsetDecoration

class HomeFragment : BaseMvRxFragment() {

    private val viewModel: HomeViewModel by fragmentViewModel()
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
    }

    private fun setupRecyclerView() {
        recyclerView.addItemDecoration(ItemOffsetDecoration(resources.getDimensionPixelSize(R.dimen.photo_item_margin)))
        recyclerView.adapter = controller.adapter
    }

    override fun invalidate() = withState(viewModel) { state ->
        controller.submitList(state.photos)
    }
}

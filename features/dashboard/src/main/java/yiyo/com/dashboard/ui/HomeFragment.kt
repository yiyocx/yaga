package yiyo.com.dashboard.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import yiyo.com.dashboard.R

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println(viewModel)
    }
}

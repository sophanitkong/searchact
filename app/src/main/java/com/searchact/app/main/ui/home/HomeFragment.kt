package com.searchact.app.main.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.category.CategoryActivity
import com.searchact.app.feeds.FeatureListingActivity
import com.searchact.app.feeds.FeatureListingAdapter
import com.searchact.app.feeds.OnItemListingClickedListener
import com.searchact.app.main.data.Category
import com.searchact.app.main.ui.feeds.SearchBottomSheetFragment
import com.searchact.app.models.FeatureListing
import com.searchact.app.productcategory.ProductCategoryActivity
import com.searchact.app.profile.ProfileActivity
import com.searchact.app.viewdetail.ViewDetailActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var root: View
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryLayoutManager: GridLayoutManager

    private lateinit var featureListingAdapter: FeatureListingAdapter
    private lateinit var featureListingLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        categoryAdapter = CategoryAdapter(ArrayList())
        categoryLayoutManager = GridLayoutManager(container?.context, 4)

        featureListingAdapter = FeatureListingAdapter(arrayListOf())
        featureListingLayoutManager = LinearLayoutManager(container?.context)

        root = inflater.inflate(R.layout.fragment_home, container, false)
        val rcCategory: RecyclerView = root.findViewById(R.id.rcCategory)
        val rcHomeFeatureListing: RecyclerView = root.findViewById(R.id.rcHomeFeatureListing)

        rcCategory.layoutManager = categoryLayoutManager
        rcHomeFeatureListing.layoutManager = featureListingLayoutManager

        homeViewModel.categories.observe(viewLifecycleOwner, Observer {
            categoryAdapter.categories = it
            categoryAdapter.notifyDataSetChanged()
        })

        homeViewModel.features.observe(viewLifecycleOwner, Observer {
            featureListingAdapter.features = it
            featureListingAdapter.notifyDataSetChanged()
        })

        rcCategory.adapter = categoryAdapter
        rcHomeFeatureListing.adapter = featureListingAdapter

        root.tvViewAllCategory.setOnClickListener {
            startActivity(Intent(root.context, CategoryActivity::class.java))
        }

        categoryAdapter.onCategoryClicked = object : OnCategoryClicked {
            override fun onCategoryClicked(category: Category) {
                val intent = Intent(root.context, ProductCategoryActivity::class.java)
                intent.putExtra("category_name", category.name)
                startActivity(intent)
            }
        }

        featureListingAdapter.listener = object : OnItemListingClickedListener {
            override fun onViewClicked(feature: FeatureListing) {
                val intent = Intent(root.context, ViewDetailActivity::class.java)
                startActivity(intent)
            }
        }

        setEvent()

        return root
    }

    private fun setEvent() {
        root.llProfile.setOnClickListener(onClicked)
        root.ivHomeSearch.setOnClickListener(onClicked)
        root.tvViewAllFeatListing.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            root.llProfile.id -> {
                startActivity(Intent(root.context, ProfileActivity::class.java))
            }

            root.ivHomeSearch.id -> {
                showBottomSearchDialog()
            }

            root.tvViewAllFeatListing.id -> {
                startActivity(Intent(root.context, FeatureListingActivity::class.java))
            }
        }
    }

    private fun showBottomSearchDialog() {
        val addSearchBottomDialogFragment =
            SearchBottomSheetFragment.newInstance()
        addSearchBottomDialogFragment?.isCancelable = false
        addSearchBottomDialogFragment?.show(
            childFragmentManager,
            "search_dialog_fragment_home"
        )
    }
}

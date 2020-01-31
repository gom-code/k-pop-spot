package com.example.k_pop.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k_pop.R
import com.example.k_pop.activity.CategoryDetailActivity
import com.example.k_pop.activity.MapDetailActivity
import com.example.k_pop.activity.UserInfoEditActivity
import kotlinx.android.synthetic.main.fragment_board_page.*
import org.jetbrains.anko.support.v4.startActivity

class BoardPageFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_board_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        textbtn_category_detail.setOnClickListener {
           startActivity<CategoryDetailActivity>()
        }

        textbtn_map.setOnClickListener {
            startActivity<MapDetailActivity>("X" to 100, "Y" to 100)
        }

    }
}
package com.example.k_pop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.k_pop.Get.PlaceRecommendData
import com.example.k_pop.R
import com.example.k_pop.activity.SpotViewMoreActivity
import org.jetbrains.anko.startActivity


class PlaceRecommendRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<PlaceRecommendData>) : RecyclerView.Adapter<PlaceRecommendRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_category_detail_recommend_spot, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder.image
        holder.mainTitle.text = dataList[position].name

        val requestOptions = RequestOptions()
        Glide.with(ctx)
                .load(dataList[position].img)
                .into(holder.image)

        holder.image.setOnClickListener {
            ctx.startActivity<SpotViewMoreActivity>("spot_id" to dataList[position].spot_id, "event_flag" to 0)
        }
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.iv_rv_item_spot_main_img) as ImageView
        var mainTitle : TextView = itemView.findViewById(R.id.tv_rv_item_spot_main_title) as TextView
    }
}
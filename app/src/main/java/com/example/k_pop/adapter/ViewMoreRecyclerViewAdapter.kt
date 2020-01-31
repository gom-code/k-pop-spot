package com.example.k_pop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.k_pop.Get.ViewMoreData
import com.example.k_pop.R
import com.example.k_pop.activity.SpotViewMoreActivity
import org.jetbrains.anko.startActivity

class ViewMoreRecyclerViewAdapter(val ctx : Context, val moreDataList : ArrayList<ViewMoreData>) : RecyclerView.Adapter<ViewMoreRecyclerViewAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_view_more_activity_spot, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = moreDataList.size

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: Holder, position: Int) {
//        moreDataList[position].img[0]?.let {
//            Glide.with(ctx).load(it).into(holder.image)
//        }

        Glide.with(ctx).load(moreDataList[position].img).apply(RequestOptions().centerCrop()).into(holder.image)
        holder.title.text = moreDataList[position].name
        holder.content.text = moreDataList[position].description
        holder.address.text = moreDataList[position].address_gu + " · " + moreDataList[position].station
        holder.reviewScore.text = moreDataList[position].review_score.toString()

        val badgeRecyclerViewAdapter : ChannelBadgeRecyclerViewAdapter = ChannelBadgeRecyclerViewAdapter(ctx, moreDataList[position].channel)
        holder.badgeList.layoutManager = LinearLayoutManager(ctx,0,false)
        holder.badgeList.adapter = badgeRecyclerViewAdapter

        holder.cardBtn.setOnClickListener {
            ctx.startActivity<SpotViewMoreActivity>("spot_id" to moreDataList[position].spot_id, "event_flag" to 0)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.rv_item_view_more_spot_img) as ImageView
        val title: TextView = itemView.findViewById(R.id.rv_item_view_more_spot_title) as TextView
        val content: TextView = itemView.findViewById(R.id.rv_item_view_more_spot_content) as TextView
        val reviewScore: TextView = itemView.findViewById(R.id.rv_item_view_more_spot_star_pnt) as TextView
        val address: TextView = itemView.findViewById(R.id.rv_item_view_more_spot_address) as TextView
        val badgeList : RecyclerView = itemView.findViewById(R.id.rv_view_more_act_badge_list) as RecyclerView

        val cardBtn : CardView = itemView.findViewById(R.id.rv_item_view_more_spot_card) as CardView

    }
}
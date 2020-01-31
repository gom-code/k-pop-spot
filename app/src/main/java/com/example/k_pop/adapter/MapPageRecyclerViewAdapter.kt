package com.example.k_pop.adapter

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
import com.example.k_pop.Get.MapPageSpotData
import com.example.k_pop.R
import com.example.k_pop.activity.SpotViewMoreActivity
import org.jetbrains.anko.startActivity

class MapPageRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<MapPageSpotData>): RecyclerView.Adapter<MapPageRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_map_page_my_around_k_spot, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder.image
        Glide.with(ctx).load(dataList[position].img).apply(RequestOptions().centerCrop()).into(holder.image)
        holder.title.text = dataList[position].name
        holder.content.text = dataList[position].description
        holder.address.text = dataList[position].address_gu + " · " + dataList[position].station
        holder.starPoint.text = dataList[position].review_score.toString()

        val badgeRecyclerViewAdapter  = ChannelBadgeRecyclerViewAdapter(ctx, dataList[position].channel)
        holder.badgeList.layoutManager = LinearLayoutManager(ctx,0,false)
        holder.badgeList.adapter = badgeRecyclerViewAdapter

        holder.cardBtn.setOnClickListener {
            ctx.startActivity<SpotViewMoreActivity>("spot_id" to dataList[position].spot_id, "event_flag" to 0)
        }
    }

    fun clearDataList(){
        dataList.clear()
        notifyDataSetChanged()
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_img) as ImageView
        val title : TextView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_title) as TextView
        val content : TextView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_content) as TextView
        val starPoint : TextView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_star_pnt) as TextView
        val address : TextView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_address) as TextView
        val badgeList : RecyclerView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_badge_list) as RecyclerView
        val cardBtn : CardView = itemView.findViewById(R.id.rv_item_map_page_my_around_k_spot_btn) as CardView
    }

}
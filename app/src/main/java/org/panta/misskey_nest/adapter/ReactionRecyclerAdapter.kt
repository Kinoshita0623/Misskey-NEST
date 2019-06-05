package org.panta.misskey_nest.adapter

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.panta.misskey_nest.R
import org.panta.misskey_nest.entity.ReactionCountPair
import org.panta.misskey_nest.interfaces.ItemClickListener

class ReactionRecyclerAdapter(private val reactionList: List<ReactionCountPair>, private val myReactionType: String?)
    : RecyclerView.Adapter<ReactionHolder>(){

    /*private val reactionList = reactionCountMap.map{
        it.key to it.value
    }*/

    var reactionItemClickListener: ItemClickListener<String>? = null



    override fun getItemCount(): Int {
        return reactionList.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReactionHolder {
        val inflater = LayoutInflater.from(p0.context).inflate(R.layout.item_reaction_counter, p0, false)

        return ReactionHolder(inflater)
    }

    override fun onBindViewHolder(p0: ReactionHolder, position: Int) {
        val reaction = reactionList[position]
        val isMyReaction = reaction.reactionType == myReactionType
        //val drawable = Drawable.createFromPath("reaction_icon_${reaction.reactionType}.png")
        p0.showReaction(reaction.reactionCount.toString(), reaction.reactionType, isMyReaction)

        p0.itemClickListener = reactionItemClickListener

    }
}
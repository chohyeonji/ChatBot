package com.example.chatbot.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot.R
import com.example.chatbot.data.Message
import com.example.chatbot.utills.Constants.RECEIVE_ID
import com.example.chatbot.utills.Constants.SEND_ID
import kotlinx.android.synthetic.main.message_item.view.*

class MessagingAdapter : RecyclerView.Adapter <MessagingAdapter.MessageViewHolder>(){

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
       return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
       val currenMessage = messagesList[position]

        when (currenMessage.id){
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                    text = currenMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }

            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply {
                text = currenMessage.message
                visibility = View.VISIBLE
            }
                holder.itemView.tv_message.visibility = View.GONE
            }

        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }
    fun insertMessage(message: Message){
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }
}
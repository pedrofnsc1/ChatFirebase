package tads.eaj.ufrn.tadschatinicio

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import tads.eaj.ufrn.chatfirebaseinicio.R


class MessageAdapter(var c:Context,var r:Int, var messages:ArrayList<FriendlyMessage> ) : ArrayAdapter<FriendlyMessage>(c, r, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var holder:MensagemViewHolder
        var view:View

        if (convertView == null){
            view = LayoutInflater.from(c).inflate(r, parent, false)
            holder = MensagemViewHolder(view)
            view.tag = holder
        }else{
            view = convertView
            holder  = convertView.tag as MensagemViewHolder
        }

        val message = messages[position]

        val isPhoto = message.photoUrl != null
        if (isPhoto) {
            holder.messageTextView.visibility = View.GONE
            holder.photoImageView.visibility = View.VISIBLE
            Glide.with(holder.photoImageView.context)
                .load(message.photoUrl)
                .into(holder.photoImageView)
        } else {
            holder.messageTextView.visibility = View.VISIBLE
            holder.photoImageView.visibility = View.GONE
            holder.messageTextView.text = message.text
        }
        holder.authorTextView.text = message.name

        return view
    }
}
package ru.netology.nmedia.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.post.Post
import ru.netology.nmedia.post.countFormat

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeClicked: OnLikeClicked,
    private val onShareClicked: OnShareClicked

) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {
            heart.setImageResource(
                if (post.likedByMe) R.drawable.liked_heart else R.drawable.heart_outline
            )
            author.text = post.author
            published.text = post.published
            content.text = post.content
            countLikes.text = countFormat(post.countLikes)
            countShare.text = countFormat(post.countShare)
            countView.text = countFormat(post.countView)

            heart.setOnClickListener {
                onLikeClicked(post)
            }
            share.setOnClickListener {
                onShareClicked(post)
            }
        }
    }
}
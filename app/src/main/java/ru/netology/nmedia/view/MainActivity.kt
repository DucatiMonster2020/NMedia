package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.adapter.PostAdapter
import ru.netology.nmedia.databinding.ActivityPageBinding
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { posts ->
            binding.container.removeAllViews()
            posts.map { post ->
                CardPostBinding.inflate(layoutInflater, binding.root, false).apply {
                    author.text = post.author
                    published.text = post.published
                    content.text = post.content
                    heart.setImageResource(
                        if (post.likedByMe) R.drawable.liked_heart else R.drawable.heart_outline
                    )
                    heart.setOnClickListener {
                        viewModel.likeById(post.id)
                    }
                }.root
            }
        }
        //val adapter = PostAdapter {
           // viewModel.likeById(it.id)
       // }
      //  binding.main.adapter = adapter

        //val viewModel: PostViewModel by viewModels()

       // viewModel.data.observe(this) { posts ->
         //   adapter.submitList(posts)
         //   }
        }
    }

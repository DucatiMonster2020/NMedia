package ru.netology.nmedia.view
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityPageBinding
import ru.netology.nmedia.post.countFormat
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                heart.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.liked_heart
                    } else {
                        R.drawable.heart_outline
                    }
                )
                author.text = post.author
                published.text = post.published
                content.text = post.content
                countLikes.text = countFormat(post.countLikes)
                countShare.text = countFormat(post.countShare)
                countView.text = countFormat(post.countView)
            }
        }
        binding.heart.setOnClickListener {
            viewModel.like()
        }
        binding.share.setOnClickListener {
            viewModel.share()
        }
    }
}
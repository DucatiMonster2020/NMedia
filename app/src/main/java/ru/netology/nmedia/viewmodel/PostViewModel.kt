package ru.netology.nmedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.post.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemory

class PostViewModel: ViewModel() {
    private  val repository: PostRepository = PostRepositoryInMemory()
    val data: LiveData<Post> = repository.get()
    fun like() {
        repository.like()
    }
    fun share () {
        repository.share()
    }
}
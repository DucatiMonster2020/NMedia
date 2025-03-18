package ru.netology.nmedia.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.post.Post

class PostRepositoryInMemory: PostRepository {
    private var posts = listOf(
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "18 сентября в 10:12",
            content = "Знаний хватит на всех, на следующей неделе разбираемся....",
            likedByMe = false,
            sharedByMe = false,
            countLikes = 992,
            countShare = 1998,
            countView = 1300000
        ),
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likedByMe = false,
            sharedByMe = false,
            countLikes = 999,
            countShare = 3999,
            countView = 1300000
        ),
    )
    private val data = MutableLiveData(posts)

    override fun get(): LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
            post.copy(
                likedByMe = !post.likedByMe,
                countLikes = if (post.likedByMe) {
                    post.countLikes - 1
                } else {
                    post.countLikes + 1
                }
            )
        } else {
            post
        }
        }
        data.value = posts
    }
    override fun shareById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(
                    sharedByMe = !post.sharedByMe,
                    countShare = post.countShare + 1
                )
            } else {
                post
            }
        }
        data.value = posts
    }
}
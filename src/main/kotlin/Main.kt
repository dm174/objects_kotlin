data class Post(
    var id : Int,
    var likes: Likes = Likes(0)
)
data class Likes (
    var count : Int
)
object WallService {
            private var posts = arrayOf<Post>()
            private var lastId=0
    fun add (post:Post) :Post {
                posts += post.copy(id =++lastId, likes = post.likes.copy())
                return posts.last()

            }
    fun update(newPost:Post):Boolean {

        for ((index,post)in posts.withIndex()) {
            if (post.id ==newPost.id){
                posts[index]=newPost.copy(likes = newPost.likes.copy())
            return true
            }
        }
        return false

    }
            fun print() {
                for (post in posts) {
                    print(post)
                    print (' ')
                }
                println()
            }
        }
fun main(){
    val post = Post(0)
    WallService.add(post)
    WallService.add(Post(1))
    WallService.add(Post(2))
    WallService.print()
   //post.id=2
   // WallService.print()
    WallService.update(Post(2,Likes (12)))
    WallService.print()
}
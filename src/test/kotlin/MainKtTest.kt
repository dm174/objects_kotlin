import org.junit.Assert.*
import org.junit.Test
class MainKtTest {
    @Test
    fun testAddPost() {
        val post = Post(0)
        val addedPost = WallService.add(post)
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun testUpdateExistingPost() {
        val post = Post(0)
        WallService.add(post)
        val updatedPost = Post(1, Likes(12))
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

    @Test
    fun testUpdateNonExistingPost() {
        val updatedPost = Post(2, Likes(12))
        val result = WallService.update(updatedPost)
       assertFalse(result)
    }
}



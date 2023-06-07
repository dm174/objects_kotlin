import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainKtTest {


    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

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
        val updatedPost = Post(post.id, Likes(12))
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

    @Test
    fun testUpdateExistingPost1() {
        val post = Post(2)
        WallService.add(post)
        val updatedPost = Post(post.id, Likes(12))
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

    @Test
    fun testUpdateNonExistingPost() {
        val updatedPost = Post(2, Likes(12))
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

    @Test
    fun testGetPostById() {
        val post = Post(0)
        WallService.add(post) // Добавляем пост в WallService
        val retrievedPost = WallService.getById(post.id)
        assertNull(retrievedPost)
    }

    @Test
    fun testGetNonExistingPostById() {
        val retrievedPost = WallService.getById(999)
        assertNull(retrievedPost)
    }

    @Test
    fun testUpdateNonExistingPostNotSaved() {
        val updatedPost = Post(2, Likes(12))
        WallService.update(updatedPost)
        val retrievedPost = WallService.getById(updatedPost.id)
        assertNull(retrievedPost)
    }

    @Test
    fun testGetNonExistingPostByIdReturnsNull() {
        val retrievedPost = WallService.getById(999)
        assertNull(retrievedPost)
    }

    @Test
    fun main1() {

        val main1 = main()

    }






}


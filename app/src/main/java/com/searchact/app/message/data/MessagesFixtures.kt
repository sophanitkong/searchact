package com.searchact.app.message.data

import java.security.SecureRandom
import java.util.*

class MessagesFixtures : FixturesData() {
    private fun MessagesFixtures() {
        throw AssertionError()
    }

    fun getTextMessage(): Message? {
        return getTextMessage(getRandomMessage())
    }

    fun getTextMessage(text: String?): Message? {
        return Message(getRandomId()!!, getUser()!!, text!!)
    }

    private fun getUser(): User? {
        val even = rnd.nextBoolean()
        return User(
            if (even) "0" else "1",
            if (even) names[0]!! else names[1]!!,
            if (even) avatars[0]!! else avatars[1]!!,
            true
        )
    }
}

abstract class FixturesData {
    var rnd = SecureRandom()

    var avatars: ArrayList<String?> =
        object : ArrayList<String?>() {
            init {
                add("http://i.imgur.com/pv1tBmT.png")
                add("http://i.imgur.com/R3Jm1CL.png")
                add("http://i.imgur.com/ROz4Jgh.png")
                add("http://i.imgur.com/Qn9UesZ.png")
            }
        }

    val groupChatImages: ArrayList<String?> =
        object : ArrayList<String?>() {
            init {
                add("http://i.imgur.com/hRShCT3.png")
                add("http://i.imgur.com/zgTUcL3.png")
                add("http://i.imgur.com/mRqh5w1.png")
            }
        }

    val groupChatTitles: ArrayList<String?> =
        object : ArrayList<String?>() {
            init {
                add("Samuel, Michelle")
                add("Jordan, Jordan, Zoe")
                add("Julia, Angel, Kyle, Jordan")
            }
        }

    val names: ArrayList<String?> = object : ArrayList<String?>() {
        init {
            add("Samuel Reynolds")
            add("Kyle Hardman")
            add("Zoe Milton")
            add("Angel Ogden")
            add("Zoe Milton")
            add("Angelina Mackenzie")
            add("Kyle Oswald")
            add("Abigail Stevenson")
            add("Julia Goldman")
            add("Jordan Gill")
            add("Michelle Macey")
        }
    }

    val messages: ArrayList<String?> =
        object : ArrayList<String?>() {
            init {
                add("Hello!")
                add("This is my phone number - +1 (234) 567-89-01")
                add("Here is my e-mail - myemail@example.com")
                add("Hey! Check out this awesome link! www.github.com")
                add("Hello! No problem. I can today at 2 pm. And after we can go to the office.")
                add("At first, for some time, I was not able to answer him one word")
                add("At length one of them called out in a clear, polite, smooth dialect, not unlike in sound to the Italian")
                add("By the bye, Bob, said Hopkins")
                add("He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other; and they contrived their business very well, for they came up to the ship about midnight.")
                add("So saying he unbuckled his baldric with the bugle")
                add("Just then her head struck against the roof of the hall: in fact she was now more than nine feet high, and she at once took up the little golden key and hurried off to the garden door.")
            }
        }

    val images: ArrayList<String?> =
        object : ArrayList<String?>() {
            init {
                add("https://habrastorage.org/getpro/habr/post_images/e4b/067/b17/e4b067b17a3e414083f7420351db272b.jpg")
                add("https://cdn.pixabay.com/photo/2017/12/25/17/48/waters-3038803_1280.jpg")
            }
        }

    open fun getRandomId(): String? {
        return java.lang.Long.toString(UUID.randomUUID().leastSignificantBits)
    }

    open fun getRandomAvatar(): String? {
        return avatars[rnd.nextInt(avatars.size)]
    }

    open fun getRandomGroupChatImage(): String? {
        return groupChatImages[rnd.nextInt(groupChatImages.size)]
    }

    open fun getRandomGroupChatTitle(): String? {
        return groupChatTitles[rnd.nextInt(groupChatTitles.size)]
    }

    open fun getRandomName(): String? {
        return names[rnd.nextInt(names.size)]
    }

    open fun getRandomMessage(): String? {
        return messages[rnd.nextInt(messages.size)]
    }

    open fun getRandomImage(): String? {
        return images[rnd.nextInt(images.size)]
    }

    open fun getRandomBoolean(): Boolean {
        return rnd.nextBoolean()
    }
}
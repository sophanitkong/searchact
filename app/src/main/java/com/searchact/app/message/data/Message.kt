package com.searchact.app.message.data

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import java.util.*

class Message constructor(var ids: String, var user: User, var texts: String) : IMessage {

    override fun getId(): String = ids

    override fun getCreatedAt(): Date = Date()

    override fun getUser(): IUser = user

    override fun getText(): String = texts

}

class User constructor(
    var ids: String,
    var names: String,
    var avatars: String,
    var online: Boolean
) : IUser {
    override fun getAvatar(): String = avatars

    override fun getName(): String = names

    override fun getId(): String = ids

}
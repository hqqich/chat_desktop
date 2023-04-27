package data

/**
 * @param userID 用户ID
 * @param headPath 头像
 * @param message 消息
 * @param messageImg 消息图片
 * @param messageType 消息类型
 *
 */
data class WxMessageBean(
    val userID: String,
    var headPath: String,
    var message: String,
    var messageImg: String,
    var messageType: MessageType
)
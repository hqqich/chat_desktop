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

//聊天详情内容
//wxMessages.add(WxMessageBean("002","images/item_a.png","有美女照片没有?","images/mn_1.png",MessageType.MESSAGE))
//wxMessages.add(WxMessageBean("001","images/item_d.png","","images/mn_1.png",MessageType.IMAGE))
//wxMessages.add(WxMessageBean("001","images/item_d.png","漂亮不?还有...","images/mn_1.png",MessageType.MESSAGE))
//wxMessages.add(WxMessageBean("001","images/item_d.png","","images/mn_2.png",MessageType.IMAGE))
//wxMessages.add(WxMessageBean("002","images/item_a.png","有没有健身的妹纸呀?这些美女照片太多了没意思...要刚柔并进。你的明白吧?","images/mn_1.png",MessageType.MESSAGE))
//wxMessages.add(WxMessageBean("001","images/item_d.png","安心学技术多好,看啥美女对不?","images/mn_2.png",MessageType.MESSAGE))
//wxMessages.add(WxMessageBean("001","images/item_d.png","Compose最近看了一眼,也能跨平台呢?","images/mn_2.png",MessageType.MESSAGE))
//wxMessages.add(WxMessageBean("002","images/item_a.png","是的没错! 但是我觉得Flutter目前更胜一筹在Web端方面","images/mn_1.png",MessageType.MESSAGE))



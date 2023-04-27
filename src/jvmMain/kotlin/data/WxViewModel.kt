package data

import androidx.compose.runtime.mutableStateListOf

object WxViewModel {

    val wxMessages: MutableList<WxMessageBean> = mutableStateListOf()

    init {
        wxMessages.add(
            WxMessageBean(
                "002",
                "images/image.jpg",
                "有美女照片没有?",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "001",
                "images/image.jpg",
                "",
                "images/image.jpg",
                MessageType.IMAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "001",
                "images/image.jpg",
                "漂亮不?还有...",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "001",
                "images/image.jpg",
                "",
                "images/image.jpg",
                MessageType.IMAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "002",
                "images/image.jpg",
                "有没有健身的妹纸呀?这些美女照片太多了没意思...要刚柔并进。你的明白吧?",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "001",
                "images/image.jpg",
                "安心学技术多好,看啥美女对不?",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "001",
                "images/image.jpg",
                "Compose最近看了一眼,也能跨平台呢?",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
        wxMessages.add(
            WxMessageBean(
                "002",
                "images/image.jpg",
                "是的没错! 但是我觉得Flutter目前更胜一筹在Web端方面aa",
                "images/image.jpg",
                MessageType.MESSAGE
            )
        )
    }
}
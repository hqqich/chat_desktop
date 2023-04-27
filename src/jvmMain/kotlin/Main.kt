// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import data.MessageType
import data.WxMessageBean
import data.WxViewModel
import kotlinx.coroutines.launch
import org.jetbrains.skia.Image
import java.io.File

@Composable
@Preview
fun App() {


    MaterialTheme {

        Row(
            modifier = Modifier
                .size(width = 1000.dp, height = 800.dp)
                .background(Color.White),
            verticalAlignment = Alignment.Top, // 垂直居中
            horizontalArrangement = Arrangement.SpaceBetween // 水平方向: 前后没有空隙，且子view之间均匀分散
        )
        {

            // 左边占比1
            left(modifier = Modifier.weight(1f/3f))
            // 右边占比2
            right(modifier = Modifier.weight(2f/3f))

        }

    }
}


@Composable
@Preview
fun left(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        var text by remember { mutableStateOf("Hello, World!") }
        Button(onClick = {
            text = "Hello, Desktop!"
        },
        modifier = Modifier.height(50.dp).fillMaxWidth()) {
            Text(text)
        }
    }


}


@Composable
@Preview
fun right(modifier: Modifier = Modifier) {



    Column(modifier = modifier) {

        RightView()

//        var text by remember { mutableStateOf("Hello, World!") }
////        Button(onClick = {
////            text = "Hello, Desktop!"
////        }) {
////            Text(text)
////        }
//
//        Text(
//            modifier = Modifier.weight(10f).fillMaxWidth(),
//            text = text,
//            color = Color.White
//        )
//
//        Button(onClick = {
//            text = "Hello, Desktop!"
//        },
//            modifier = Modifier.weight(1f).fillMaxWidth()) {
//            Text(text)
//        }


    }

}








// ===================================================
fun getData() :List<WxMessageBean> {
    val wxMessages: List<WxMessageBean> = ArrayList()
    val result = wxMessages
        .asSequence()
        .plusElement(WxMessageBean("002", "G:\\xjp.jpg", "有美女照片没有?", "G:\\xjp.jpg", MessageType.MESSAGE))
        .plusElement(WxMessageBean("001", "G:\\xjp.jpg", "", "G:\\xjp.jpg", MessageType.IMAGE))
        .plusElement(WxMessageBean("001", "G:\\xjp.jpg", "漂亮不?还有...", "G:\\xjp.jpg", MessageType.MESSAGE))
        .plusElement(WxMessageBean("001", "G:\\xjp.jpg", "", "G:\\xjp.jpg", MessageType.IMAGE))
        .plusElement(WxMessageBean("002", "G:\\xjp.jpg", "有没有健身的妹纸呀?这些美女照片太多了没意思...要刚柔并进。你的明白吧?", "G:\\xjp.jpg", MessageType.MESSAGE))
        .plusElement(WxMessageBean("001", "G:\\xjp.jpg", "安心学技术多好,看啥美女对不?", "G:\\xjp.jpg", MessageType.MESSAGE))
        .plusElement(WxMessageBean("001", "G:\\xjp.jpg", "Compose最近看了一眼,也能跨平台呢?", "G:\\xjp.jpg", MessageType.MESSAGE))
        .plusElement(WxMessageBean("002", "G:\\xjp.jpg", "是的没错! 但是我觉得Flutter目前更胜一筹在Web端方面", "G:\\xjp.jpg", MessageType.MESSAGE))
        .toList()
    return result
}


/**
 * 分钟微信中间界面
 */
@Composable
fun centerView() {
    var inputValue by remember { mutableStateOf("搜索") }
    Box() {
        Column(
            modifier = Modifier
                .width(320.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState())
        ) {
//            列表内容
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(320.dp).background(Color.White).padding(8.dp)) {
            TextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent
                ),
                modifier = Modifier.padding(8.dp).background(
                    color = Color(247, 242, 243), shape = RoundedCornerShape(20),
                ).height(26.dp).width(250.dp),
                leadingIcon = {
                    Icon(
                        bitmap = getImageBitmap("images/sousuo.png"),
                        "",
                        modifier = Modifier.size(10.dp)
                    )
                },
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(26.dp).background(
                    color = Color(247, 242, 243),
                    shape = RoundedCornerShape(10)
                ).clip(shape = RoundedCornerShape(10))
            ) {
                ImageRes(
                    "images/jia.png",
                    modifier = Modifier.size(18.dp)
                )
            }
        }

    }
}

@Composable
fun ImageRes(s: String, modifier: Modifier) {
    TODO("Not yet implemented")
}


@Composable
fun RightView() {
    var inputText by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

//    var listItem by remember { mutableStateListOf(WxMessageBean()) }
    Column {
        Row(
            modifier = Modifier.height(55.dp).fillMaxWidth().background(Color(247, 242, 243, 100))
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("郭b蓝")
            Image(bitmap = getItemBitmapImg("G:\\xjp.jpg"), "")
        }
        Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color(222, 222, 222)))
        LazyColumn(Modifier.weight(1f).fillMaxWidth().background(Color(247, 242, 243, 100)), state = listState) {
            items(WxViewModel.wxMessages.size) { index ->
                val wxmessage = WxViewModel.wxMessages[index]
                if (wxmessage.userID == "001") {
                    Box {
                        Row(Modifier.padding(10.dp)) {
                            Image(
//                                bitmap = getImageBitmap(wxmessage.headPath),
                                bitmap = getItemBitmapImg(wxmessage.headPath),
                                "",
                                modifier = Modifier.size(45.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            if (wxmessage.messageType == MessageType.MESSAGE) {
                                Text(
                                    text = wxmessage.message,
                                    fontSize = 13.sp,
                                    modifier = Modifier.background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(20)
                                    ).clip(shape = RoundedCornerShape(20)).padding(10.dp)
                                )
                            } else {
                                Image(
                                    bitmap = getItemBitmapImg(wxmessage.messageImg),
                                    "",
                                    modifier = Modifier.size(80.dp)
                                )
                            }
                        }
                    }

                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(15.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Row {
                            if (wxmessage.messageType == MessageType.MESSAGE) {
                                Text(
                                    text = wxmessage.message,
                                    fontSize = 13.sp,
                                    modifier = Modifier.width(250.dp).background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(20)
                                    ).clip(shape = RoundedCornerShape(20)).padding(10.dp)
                                )
                            } else {
                                Image(
                                    bitmap = getItemBitmapImg(wxmessage.headPath),
                                    "",
                                    modifier = Modifier.size(80.dp)
                                )

                            }
                            Image(
                                bitmap = getItemBitmapImg(wxmessage.headPath),
                                "",
                                modifier = Modifier.padding(start= 10.dp).size(40.dp),
                                contentScale = ContentScale.FillBounds

                            )

                        }

                    }

                }

//                coroutineScope.launch {
//                    listState.animateScrollToItem(index)
//                }
            }
        }
        Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color(222, 222, 222)))

        Row(
            modifier = Modifier.background(Color(247, 242, 243, 100)).padding(start = 15.dp,end = 15.dp,top=15.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_01.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp),
                )
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_02.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp),
                )
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_03.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp),
                )
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_send.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp).clickable {
                        WxViewModel.wxMessages.add(WxMessageBean("002","G:\\xjp.jpg",inputText,"G:\\xjp.jpg",MessageType.MESSAGE))

//                        for (wxMessage in WxViewModel.wxMessages) {
//                            println("value:$wxMessage")
//                        }

//                        send=!send
//                        GlobalScope.launch{
////                            state.animateScrollTo(yPosition)
//                            scrollState.animateScrollToItem(5)
//                        }
                        coroutineScope.launch {
                            listState.animateScrollToItem(WxViewModel.wxMessages.size)
                        }

                    }
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_05.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Image(
                    bitmap = getItemBitmapImg("G://resources/images/messagetool/img_06.png"),
                    "",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }
        TextField(
            value = inputText, onValueChange = {
                inputText = it
            }, modifier = Modifier.height(226.dp).fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Gray,
                backgroundColor = Color(247, 242, 243, 100),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            )

        )
    }
}

fun getItemBitmapImg(headPath: String): ImageBitmap {

    val result : ImageBitmap?

    if (headPath.startsWith("C:", true) || headPath.startsWith("D:", true) || headPath.startsWith("G:", true)) {
        result = getImageBitmap(headPath)
    } else {
        result = useResource(headPath) { loadImageBitmap(it) }
    }

    return result
}


// 通过绝对路径获取图片
fun getImageBitmap(s: String): ImageBitmap {
    return Image.makeFromEncoded(File(s).readBytes()).toComposeImageBitmap()
}


// ========================================
@Preview
@Composable
fun ScrollingList() {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val listSize=100
    Column() {
        Row() {
            Button(modifier = Modifier.weight(1f), onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }
            Button(modifier = Modifier.weight(1f), onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }

    }

}


@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
//            painter = rememberAsyncImagePainter( "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-10-12%2F5f83b7c13d0b9.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657808691&t=3a05e7dad6f14402a7c14354e302f51b"),
            painter = painterResource("image.jpg"),
            modifier = Modifier.size(50.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)

    }
}

//=====================================3个label
@Composable
fun label3() {
    Column(Modifier.background(Color(0xFFEEEEEE))) {
        Row {
            Text("label 1", Modifier.size(100.dp, 100.dp).padding(10.dp).background(Color.White))
            Text("label 2", Modifier.size(150.dp, 200.dp).padding(5.dp).background(Color.White))
            Text("label 3", Modifier.size(200.dp, 300.dp).padding(25.dp).background(Color.White))
        }
    }
}








fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = 1000.dp, height = 800.dp)
    ) {
        App()


    }

}

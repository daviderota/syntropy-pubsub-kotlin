import io.nats.client.MessageHandler
import provider.NatsProvider
import java.nio.charset.StandardCharsets

suspend fun main() {
    val accessToken = "public_access"
    val natsUrl = "nats://url.com"
    val streamName = "my_test_stream"
    val nc = NatsProvider(accessToken, natsUrl, streamName)

    val connectionMessageHandler = MessageHandler { connectionMsg ->
        val connectionResponse = String(connectionMsg.data, StandardCharsets.UTF_8)
        println("Connection Message: $connectionResponse")
    }
    nc.connect(connectionMessageHandler)

    for (i in 0 until 1000) {
       nc.publish(i.toString())
        Thread.sleep(1000)
    }

}
/*
fun main() {
    runBlocking(Dispatchers.Default) {
        async { main() }.await()
    }
}*/
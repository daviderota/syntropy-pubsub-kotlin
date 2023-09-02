import io.nats.client.*
import provider.NatsProvider
import java.nio.charset.StandardCharsets

suspend fun main() {
    val accessToken = "access_token"
    val natsUrl = "nats://nats.url"
    val streamName = "syntropy.bitcoin.tx"
    val natsProvider = NatsProvider(accessToken, natsUrl, streamName)

    val connectionMessageHandler = MessageHandler { connectionMsg ->
        val connectionResponse = String(connectionMsg.data, StandardCharsets.UTF_8)
        println("Connection Message: $connectionResponse")
    }

    val subscribeMessageHandler = MessageHandler { subscribeMsg ->
        val response = String(subscribeMsg.data, StandardCharsets.UTF_8)
        println("Message received: $response")
    }

    natsProvider.connect(connectionMessageHandler)
    natsProvider.subscribe(subscribeMessageHandler)

}


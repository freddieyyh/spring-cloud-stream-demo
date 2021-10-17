package io.freddie.demo

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(private val streamBridge: StreamBridge) {
    @GetMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun sendMessage(message: String) {
        streamBridge.send("http-send-topic", message)
    }
}
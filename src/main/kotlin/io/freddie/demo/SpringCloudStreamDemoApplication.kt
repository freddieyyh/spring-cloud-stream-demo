package io.freddie.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.function.context.PollableBean
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.util.function.Consumer
import java.util.function.Supplier


@SpringBootApplication
class SpringCloudStreamDemoApplication {
    @PollableBean
    fun stringSupplier(): Supplier<Flux<String>> {
        return Supplier { Flux.just("hello", "bye") }
    }

    @Bean
    fun print() = Consumer<String> { message ->
        println("Consume done $message")
    }

}

fun main(args: Array<String>) {
    runApplication<SpringCloudStreamDemoApplication>(*args)
}

package sandbox.client;

import java.util.List;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import sandbox.Message;

@Controller
public class ClientController {
    private final MessageClient messageClient;
    private final Counter counter;

    public ClientController(MessageClient messageClient, MeterRegistry meterRegistry) {
        this.messageClient = messageClient;
        counter = meterRegistry.counter("request_sendMessage");
    }

    @Get("/sendMessage")
    public List<Message> sendMessage() {
        counter.increment();
        return List.of(messageClient.getMessage("text"),
                       messageClient.getMessageSingle("textSingle")
                                    .blockingGet());
    }
}

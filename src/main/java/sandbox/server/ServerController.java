package sandbox.server;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import sandbox.Message;

@Controller
public class ServerController {
    @Get("/getMessage")
    public Message getMessage(String text) {
        return new Message("key", text);
    }
}

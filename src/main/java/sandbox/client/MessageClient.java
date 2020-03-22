package sandbox.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import sandbox.Message;

@Client("${message.server}")
public interface MessageClient {
    @Get("/getMessage")
    Message getMessage(@QueryValue("text") String text);

    @Get("/getMessage")
    Single<Message> getMessageSingle(@QueryValue("text") String text);
}

package io.github.tintinrevient.messageservice.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash("Message")
public class Message implements Serializable {

    private int id;
    private String message;
    private String timestamp;
}

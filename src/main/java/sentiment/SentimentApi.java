package sentiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import sentiment.storage.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SentimentApi {

	public static void main(String[] args) {
		SpringApplication.run(SentimentApi.class, args);
	}
}

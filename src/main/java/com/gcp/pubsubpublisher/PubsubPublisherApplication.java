package com.gcp.pubsubpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class PubsubPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsubPublisherApplication.class, args);
	}

	@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
	   public interface PubsubOutboundGateway {
	      void sendToPubsub(String text);
	   }
	  
	 
	 @Bean
	  @ServiceActivator(inputChannel = "pubsubOutputChannel")
	  public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
	  return new PubSubMessageHandler(pubsubTemplate, "topic-28thJune2020");
	  }
	
}

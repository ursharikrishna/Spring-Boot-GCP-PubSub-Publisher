package com.gcp.pubsubpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcp.pubsubpublisher.PubsubPublisherApplication.PubsubOutboundGateway;

@RestController
public class PublishMessageController {
	
	 @Autowired
	  private PubsubOutboundGateway messagingGateway;	

	  @PostMapping("/publishMessage")
	  public String publishMessage(@RequestParam("message") String message) {
	  messagingGateway.sendToPubsub(message);
	  return "Success!!!";
	  }

}

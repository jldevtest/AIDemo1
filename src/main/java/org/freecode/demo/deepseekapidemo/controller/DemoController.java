package org.freecode.demo.deepseekapidemo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // private final DeepSeekChatModel chatModel;

    // @Autowired
	// public DemoController(DeepSeekChatModel chatModel) {
	// 	this.chatModel = chatModel;
	// }

	// @GetMapping("/chat")
	// public String askSomething(@RequestParam("prompt") String promptString) {
	// 	var prompt = new Prompt(promptString);
    //     var response = chatModel.call(prompt);
	// 	return response.getResult().getOutput().getText();
	// }

	// private final ChatClient chatClient;
	private final ChatClient.Builder builder;

	@Autowired
	public DemoController(ChatClient.Builder builder) {
		this.builder = builder;
	}

	@GetMapping("/chat")
	public String askSomething(@RequestParam(value="prompt", defaultValue = "Tell me a joke" ) String promptString) {
		// return chatClient.prompt().user(promptString).call().content();
		// String responseString = chatClient.prompt(promptString).call().content();
		// if (responseString == null) {
		// 	return "No response from model";
		// }
		// return responseString;
		ChatClient chatClient = builder.build();
		String responseString = chatClient.prompt().user(promptString).call().content();
		return responseString;
	}
}

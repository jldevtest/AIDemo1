package org.freecode.demo.deepseekapidemo.controller;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DeepSeekChatModel chatModel;

    @Autowired
	public DemoController(DeepSeekChatModel chatModel) {
		this.chatModel = chatModel;
	}

	@GetMapping("/chat")
	public String askSomething(@RequestParam("prompt") String promptString) {
		var prompt = new Prompt(promptString);
        var response = chatModel.call(prompt);
		return response.getResult().getOutput().getText();
	}
}

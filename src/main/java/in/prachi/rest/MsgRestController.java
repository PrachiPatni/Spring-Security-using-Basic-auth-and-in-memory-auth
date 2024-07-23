package in.prachi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/contact")
	public String getMsg() {
		return "welcome to Spring Security";
	}

	@GetMapping("/greet")
	public String getGreetMsg() {
		return "greetings!!!!";
	}

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return "welcome, good morning";
	}
}

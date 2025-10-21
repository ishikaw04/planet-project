package com.example.planet.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {
	
	private final UsersService usersService;
	
	// ログイン画面表示
	@GetMapping("/login")
	public String showLoginForm() {
		return "user/login";
	}
	
	// ログイン処理
	@PostMapping("/login")
	public String login(@RequestParam String username,
							  @RequestParam String password,
							  Model model) {
		
		return usersService.authenticate(username, password)
				.map(user -> {
					model.addAttribute("user", user);
					return "redirect:/user/home"; // ログイン成功後のホーム
				})
				.orElseget(() -> {
					model.addAttribute("error", "ユーザー名またはパスワードに誤りがあります");
					return "user/login";
				});
	}
	
	// 新規登録画面
	@GetMapping("/register")
	public String showRegisterForm() {
		return "user/register";
	}
	
	// 新規登録処理
	@PostMapping("/register")
	public String register(@RequestParam String username,
								  @RequestParam String password,
								  Model mdel) {
		try {
		Users user = usersService.registerUser(usename, password)
		model.addAttribute("user", user);
		return "redirect:/user/login"; // 登録後はログイン画面へ
		} catch (IllegalArgumentException e) {
		model.addAttribute("error", e.getMessage());
		return "user/register";
		}
	}
	
	// ログイン後のホーム画面
	@GetMapping("/home")
	public String home() {
		return "user/home";
	}
}

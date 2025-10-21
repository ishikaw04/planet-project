package com.example.planet.service.user;


import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.planet.entity.Users;
import com.example.planet.repository.user.UsersRepository;

import lombok.RequiredArgsConstructor;
/*
 * ユーザー関連のビジネスロジック
 * - 新規登録
 * - ログイン認証
 * - ユーザー情報取得
 */

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;
	private final PasswordEncoder passwordEncoder;
	
	/*
	 * 新規ユーザー登録
	 * @Param username ユーザー名
	 * @Param rewPassword パスワード(平文)
	 * @return 登録済ユーザー情報
	 * @throws IllegalArgumentException ユーザー名重複時
	 */
	public Users registerUser(String username, String rawPassword) {
		// 重複チェック
		if (usersRepository.existsByUsername(username)) {
			throw new IllegalArgumentException("このユーザー名は既に使用されています。");
		}
		// パスワードをハッシュ化して保存
		String encodePassword = passwordEncoder.encode(rawPassword);
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(encodePassword);
		
		return usersRepository.save(user);
	}
	/*
	 * ログイン認証
	 * @Param username ユーザー名
	 * @Param rawaPassword パスワード(平文)
	 * @return 認証成功時: Optional<Users>, 失敗時: Optional.empty()
	 */
	public Optional<Users> authenticate(String username, String rewPassword){
		return usersRepository.findByUsername(username)
				.filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()));
	}
	/*
	 * ユーザーIDで情報取得
	 * @Param userId ユーザーID
	 * @return Optional<Users>
	 * 
	 */
	public Optional<Users> findById(Integer userId){
		return usersRepository.findById(userId);
	}
}

package com.example.planet.repository.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.planet.entity.Users;



public interface UsersRepository extends JpaRepository<Users, Integer> {
	// ログイン照合(ユーザー名・パスワード)
	Optional<Users> findByUsernameAndPassword(String username, String password);
	
	// ユーザー名重複チェック(新規登録時)
	boolean exexistsByUsername(String username);
	
	// ユーザー名検索(ログイン・認証用)
	Optional<Users> findByUsername(String username);
}

package com.thehecklers.ch3test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@SpringBootApplication
public class Ch3testApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ch3testApplication.class, args);
	}

}

@RestController
@RequestMapping("/members")
class RestApiController {
	private List<Member1> members = new ArrayList<>();

	public RestApiController() {
		members.addAll(List.of(
				new Member1("userid", "username", 25, "123-123-123", "abc@abc.com", "2024-12-19"),
				new Member1("userid", "username", 25, "123-123-123", "abc@abc.com", "2024-12-19")
		));
	}

	@RequestMapping(value = "/members", method = GET)
	public List<Member1> getMembers() {
		return members;
	}

	@GetMapping
	Iterable<Member1> GetMembers() {
		return members;
	}

	@GetMapping("/userid")
	Optional<Member1> GetUserId(@PathVariable String userid) {
		for (Member1 m : members) {
			if (m.getUserid().equals(userid)) {
				return Optional.of(m);
			}
		}
		return Optional.empty();
	}
	@PostMapping("/new")
	Member1 createMember(@RequestBody Member1 m) {
		members.add(m);
		return m;
	}
	@PutMapping
	ResponseEntity<Member1> updateMember(@PathVariable String userid, @RequestBody Member1 members) {
		int membersIndex = -1;
		for (Member m : members) {
			if(m.getuserid().equals(userid)){
				numbersIndex=numbers.Indexof(m);

			}



	}


}




class Member1 {
	private String userid;
	private String username;
	private Integer age;
	private String phone;
	private String email;
	private String createdata;

	public Member1(String userid, String username, Integer age, String phone, String email, String createdata) {
		this.userid = userid;
		this.username = username;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.createdata = createdata;

	}
	public String getUserid() {
		return userid;

	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedata() {
		return createdata;
	}
	public void setCreatedata(String createdata) {
		this.createdata = createdata;
	}

}
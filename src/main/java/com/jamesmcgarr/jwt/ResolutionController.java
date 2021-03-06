package com.jamesmcgarr.jwt;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ResolutionController {
	private final ResolutionRepository resolutions;

	public ResolutionController(ResolutionRepository resolutions) {
		this.resolutions = resolutions;
	}

	@GetMapping("/resolutions")
	public List<Resolution> read(@AuthenticationPrincipal Jwt jwt) {
//		UUID owner = UUID.fromString(jwt.getClaim("user_id"));
		UUID owner = UUID.fromString("328167d1-2da3-5f7a-86d7-96b4376af2c0");
		System.out.println("-- " + jwt.getClaim("tid"));
		System.out.println("-- " + jwt.getClaim("oid"));
		System.out.println("-- " + jwt.getClaim("aud"));
		System.out.println("-- " + jwt.getClaim("azp"));
		System.out.println("-- " + jwt.getClaim("name"));
		System.out.println("-- " + jwt.getClaim("email"));
		System.out.println(jwt.getClaims());
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		System.out.println("***********************************************************" + owner);
		return this.resolutions.findByOwner(owner);
	}

	@GetMapping("/resolution/{id}")
	public Optional<Resolution> read(@PathVariable("id") UUID id) {
		return this.resolutions.findById(id);
	}

	@PostMapping("/resolution")
	public Resolution make(@RequestBody String text, @AuthenticationPrincipal Jwt jwt) {
		UUID owner = UUID.fromString(jwt.getClaim("user_id"));
		Resolution resolution = new Resolution(text, owner);
		return this.resolutions.save(resolution);
	}

	@PutMapping(path="/resolution/{id}/revise")
	@Transactional
	public Optional<Resolution> revise(@PathVariable("id") UUID id, @RequestBody String text) {
		this.resolutions.revise(id, text);
		return read(id);
	}

	@PutMapping("/resolution/{id}/complete")
	@Transactional
	public Optional<Resolution> complete(@PathVariable("id") UUID id) {
		this.resolutions.complete(id);
		return read(id);
	}
}
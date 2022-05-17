package dia29.apiproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dia29.apiproduct.model.User;
import dia29.apiproduct.service.IUserService;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private IUserService userS;

    @GetMapping
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok().body(userS.getAll());
	}

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User u){
        if(userS.save(u))
			return ResponseEntity.ok().body("User created");
		else 
			return ResponseEntity.badRequest().body("Bad Request pa");
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		if(userS.delete(id)) 
			return ResponseEntity.ok().body("User deleted");
		else 
			return ResponseEntity.badRequest().body("Bad Request");
	}

    @PutMapping
	public ResponseEntity<?> update(@RequestBody User u){
		if(userS.update(u)) {
			return ResponseEntity.ok().body("Product updated");
		} else 
			return ResponseEntity.badRequest().body("Bad Request");
	}
}

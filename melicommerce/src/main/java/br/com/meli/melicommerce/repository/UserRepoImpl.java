package br.com.meli.melicommerce.repository;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.melicommerce.model.User;

@Repository
public class UserRepoImpl implements IUserRepo{

	private List<User> userList;
	
	
	
	public UserRepoImpl() {
		loadDatabase();
	}



	public void loadDatabase() {
		// TODO Auto-generated method stub
		try{
			File file;
			ObjectMapper mapper = new ObjectMapper();
			List<User> users;
			
			file = ResourceUtils.getFile("classpath:users.json");
			users = mapper.readValue(file, new TypeReference<List<User>>(){});
			this.userList = users;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}



	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userList;
	}



	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return this.userList.stream()
				.filter(t -> t.getUserId().equals(id) ).findFirst().orElse(null);
	}

}

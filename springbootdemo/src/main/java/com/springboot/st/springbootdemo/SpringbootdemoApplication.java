package com.springboot.st.springbootdemo;

import com.springboot.st.springbootdemo.Dao.AllOperation;
import com.springboot.st.springbootdemo.Dao.LoginRepository;
import com.springboot.st.springbootdemo.Dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	private final AllOperation allOperation;

	@Autowired
	public SpringbootdemoApplication(AllOperation allOperation) {
		this.allOperation = allOperation;
	}

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(SpringbootdemoApplication.class);
		ApplicationContext context =  SpringApplication.run(SpringbootdemoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		LoginRepository loginRepository = context.getBean(LoginRepository.class);
		SpringbootdemoApplication application = context.getBean(SpringbootdemoApplication.class);
		//data insert
//		application.allOperation.insert_Login("aa02","Lavisha6880","Lavish1234");
//		application.allOperation.insert_users("aa02","Lavish Saini","Borkeda","Kota");
//		application.allOperation.insert_Login("aa03","Himanshu6880","Hima1234");
//		application.allOperation.insert_users("aa03","Himanshu Saini","Borkeda","Kota");
//		application.allOperation.insert_Login("aa04","isha6880","isha1234");
//		application.allOperation.insert_users("aa04","isha Saini","Borkeda","Kota");
//		application.allOperation.insert_Login("aa05","manisha6880","manisha6880");
//		application.allOperation.insert_users("aa05","manisha Saini","Borkeda","Kota");

		//data select
		application.allOperation.findById("aa01");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findAll();
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByName("Tanu Saini");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByUsernameAndPassword("Tanu6880","Tanu1234");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByNameStartingWith("L");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByNameContaining("Saini");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByNameLike("%a%");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByIdLessThan("aa03");
		logger.info("-------------------------------------------------------------");
		//application.allOperation.findByIdGraterThanEqual("aa03");
		logger.info("-------------------------------------------------------------");
		//application.allOperation.findByIdIn("aa02");
		logger.info("-------------------------------------------------------------");
		application.allOperation.findByNameOrderByName("Tanu Saini");
		logger.info("-------------------------------------------------------------");
		application.allOperation.getAll("Tanu Saini");
		logger.info("-------------------------------------------------------------");
		application.allOperation.Alldata();
//		List<Users> list = List.of(user1,user2);
//		Iterable<Users> u1 = userRepository.saveAll(list);
//		u1.forEach(users -> System.out.println(users.toString()));

		//update data
//		Optional<Users> itr = userRepository.findById(1);
//		Users user = itr.get();
//		System.out.println(user.toString());
//		user.setName("manisha saini");
//		Users u = userRepository.save(user);
//		System.out.println(u);
//
//		//selectData
//		Iterable<Users> allById = userRepository.findAllById(Collections.singleton(1));
//		Iterable<Users> ittr = userRepository.findAll();
//		ittr.forEach(users -> System.out.println(users));
//
//		//delete
//		userRepository.deleteById(0);
//		Iterable<Users> usersIterable = userRepository.findAll();
//		userRepository.deleteAll(usersIterable);
//
	}


}

package com.hoyatod.jpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hoyatod.jpa.orm.UserInformation;


/** 
 *  @author  作者 : xul
 *  @date 创建时间：2018年3月21日 上午10:56:50 
 *  @version 1.0 
 */
public interface UserInformationRepository extends CrudRepository<UserInformation, Integer>{
	
	
//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query(nativeQuery=true,value="insert into user_information (username,phone,email,wechat,hobby,investmentpreference,view) values(?1,?2,?3,?4,?5,?6)")
//	public Integer addUser(String username,String phone,String email,String wechat,String hobby,String investmentpreference,Boolean view);
}

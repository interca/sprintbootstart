package com.it;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.dto.AccountDto;
import com.it.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	private AccountMapper accountMapper;

	@Test
	void contextLoads() {
		List<AccountDto> account = accountMapper.selectList(null);
		for(AccountDto k:account){
			System.out.println(k);
		}
	}

	@Test
	void save(){
		AccountDto accountDto=new AccountDto();
		accountDto.setName("sb");
		accountDto.setMoney(12);
		accountMapper.insert(accountDto);
	}

	@Test
	void delete(){
		accountMapper.deleteById(2);
	}

	@Test
	void update(){
		AccountDto accountDto=new AccountDto();
		accountDto.setUid(12);
		accountDto.setName("sb12");
		accountDto.setMoney(12);
		accountMapper.updateById(accountDto);
	}

	@Test
	void page(){
		IPage page=new Page(1,5);
		accountMapper.selectPage(page,null);
		System.out.println(page.getCurrent());
		System.out.println(page.getRecords());
	}

	@Test
	void  test2(){
		//按条件查询
		QueryWrapper wrapper=new QueryWrapper();
		//id小于十的用户
		wrapper.lt("id",10);
		List<AccountDto> accountDtos = accountMapper.selectList( wrapper);
		for(AccountDto k:accountDtos){
			System.out.println(k);
		}
	}

	@Test
	void  test3(){
		//按条件查询
		QueryWrapper wrapper=new QueryWrapper();
		//多条件查询
		wrapper.lt("id",14);
		wrapper.gt("id",10);
		List<AccountDto> accountDtos = accountMapper.selectList( wrapper);
		for(AccountDto k:accountDtos){
			System.out.println(k);
		}
	}

	@Test
	void  test4(){
		//按条件查询
		LambdaQueryWrapper<AccountDto> wrapper=new LambdaQueryWrapper<>();
		//多条件查询或者关系
		wrapper.lt(AccountDto::getUid,10).or().gt(AccountDto::getUid,14);
		List<AccountDto> accountDtos = accountMapper.selectList( wrapper);
		for(AccountDto k:accountDtos){
			System.out.println(k);
		}
	}

	@Test
	void  test5(){
		//按条件查询
		LambdaQueryWrapper<AccountDto> wrapper=new LambdaQueryWrapper<>();
		//等匹配
		wrapper.eq(AccountDto::getName,"牛牛");
		List<AccountDto> accountDtos = accountMapper.selectList( wrapper);
		for(AccountDto k:accountDtos){
			System.out.println(k);
		}
	}
}

package com.it;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.dto.AccountDto;
import com.it.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		accountDto.setId(12);
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

}

package com.qa.services;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.persistence.domain.TDLDomain;

import com.qa.persistence.dtos.TDLDTO;
import com.qa.persistence.repos.TDLRepo;

@SpringBootTest
public class TDLServiceTest {
	
	@MockBean
	private ModelMapper mockedMapper;
	
	@MockBean
	private TDLRepo mockedRepo;
	
	@Autowired
	private TDLService service;
	
	@Test
	public void create() {
		
		TDLDomain testToDo = new TDLDomain(1L, "Testing", null);
		TDLDTO testDTO = new TDLDTO(1L, "Testing", null);
		
		Mockito.when(this.mockedRepo.save(Mockito.any(TDLDomain.class))).thenReturn(testToDo);
		Mockito.when(this.mockedMapper.map(testToDo, TDLDTO.class)).thenReturn(testDTO);
		
		TDLDTO result = this.service.create(testToDo);
		
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(testDTO);
		Assertions.assertThat(result).usingRecursiveComparison()
				.isEqualTo(testDTO);
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TDLDomain.class));
		Mockito.verify(this.mockedMapper, Mockito.times(1)).map(testToDo, TDLDTO.class);
	}
	
	@Test
	public void delete() {
		Long id = 1l;
		
		Mockito.when(this.mockedRepo.existsById(id)).thenReturn(false);
		
		Assertions.assertThat(this.service.deleteToDo(1l)).isTrue();
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).existsById(id);
	}
	
	@Test
	public void readById() {
		TDLDomain testToDo = new TDLDomain(1L, "Testing", null);
		TDLDTO testDTO = this.mockedMapper.map(testToDo, TDLDTO.class);
		
		Mockito.when(this.mockedRepo.findById(testToDo.getId())).thenReturn(Optional.of(testToDo));
		TDLDTO result = this.service.readById(1L);
		
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(testDTO);
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		}
	
	@Test
	public void readAll() {
		Long id = 1L;
		TDLDomain testToDo = new TDLDomain(1L, "Testing", null);
		
		testToDo.setId(id);
		
		List<TDLDomain>todos = this.mockedRepo.findAll();
		TDLDTO resultList = this.mockedMapper.map(todos, TDLDTO.class);
		
		Mockito.when(this.mockedRepo.findAll()).thenReturn(todos);
		Mockito.when(this.mockedMapper.map(todos, TDLDTO.class)).thenReturn(resultList);
		
		Assertions.assertThat(todos).isNotNull();
		Assertions.assertThat(this.service.readAll()).isEqualTo(todos);
		
		Mockito.verify(this.mockedRepo, Mockito.times(2)).findAll();
	}
	
	@Test
	public void update() {
		TDLDomain testToDo = new TDLDomain(1L, "Testing", null);
		TDLDomain newToDo = new TDLDomain(1L, "Testing", null);
		TDLDTO testDTO = new TDLDTO(1L, newToDo.getName(), null);
		
		Mockito.when(this.mockedRepo.findById(1L)).thenReturn(Optional.of(testToDo));
		Mockito.when(this.mockedRepo.save(newToDo)).thenReturn(newToDo);
		Mockito.when(this.mockedMapper.map(newToDo, TDLDTO.class)).thenReturn(testDTO);
		
		TDLDTO result = this.service.updateToDo(1L, newToDo);
		
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(testDTO);
	}
	
	

}

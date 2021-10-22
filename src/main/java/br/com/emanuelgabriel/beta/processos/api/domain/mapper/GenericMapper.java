package br.com.emanuelgabriel.beta.processos.api.domain.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author emanuel.sousa
 * @since 22/10/2021
 *
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GenericMapper implements IGenericMapper {

	private final ModelMapper modelMapper;

	@Override
	public <T> T paraObjeto(Object obj, Class<T> clazz) {
		if (Objects.isNull(obj))
			return null;
		return modelMapper.map(obj, clazz);
	}

	@Override
	public <T> T dtoParaEntidade(Object dto, Class<T> clazz) {
		if (Objects.isNull(dto))
			return null;
		return modelMapper.map(dto, clazz);
	}

	@Override
	public <T> List<T> paraLista(List<?> list, Class<T> clazz) {
		if (Objects.isNull(list) || list.isEmpty())
			return Collections.emptyList();
		return list.stream().map(obj -> paraObjeto(obj, clazz)).collect(Collectors.toList());
	}

	@Override
	public <T> Page<T> paraPage(Pageable pageable, Page<T> pageClass) {
		if (Objects.isNull(pageable))
			return null;
		return null;
	}

}

package br.com.emanuelgabriel.beta.processos.api.domain.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author emanuel.sousa {@summary interface genérica do mapper}
 *
 */
public interface IGenericMapper {

	/**
	 * Responsável em converter um objeto para outro tipo
	 * 
	 * @author emanuel.sousa
	 * @param <T>
	 * @param obj
	 * @param clazz
	 * @return <T>
	 */
	<T> T paraObjeto(Object obj, Class<T> clazz);

	/**
	 * @author emanuel.sousa
	 * @param <T>
	 * @param dto
	 * @param clazz
	 * @return <T>
	 */
	<T> T dtoParaEntidade(Object dto, Class<T> clazz);

	/**
	 * Responsável em converter uma lista de objeto
	 * 
	 * @author emanuel.sousa
	 * @param <T>
	 * @param list
	 * @param clazz
	 * @return <T>
	 */
	<T> List<T> paraLista(List<?> list, Class<T> clazz);

	<T> Page<T> paraPage(Pageable pageable, Page<T> pageClass);

}

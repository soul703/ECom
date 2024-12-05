package org.example.sangecom.service;


import org.example.sangecom.dto.request.CategoryDto;
import org.example.sangecom.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

	public Category saveCategory(CategoryDto category);

	public Boolean existCategory(String name);

	public List<Category> getAllCategory();

	public Boolean deleteCategory(int id);

	public Category getCategoryById(int id);

	public List<Category> getAllActiveCategory();

	public Page<Category> getAllCategorPagination(Integer pageNo,Integer pageSize);

}

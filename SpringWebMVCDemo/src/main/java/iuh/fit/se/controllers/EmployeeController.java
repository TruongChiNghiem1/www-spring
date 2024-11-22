package iuh.fit.se.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public ModelAndView getList(ModelAndView model) {
		List<Employee> employees = employeeService.findAll();
		model.setViewName("employee-list");
		model.addObject("employees", employees);
		return model;
	}
	
	@GetMapping("/page/{pageNo}")
	public String getList(Model model, 
			@PathVariable int pageNo,
		    @RequestParam(defaultValue = "2", required = false) int pageSize,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "ASC", required = false) String sortDirection) {
		Page<Employee> employees = employeeService.findAllWithPaging(pageNo - 1, pageSize, sortBy, sortDirection);
		System.out.println(employees);
		
		model.addAttribute("currentPage", pageNo);
        
		model.addAttribute("totalPages", employees.getTotalPages());
        model.addAttribute("totalItems", employees.getTotalElements());

        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDirection", sortDirection);
        
		model.addAttribute("employees", employees.getContent());
		
		return "employee-list";
	}
	

//	@RequestMapping(value = "/showForm", method = RequestMethod.GET)
	@GetMapping("/showForm")
	public ModelAndView showForm(ModelAndView model) {
		Employee employee = new Employee();
		model.setViewName("employee-form");
		model.addObject("employee", employee);
		return model;
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "employee-form";
		}
		
		if(employee.getAddress().getAddress().isEmpty()) {
			employee.setAddress(null);
		}
		
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("employeeId") int id, ModelAndView model) {
		Employee employee = employeeService.findById(id);
	
		if (employee == null) {
			model.addObject("message", "Can not find Employee with id: " + id);
			model.setViewName("error");
		}
		else {
			model.addObject("employee", employee);
			model.setViewName("employee-form");
		}
		
		return model;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam String keyword, ModelAndView model) {
		List<Employee> employees = employeeService.search(keyword);
	    model.setViewName("employee-list");
		model.addObject("employees", employees);
	 
	    return model;    
	}
}

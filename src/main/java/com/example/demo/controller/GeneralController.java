package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.AdminLogin;
import com.example.demo.model.DepartmentsList;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeLogin;
import com.example.demo.model.HybridSchedInfo;
import com.example.demo.model.PTOinfo;
import com.example.demo.model.ShiftsList;
import com.example.demo.model.TeamLead;
import com.example.demo.model.TeamLeadLogin;
import com.example.demo.model.TeamsList;
import com.example.demo.model.Total;
import com.example.demo.model.WorkType;
import com.example.demo.repository.DepartmentsRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.HybridSchedRepo;
import com.example.demo.repository.LoginRepoAdmin;
import com.example.demo.repository.LoginRepoEmployee;
import com.example.demo.repository.LoginRepoTeamLead;
import com.example.demo.repository.PTOrepo;
import com.example.demo.repository.ShiftsRepo;
import com.example.demo.repository.TeamLeadRepo;
import com.example.demo.repository.TeamListRepo;
import com.example.demo.repository.WorkTypeRepo;
import com.example.demo.service.LoginServiceAdmin;
import com.example.demo.service.LoginServiceEmployee;
import com.example.demo.service.LoginServiceTeamLead;






@Controller
public class GeneralController {

	@Autowired
	TeamLeadRepo teamLeadRepo;
	@Autowired
	DepartmentsRepo depRepo;
	@Autowired
	TeamListRepo teamListRepo;
	
	@Autowired
	LoginServiceAdmin adminLoginService;
	
	@Autowired
	LoginServiceEmployee employeeLoginService;
	
	@Autowired
	LoginServiceTeamLead leadLoginService;
	
	@Autowired
	LoginRepoAdmin loginAdminRepo;
	
	@Autowired
	LoginRepoTeamLead loginLeadRepo;
	
	@Autowired
	LoginRepoEmployee loginEmployeeRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ShiftsRepo shiftsRepo;
	
	@Autowired
	HybridSchedRepo schedRepo;
	
	@Autowired
	WorkTypeRepo workRepo;
	
	@Autowired
	PTOrepo ptoRepo;
	
	@GetMapping("/")
	public String viewHomePage()
	{
		return "index";
	}
	
	@GetMapping("/loginAdmin")
	public String viewLoginPage()
	{
		return "loginPageAdmin";
	}
	
	@GetMapping("/loginLead")
	public String viewLeadLoginPage()
	{
		return "loginPageLead";
	}
	
	@GetMapping("/loginEmployee")
	public String viewEmployeeLoginPage()
	{
		return "loginPageEmployee";
	}
	
	@GetMapping("/masterPage")
	public String viewMasterPage(Model model)
	{	
		List<DepartmentsList> departmentsList = depRepo.findAll();
		model.addAttribute("departmentsList",departmentsList);
		
		List<TeamsList> teamsList = teamListRepo.findAll();
		model.addAttribute("teamsList",teamsList);
		
		
		List<TeamLead> listTeamLead = teamLeadRepo.findAll();
		model.addAttribute("listTeamLead",listTeamLead);
		
		List<Employee> listEmployee = employeeRepo.findAll();
		model.addAttribute("listEmployee",listEmployee);
		
		return "masterPage";
	}
	
	
	
	
	@GetMapping("/teamLead")
	public String listTeamLead(Model model)
	{
		List<TeamLead> listTeamLead = teamLeadRepo.findAll();
		model.addAttribute("listTeamLead",listTeamLead);
		
		
		
		return "team-leads";
	}
	
	@GetMapping("/employee")
	public String listEmployee(Model model)
	{
		List<Employee> listEmployee = employeeRepo.findAll();
		model.addAttribute("listEmployee",listEmployee);
		
		model.addAttribute("total", new Total());
		
		return "employeePage";
	}
	
	
	  @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
	    {
	    
	  
	        return "redirect:/";
	    }
	  
	  @PostMapping("/adminLogin")
	    public String login(@ModelAttribute("user") AdminLogin user ) {
	    
	     AdminLogin oauthUser = adminLoginService.login(user.getEmail(), user.getPassword());
	    
	 
	     System.out.print(oauthUser);
	     if(Objects.nonNull(oauthUser))
	     {
	  
	     return "redirect:/masterPage";
	    
	    
	     } else {
	     return "redirect:/loginAdmin";
	    
	    
	     }
	  }
	  
	  @PostMapping("/employeeLogin")
	    public String loginEmployee(@ModelAttribute("user") EmployeeLogin user ) {
	    
	     EmployeeLogin oauthUser = employeeLoginService.login(user.getEmail(), user.getPassword());
	    
	 
	     System.out.print(oauthUser);
	     if(Objects.nonNull(oauthUser))
	     {
	  
	     return "redirect:/employee";
	    
	    
	     } else {
	     return "redirect:/loginEmployee";
	    
	    
	     }
	  }
		
	  
	  @PostMapping("/teamLeadLogin")
	    public String loginTeamLead(@ModelAttribute("user") TeamLeadLogin user ) {
	    
	     TeamLeadLogin oauthUser = leadLoginService.login(user.getEmail(), user.getPassword());
	    
	 
	     System.out.print(oauthUser);
	     if(Objects.nonNull(oauthUser))
	     {
	  
	     return "redirect:/teamLead";
	    
	    
	     } else {
	     return "redirect:/loginLead";
	    
	    
	     }
	  }
	
	  
	  @GetMapping("/showNewAddForm")
		public String showNewAddForm(Model model) {
			// create model attribute to bind form data
//			Login newUser = new Login();
//			model.addAttribute("newUser", newUser);
			return "addPage";
		}
	  
	  @GetMapping("/showNewAddUsersForm")
			public String showNewAddUsersForm(Model model) {
				// create model attribute to bind form data
//				Login newUser = new Login();
//				model.addAttribute("newUser", newUser);
				return "addUsersPage";
			}
	  
	  @GetMapping("/showNewAddAdminForm")
		public String showNewAddAdminForm(Model model) {
			// create model attribute to bind form data
		  AdminLogin  newAdmin = new AdminLogin ();
			model.addAttribute("newAdmin", newAdmin);
			return "newAdminForm";
		}
	  
	  @GetMapping("/showNewAddLeadForm")
		public String showNewAddLeadForm(Model model) {
			// create model attribute to bind form data
		  TeamLeadLogin  newTeamLead = new TeamLeadLogin ();
			model.addAttribute("newTeamLead", newTeamLead);
			return "newTeamLeadForm";
		}
	  
	  @GetMapping("/showNewAddEmployeeForm")
			public String showNewAddEmployeeForm(Model model) {
				// create model attribute to bind form data
			  Employee  newEmployee = new Employee ();
				model.addAttribute("newEmployee", newEmployee);
				return "newEmployeeForm";
			}
	  
	  
	  @PostMapping("/saveNewAdmin")
		public String saveNewAdmin(@ModelAttribute("newAdmin") AdminLogin newAdmin) {
			// save employee to database
			loginAdminRepo.save(newAdmin);
			return "redirect:/showNewAddAdminForm";
		}
	  
	  @PostMapping("/saveNewTeamLead")
		public String saveNewTeamLead(@ModelAttribute("newTeamLead") TeamLeadLogin newTeamLead) {
			// save employee to database
			loginLeadRepo.save(newTeamLead);
			return "redirect:/showNewAddLeadForm";
		}
	  
	  @PostMapping("/saveNewEmployee")
			public String saveNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
				// save employee to database
				employeeRepo.save(newEmployee);
				return "redirect:/showNewAddEmployeeForm";
			}
	  
	  
	  
	  @GetMapping("/showNewUpdateForm")
			public String showNewUpdateForm(Model model) {
				// create model attribute to bind form data
//				Login newUser = new Login();
//				model.addAttribute("newUser", newUser);
				return "updatePage";
			}
	  
	  @GetMapping("/showNewUpdatePage")
		public String showNewUpdatePage(Model model) {
			// create model attribute to bind form data
//			Login newUser = new Login();
//			model.addAttribute("newUser", newUser);
			return "updateNewPage";
		}
	  
	  
	  @GetMapping("/adminsList")
		public String showListOfAdmin(Model model) {
			
			List<AdminLogin> adminList = loginAdminRepo.findAll();
			model.addAttribute("adminList",adminList);
			return "adminsList";
		}
	  
	  @GetMapping("/teamLeadList")
		public String showListOfTeamLead(Model model) {
			
			List<TeamLeadLogin> teamLeadList = loginLeadRepo.findAll();
			model.addAttribute("teamLeadList",teamLeadList);
			return "teamLeadList";
		}
	  
	  @GetMapping("/employeeList")
			public String showListOfEmployee(Model model) {
				
				List<Employee> employeeList = employeeRepo.findAll();
				model.addAttribute("employeeList",employeeList);
				return "employeeList";
			}
	  
	  
	  
	  @GetMapping("/adminsListDelete")
		public String showListOfAdminDelete(Model model) {
			
			List<AdminLogin> adminList = loginAdminRepo.findAll();
			model.addAttribute("adminList",adminList);
			return "adminsListDelete";
		}
	  
	  @GetMapping("/teamLeadListDelete")
		public String showListOfTeamLeadDelete(Model model) {
			
			List<TeamLeadLogin> teamLeadList = loginLeadRepo.findAll();
			model.addAttribute("teamLeadList",teamLeadList);
			return "teamLeadListDelete";
		}
	  
	  @GetMapping("/employeeListDelete")
			public String showListOfEmployeeDelete(Model model) {
				
				List<Employee> employeeList = employeeRepo.findAll();
				model.addAttribute("employeeList",employeeList);
				return "employeeListDelete";
			}
	  
	  
	  
	  @GetMapping("/showNewUpdateAdminForm/{id}")
		public String showNewUpdateAdminForm(@PathVariable ( value = "id") long id, Model model) {
			// create model attribute to bind form data
			AdminLogin newAdmin = loginAdminRepo.findById(id).get();
			model.addAttribute("newAdmin", newAdmin);
			return "update_admin";
		}
	  
	  
	  @GetMapping("/showNewUpdateLeadForm/{id}")
		public String showNewUpdateLeadForm(@PathVariable ( value = "id") long id, Model model) {
			// create model attribute to bind form data
			TeamLeadLogin newTeamLead = loginLeadRepo.findById(id).get();
			model.addAttribute("newTeamLead", newTeamLead);
			return "update_team_lead";
		}
	  
	  @GetMapping("/showNewUpdateEmployeeForm/{id}")
		public String showNewUpdateEmployeeForm(@PathVariable ( value = "id") long id, Model model) {
			// create model attribute to bind form data
			Employee newEmp = employeeRepo.findById(id).get();
			model.addAttribute("newEmp", newEmp);
			
			
			List<TeamsList> teamList = teamListRepo.findAll();
			model.addAttribute("teamList",teamList);
			
			List<DepartmentsList> depList = depRepo.findAll();
			model.addAttribute("depList",depList);
			
			List<ShiftsList> shiftsList = shiftsRepo.findAll();
			model.addAttribute("shiftsList",shiftsList);
			
			List<HybridSchedInfo> schedList = schedRepo.findAll();
			model.addAttribute("schedList",schedList);
			
			List<WorkType> workTypeList = workRepo.findAll();
			model.addAttribute("workTypeList",workTypeList);
			
			List<PTOinfo> ptoList = ptoRepo.findAll();
			model.addAttribute("ptoList",ptoList);
			
			return "update_employee";
		}
	  
	  
	  @PostMapping("/saveNewUpdateAdmin")
		public String saveNewUpdateAdmin(@ModelAttribute("newAdmin") AdminLogin newAdmin) {
			// save employee to database
			loginAdminRepo.save(newAdmin);
			return "redirect:/adminsList";
		}
	  
	  @PostMapping("/saveNewUpdateTeamLead")
		public String saveNewUpdateTeamLead(@ModelAttribute("newTeamLead") TeamLeadLogin newTeamLead) {
			// save employee to database
			loginLeadRepo.save(newTeamLead);
			return "redirect:/teamLeadList";
		}
	  
	  @PostMapping("/saveNewUpdateEmp")
			public String saveNewUpdateEmp(@ModelAttribute("newEmp") Employee newEmp) {
				// save employee to database
				employeeRepo.save(newEmp);
				return "redirect:/employeeList";
			}
	  
	   
	  
	  @GetMapping("/showNewDeleteForm")
			public String showNewDeleteForm(Model model) {
				// create model attribute to bind form data
//				Login newUser = new Login();
//				model.addAttribute("newUser", newUser);
				return "deletePage";
			}
	  
	  @GetMapping("/showNewDeleteFormPage")
			public String showNewDeleteFormPage(Model model) {
				// create model attribute to bind form data
//				Login newUser = new Login();
//				model.addAttribute("newUser", newUser);
				return "deletePageUsers";
			}
	  
	  
	  @GetMapping("/admin/delete/{id}")
		public String deleteAdmin(@PathVariable("id") long id, Model model)
		{
			loginAdminRepo.deleteById(id);
			return "redirect:/adminsListDelete";
		}
	  
	  @GetMapping("/teamlead/delete/{id}")
		public String deleteTeamLead(@PathVariable("id") long id, Model model)
		{
			loginLeadRepo.deleteById(id);
			return "redirect:/teamLeadListDelete";
		}
	  
	  @GetMapping("/employee/delete/{id}")
		public String deleteEmp(@PathVariable("id") long id, Model model)
		{
			employeeRepo.deleteById(id);
			return "redirect:/employeeListDelete";
		}
	  
	  
	  @GetMapping("/showNewAddDepartmentForm")
			public String showAddDepartmentForm(Model model) {
				// create model attribute to bind form data
			  DepartmentsList  newDepartment = new DepartmentsList ();
				model.addAttribute("newDepartment",  newDepartment);
				return "newDepartmentForm";
			}
	  

	  
	  @PostMapping("/saveNewDepartment")
			public String saveNewDepartment(@ModelAttribute("newDepartments") DepartmentsList newDepartments) {
				// save employee to database
				depRepo.save(newDepartments);
				return "redirect:/showDepartmentsList";
			}
	  
	  @GetMapping("/showDepartmentsList")
		public String showDepartmentsList(Model model) {
			
			List<DepartmentsList> depList = depRepo.findAll();
			model.addAttribute("depList",depList);
			return "showDepartmentsList";
		}
	  
	  @GetMapping("/showNewUpdateDepartmentForm/{id}")
		public String showNewUpdateDepartmentForm(@PathVariable ( value = "id") Integer id, Model model) {
			// create model attribute to bind form data
			DepartmentsList updateDep = depRepo.findById(id).get();
			model.addAttribute("updateDep", updateDep);
			return "update_form_department";
		}
	  
	  @PostMapping("/saveNewUpdateDep")
		public String saveNewUpdateDep(@ModelAttribute("updateDep") DepartmentsList updateDep) {
			// save employee to database
			depRepo.save(updateDep);
			return "redirect:/showDepartmentsList";
		}
	  
	  @GetMapping("/department/delete/{id}")
		public String deleteDep(@PathVariable("id") Integer id, Model model)
		{
			depRepo.deleteById(id);
			return "redirect:/showDepartmentsList";
		}
	  
	  //////////////////////////
	  
	  @GetMapping("/showNewAddTeamForm")
		public String showAddTeamForm(Model model) {
			// create model attribute to bind form data
		  TeamsList  newTeam = new TeamsList();
			model.addAttribute("newTeam",newTeam);
			return "newTeamForm";
		}
	  
	  @PostMapping("/saveNewTeam")
		public String saveNewTeam(@ModelAttribute("newTeam") TeamsList newTeam) {
			// save employee to database
			teamListRepo.save(newTeam);
			return "redirect:/showTeamsList";
		}
	  
	  @GetMapping("/showTeamsList")
			public String showTeamsList(Model model) {
				
				List<TeamsList> newTeam = teamListRepo.findAll();
				model.addAttribute("newTeam",newTeam);
				return "showTeamsList";
			}
	  
	  @GetMapping("/team/delete/{id}")
			public String deleteTeam(@PathVariable("id") Integer id, Model model)
			{
				teamListRepo.deleteById(id);
				return "redirect:/showTeamsList";
			}
	  
	  @GetMapping("/showNewUpdateTeamForm/{id}")
		public String showNewUpdateTeanForm(@PathVariable ( value = "id") Integer id, Model model) {
			// create model attribute to bind form data
			TeamsList newTeam = teamListRepo.findById(id).get();
			model.addAttribute("newTeam", newTeam);
			return "update_form_team";
		}
	  
	  @PostMapping("/saveNewUpdateTeam")
		public String saveNewUpdateTeam(@ModelAttribute("newTeam") TeamsList newTeam) {
			// save employee to database
			teamListRepo.save(newTeam);
			return "redirect:/showTeamsList";
		}
	  ////////////////////
	  
	  @GetMapping("/showNewAddSchedForm")
			public String showAddSchedForm(Model model) {
				// create model attribute to bind form data
			  ShiftsList  newSched = new ShiftsList();
				model.addAttribute("newSched",newSched);
				return "newSchedForm";
			}
		  
		  @PostMapping("/saveNewSched")
			public String saveNewSched(@ModelAttribute("newSched") ShiftsList newSched) {
				// save employee to database
				shiftsRepo.save(newSched);
				return "redirect:/showSchedList";
			}
		  
		  @GetMapping("/showSchedList")
			public String showSchedList(Model model) {
				
				List<ShiftsList> newSched = shiftsRepo.findAll();
				model.addAttribute("newSched",newSched);
				return "showSchedList";
			}
		  
		  @GetMapping("/sched/delete/{id}")
			public String deleteSched(@PathVariable("id") Integer id, Model model)
			{
				shiftsRepo.deleteById(id);
				return "redirect:/showSchedList";
			}
		  
		  @GetMapping("/showNewUpdateSchedForm/{id}")
			public String showNewUpdateSchedForm(@PathVariable ( value = "id") Integer id, Model model) {
				// create model attribute to bind form data
				ShiftsList newSched = shiftsRepo.findById(id).get();
				model.addAttribute("newSched", newSched);
				return "update_form_shift";
			}
		  
		  @PostMapping("/saveNewUpdateSched")
			public String saveNewUpdateSched(@ModelAttribute("newSched") ShiftsList newSched) {
				// save employee to database
				shiftsRepo.save(newSched);
				return "redirect:/showSchedList";
			}
		  
		  
		  @GetMapping("/showNewAddHybridSched")
			public String showAddHybridSched(Model model) {
				// create model attribute to bind form data
			  HybridSchedInfo  newHybridSched = new HybridSchedInfo  ();
				model.addAttribute("newHybridSched",  newHybridSched);
				return "newHybridSchedForm";
			}
	  

	  
	  @PostMapping("/saveNewHybridSched")
			public String saveNewHybridSched(@ModelAttribute("newHybridSched") HybridSchedInfo  newHybridSched) {
				// save employee to database
				schedRepo.save(newHybridSched);
				return "redirect:/showHybridSchedList";
			}
	  
	  @GetMapping("/showHybridSchedList")
		public String showHybridSchedList(Model model) {
			
			List<HybridSchedInfo> newHybridSched = schedRepo.findAll();
			model.addAttribute("newHybridSched",newHybridSched);
			return "showSchedList";
		}
}

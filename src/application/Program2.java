package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("======= Test 2: department findAll =======");		
		List<Department> list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}

		/*System.out.println("======= Test 3: department Insert =======");
		Department newDep = new Department(null, "Books");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		*/
		System.out.println("=== TEST 4: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Computer");
		departmentDao.update(department);
		System.out.println("Updated completed!");
		
		list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter the id to delete: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		sc.close();
		System.out.println("Delete completed!");
		
		list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
	}

}

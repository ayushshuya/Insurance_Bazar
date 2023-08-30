package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.VehicleDto;
import com.app.entities.User;
import com.app.entities.Vehicle;
import com.app.exception.ResourceNotFound;
import com.app.repository.VehicleEntityRepository;

@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private VehicleEntityRepository vehiclerepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IUserService userimp;

	@Override
	public Vehicle addNewVehicle(Vehicle newVehicle) {
		return vehiclerepo.save(newVehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehiclerepo.findAll();
	}

	@Override
	public Vehicle getVehicleById(Long Id) {
		Vehicle newVehicle = vehiclerepo.findById(Id)
				.orElseThrow(() -> new ResourceNotFound("Invalid Id, Vehicle not found!!!"));
		return newVehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle updatedcourse) {
		Vehicle updcourse = vehiclerepo.findById(updatedcourse.getId())
				.orElseThrow(() -> new ResourceNotFound("Invalid Id, Could not update!!!"));
		updcourse.setCompany(updatedcourse.getCompany());
		updcourse.setType(updatedcourse.getType());
		updcourse.setRegdate(updatedcourse.getRegdate());

		return updcourse;
	}

	@Override
	public String deleteVehicleDetails(Long userID) {
		String mesg = "Emp id invalid , can't delete emp details ";
		if (vehiclerepo.existsById(userID)) {
			vehiclerepo.deleteById(userID);
			mesg = "User with ID=" + userID + "  deleted !";
		}
		return mesg;
	}

	@Override
	public VehicleDto registerNewUser(VehicleDto UserResponseDto) {
		Vehicle user = this.mapper.map(UserResponseDto, Vehicle.class);
		Vehicle savedUser = this.vehiclerepo.save(user);
		return this.mapper.map(savedUser, VehicleDto.class);
	}

//	 @Override
//		public Vehicle addCourse(Vehicle newcourse) {
//			return vehiclerepo.save(newcourse);
//		}
//	

	@Override
	public Vehicle addStudent(VehicleDto newstudent) {

		Vehicle stud = mapper.map(newstudent, Vehicle.class);

		User course = userimp.getCourseById(newstudent.getUserId());

		stud.setUser(course);

		return vehiclerepo.save(stud);
	}

}

package com.bus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bus.dto.BusDto;
import com.bus.dto.FeedBackDto;
import com.bus.dto.ReservationDto;
import com.bus.dto.RouteDto;
import com.bus.dto.UserDto;
import com.bus.entity.Bus;
import com.bus.entity.FeedBack;
import com.bus.entity.Reservation;
import com.bus.entity.Route;
import com.bus.entity.User;
import com.bus.repository.BusRepository;
import com.bus.repository.FeedBackRepository;
import com.bus.repository.ReservationRepository;
import com.bus.repository.RouteRepository;
import com.bus.repository.UserRepository;
import com.bus.serviceImplementation.BusService;
import com.bus.serviceImplementation.FeedBackService;
import com.bus.serviceImplementation.ReservationService;
import com.bus.serviceImplementation.RouteService;
import com.bus.serviceImplementation.UserService;

@SpringBootTest
class BusReservationSystemApplicationTests {
	
	@Autowired
	private BusService busService;
	
	@MockBean
	private BusRepository busRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@MockBean
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RouteService routeService;
	
	@MockBean
	private RouteRepository routeRepository;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@MockBean
	private FeedBackRepository feedBackRepository;
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
  
	 @Test
	public void addBusTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		Bus bus = new Bus();
		BeanUtils.copyProperties(busDto, bus);
		when(busRepository.save(bus)).thenReturn(bus);
		assertEquals(busDto,busService.addBus(busDto));
			
	}
	
	@Test
	
	public void viewAllBusesTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		
		Bus bus = new Bus();
		List<BusDto> busDtoList = new ArrayList<>();
		busDtoList.add(busDto);
		List<Bus> busList = new ArrayList<>();
		
		for(BusDto busDto2 : busDtoList) {
			BeanUtils.copyProperties(busDto2, bus);
			busList.add(bus);
	
		}
		   
          when(busRepository.findAll()).thenReturn(busList);
                 assertEquals(1,busService.viewAllBuses().size());
		}
	
	  @Test
      public void viewBusByTypeTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
	
		List<BusDto> busDtoList = new ArrayList<>();
		busDtoList.add(busDto);
		Bus bus = new Bus();
		List<Bus> busList = new ArrayList<>();
		for(BusDto busDto1 : busDtoList) {
			BeanUtils.copyProperties(busDto1, bus);
			busList.add(bus);
		}
		
          when(busRepository.findByBusType("AC")).thenReturn(busList);
		  
          assertNotNull(busList);
	}
	
	@Test
    public void addReservationTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		UserDto userDto = new UserDto(1, "Niharika","bus","Niharika","Chamala",7780436621l,"niharika@gmail.com");
		
		Bus bus = new Bus();
		User user = new User();
		BeanUtils.copyProperties(busDto, bus);
		BeanUtils.copyProperties(userDto, user);
		
		ReservationDto reservationDto = new ReservationDto(1, "Reserved","Online", LocalDate.now(),
				LocalTime.now(),"Hyd","Bnglr", bus, user);
		
		Reservation reservation = new Reservation();
		  
		BeanUtils.copyProperties(reservationDto, reservation);
		when(reservationRepository.save(reservation)).thenReturn(reservation);
		assertEquals(reservationDto,reservationService.addReservation(reservationDto));

			
	}
	
	@Test
	public void viewAllReservationsTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		UserDto userDto = new UserDto( 1,"Niharika","bus","Niharika","Chamala",7780436621l,"niharika@gmail.com");
		
		Bus bus = new Bus();
		User user = new User();
		BeanUtils.copyProperties(busDto, bus);
		BeanUtils.copyProperties(userDto, user);
		
		ReservationDto reservationDto = new ReservationDto(1, "Reserved","Online", LocalDate.now(),
				LocalTime.now(),"Hyd","Bnglr", bus, user);

		Reservation reservation = new Reservation();
		List <ReservationDto> reservationDtoList = new ArrayList<>();
		reservationDtoList.add(reservationDto);
		List<Reservation> reservationList = new ArrayList<>();
		
		for(ReservationDto reservationDto2 : reservationDtoList) {
			BeanUtils.copyProperties(reservationDto2, reservation);
			reservationList.add(reservation);
	
		}
		   
          when(reservationRepository.findAll()).thenReturn(reservationList);
                 assertEquals(1,reservationService.viewAllReservation().size());
		
	}
	
	@Test
	public void getAllReservationTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		UserDto userDto = new UserDto(1, "Niharika","bus","Niharika","Chamala",7780436621l,"niharika@gmail.com");
		
		Bus bus = new Bus();
		User user = new User();
		BeanUtils.copyProperties(busDto, bus);
		BeanUtils.copyProperties(userDto, user);
		
		ReservationDto reservationDto = new ReservationDto(1, "Reserved","Online", LocalDate.now(),
				LocalTime.now(),"Hyd","Bnglr", bus, user);		
		
		List<ReservationDto> reservationDtoList = new ArrayList<>();
		reservationDtoList.add(reservationDto);
	        Reservation  reservation = new Reservation();
		   List<Reservation> reservationList = new ArrayList<>();
		for(ReservationDto reservationDto1 : reservationDtoList) {
			BeanUtils.copyProperties(reservationDto1,reservation);
			reservationList.add(reservation);
		}
		
          when(reservationRepository.findAllByReservationDate(null)).thenReturn(reservationList);
		  
          assertNotNull(reservationList);
	}
	     
	@Test
	public void addRouteTest() {
		
		BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
				LocalTime.now(), 30, 11);
		Bus bus = new Bus();
		
		List<BusDto> busDtoList = new ArrayList<>();
		List<Bus> busList = new ArrayList<>();
		busDtoList.add(busDto);
		for(BusDto busDto2 : busDtoList) {
			BeanUtils.copyProperties(busDto2, bus);
			busList.add(bus);
		}
    	Route route = new Route();
		RouteDto routeDto = new RouteDto(1,"Hyderabad","Chennai",700, busList);
	    BeanUtils.copyProperties(routeDto,route);
	    when(routeRepository.save(route)).thenReturn(route);
	
	   assertEquals(routeDto,routeService.addRoute(routeDto));
	}
	
	
	
	 @Test
	 public void addUserTest() {
		 
		 UserDto userDto = new UserDto(1,"Niharika","project","Niharika","Chamala",9874655263l,
					"niharika@gmail.com");
		 User user = new User();
	
		    BeanUtils.copyProperties(userDto,user);
		    when(userRepository.save(user)).thenReturn(user);
		
		   assertEquals(userDto,userService.addUser(userDto));
		}
	 
	 @Test
	 public void viewAllUsers() {
		 
		 UserDto userDto = new UserDto(1,"Niharika","project","Niharika","Chamala",9874655263l,
					"niharika@gmail.com");
		 
		 User user = new User();
			List <UserDto> userDtoList = new ArrayList<>();
			userDtoList.add(userDto);
			List<User> userList = new ArrayList<>();
			
			for(UserDto userDto2 : userDtoList) {
				BeanUtils.copyProperties(userDto2,user);
				userList.add(user);
		
			}
			   
	          when(userRepository.findAll()).thenReturn(userList);
	                 assertEquals(1,userService.viewAllUsers().size());
	 } 	 
	   @Test
	   public void addFeedbackTest() {
		   
		   UserDto userDto = new UserDto(1,"Niharika","project","Niharika","Chamala",9874655263l,
					"niharika@gmail.com");

		   BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
					LocalTime.now(), 30, 11);
		   
		   Bus bus = new Bus();
			User user = new User();
			BeanUtils.copyProperties(busDto, bus);
			BeanUtils.copyProperties(userDto, user);
		   
		   FeedBackDto feedBackDto = new FeedBackDto(1, 4, 3, 6, "Good",
					LocalDate.now(), user, bus);
		   
		   FeedBack feedBack = new FeedBack();
			
		    BeanUtils.copyProperties(feedBackDto,feedBack);
		    when(feedBackRepository.save(feedBack)).thenReturn(feedBack);
		
		   assertEquals(feedBackDto,feedBackService.addFeedBack(feedBackDto));   
	   }	
	   
	   @Test
	   public void viewAllFeedBacks() {
		   UserDto userDto = new UserDto(1,"Niharika","project","Niharika","Chamala",9874655263l,
					"niharika@gmail.com");

		   BusDto busDto = new BusDto(1,"Indu","Shankar","AC", "Hyd", "Bnglr",LocalTime.of(12, 3),
					LocalTime.now(), 30, 11);
		   
		   Bus bus = new Bus();
			User user = new User();
			BeanUtils.copyProperties(busDto, bus);
			BeanUtils.copyProperties(userDto, user);
		   
		   FeedBackDto feedBackDto = new FeedBackDto(1, 4, 3, 6, "Good",
					LocalDate.now(), user, bus);
		   
		   FeedBack feedBack = new FeedBack();
			List <FeedBackDto> feedBackDtoList = new ArrayList<>();
			feedBackDtoList.add(feedBackDto);
			List<FeedBack> feedBackList = new ArrayList<>();
			
			for(FeedBackDto feedBackDto2 : feedBackDtoList) {
				BeanUtils.copyProperties(feedBackDto2,feedBack);
				feedBackList.add(feedBack);
		
			}
			   
	          when(feedBackRepository.findAll()).thenReturn(feedBackList);
	                 assertEquals(1,feedBackService.viewAllFeedBack().size()); 
	   }
	}	

      
			
		
	
	


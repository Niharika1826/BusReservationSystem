package com.bus.exceptionController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.bus.exceptions.BusNotFoundException;
import com.bus.exceptions.FeedBackNotFoundException;
import com.bus.exceptions.ReservationNotFoundException;
import com.bus.exceptions.RouteNotFoundException;
import com.bus.exceptions.UserNotFoundException;


@ControllerAdvice
public class ExceptionController {
	
	   @ExceptionHandler(value = BusNotFoundException.class)
	 
	   public ResponseEntity<Object> handleBusException(Exception ex) {
		   return new ResponseEntity<Object>("Bus Not Found", HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(value = UserNotFoundException.class)
	   
	   public ResponseEntity<Object> handleUserException(Exception ex){
		   return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
	   }
	   	
       @ExceptionHandler(value = ReservationNotFoundException.class)
	   
	   public ResponseEntity<Object> handleReservationException(Exception ex){
		   return new ResponseEntity<Object>("Reservation Not Found",HttpStatus.NOT_FOUND);
	   }
       
       
       @ExceptionHandler(value = RouteNotFoundException.class)
	   
	   public ResponseEntity<Object> handleRouteException(Exception ex){
		   return new ResponseEntity<Object>("Route Not Found",HttpStatus.NOT_FOUND);
	   }

       @ExceptionHandler(value = FeedBackNotFoundException.class)
	   
	   public ResponseEntity<Object> handleFeedBackException(Exception ex){
		   return new ResponseEntity<Object>("FeedBack Not Found",HttpStatus.NOT_FOUND);
	   }

   
    

	 
		
	 }


package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Route;

public interface RouteRepository extends JpaRepository<Route,Integer> {

}

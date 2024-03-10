package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/applications")
@AllArgsConstructor
public class ApplicationsController extends BaseController {

}

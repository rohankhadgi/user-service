package com.thrumi.user.service;

import com.thrumi.user.VO.Department;
import com.thrumi.user.VO.ResponseTemplateVO;
import com.thrumi.user.entity.User;
import com.thrumi.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method in UserService");
        return userRepository.save(user);
    }

    public User findByUserId(Long userId) {
        log.info("Inside findByUserId method in UserService");
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method in UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
